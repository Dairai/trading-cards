package com.cards

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CardSetController)
@Mock([Brand,CardSet,Sport,Card])
class CardSetControllerSpec extends Specification {

    def setup() {
        def brand1 = new Brand(logo_url: "www.google.com",name: "Brand new 1").save(flush: true, failOnError:true)
        def brand2 = new Brand(logo_url: "www.sweets.com",name: "Brand new 2").save(flush: true, failOnError:true)
        def sport1 = new Sport(sportImage: "www.espn.com",sportName: "Soccer").save(flush: true, failOnError:true)
        def cardset1 = new CardSet(year: 2003 , brand: brand1,
                cardSetImageURL: "www.google.com",numCardsInSet: 1,sport: sport1).save(flush: true, failOnError:true)
        def cardset2 = new CardSet(year: 2006 , brand: brand2,
                cardSetImageURL: "www.youtube.com",numCardsInSet: 1,sport: sport1).save(flush: true, failOnError:true)
        def card1 = new Card(number: 3,cardSet: cardset1).save(flush: true, failOnError:true)
        def card2 = new Card(number: 4,cardSet: cardset2).save(flush: true, failOnError:true)

        cardset1.addToCards(card1)
        cardset2.addToCards(card2)
        card1.save(failOnError:true)
        card2.save(failOnError:true)
        //cardset1.save(failOnError:true)
        //cardset2.save(failOnError:true)

    }

    def populateValidParams(params) {
        assert params != null

        params["id"] = 12345
        params["year"] = 2002
        params["cardSetImageURL"] = "cardset.png"
        params["numCardsInSet"] = 4
        params["brand"] = new Brand()
        params["sport"] = new Sport()
    }

    def cleanup() {
    }

    void "test searchByBrand method"(){
        when:"retrieving brands"
            controller.searchByBrand()
        then:"return brand list and brand view"
            view == "/cardSet/byBrand"
            List res = (List<Brand>) model.get("brands")
            res.size() == 2
            res.get(0).name == "Brand new 1"
            res.get(1).logo_url == "www.sweets.com"
    }

    void "test searchByYear method"(){
        when:"retrieving available years"
            controller.searchByYear()
        then:"return all years"
            view == "/cardSet/byYear"
            List res= (List<Integer>) model.get("years")
            res.get(0) == 2006
    }

    void "test searchBySport method"(){
        when:"retrieving all sports"
            controller.searchBySport()
        then:"return all the sports"
            view == "/cardSet/bySport"
            List res = (List<Sport>) model.get("sports")
            res.size() == 1
            res.get(0).sportName == "Soccer"
    }

    void "test showAllCardSets method"() {
        when:"retrieving all card sets"
            controller.showAllCardSets()
        then:"return the search type view"
            view == "/cardSet/searchType"
    }

    void "test showYear method"() {
        when:"retrieving all card sets"
            controller.showYear()
        then:"return the search type view"
            view == "/cardSet/showYear"
    }

    void "test showSport method"() {
        when:"retrieving all card sets"
            controller.showSport()
        then:"return the search type view"
            view == "/cardSet/showSport"
    }

    void "test showBrand method"(){
        when:"show brand"
            controller.showBrand()
        then:"return the brand view"
            view == "/cardSet/showBrand"
    }

    void "test myTrades method"(){
        when:"show my trades"
            controller.myTrades()
        then:"return the my trades view"
            view == "/cardSet/myTrades"
    }

    void "test userInput method"(){
        when:"show user input"
            controller.userInput()
        then:"return the user input view"
            view == "/cardSet/userInput"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            model.cardSetList
            model.cardSetCount == 1
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.cardSet!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def card = new CardSet()
            card.validate()
            controller.save(card)

        then:"The create view is rendered again with the correct model"
            model.cardSet!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            card = new CardSet(params)

        controller.save(card)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/cardSet/index'
            controller.flash.message != null
            CardSet.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def card = new CardSet(params)
            controller.show(card)

        then:"A model is populated containing the domain instance"
            model.cardSet == card
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def card = new CardSet(params)
            controller.edit(card)

        then:"A model is populated containing the domain instance"
            model.cardSet == card
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/cardSet/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def card = new CardSet()
            card.validate()
            controller.update(card)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.cardSet == card

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            card = new CardSet(params).save(flush: true)
            controller.update(card)

        then:"A redirect is issued to the show action"
            card != null
            response.redirectedUrl == "/cardSet/index"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/cardSet/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def card = new CardSet(params).save(flush: true)

        then:"It exists"
            CardSet.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(card)

        then:"The instance is deleted"
            CardSet.count() == 0
            response.redirectedUrl == '/cardSet/index'
            flash.message != null
    }

}
