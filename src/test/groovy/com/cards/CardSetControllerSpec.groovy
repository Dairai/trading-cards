package com.cards

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
                cardSetImageURL: "www.youtube.com",numCardsInSet: 1,sport: sport1)//.save(flush: true, failOnError:true)
        def cardset2 = new CardSet(year: 2006 , brand: brand1,
                cardSetImageURL: "www.youtube.com",numCardsInSet: 1,sport: sport1)//.save(flush: true, failOnError:true)
        def card1 = new Card(number: 3,cardSet: cardset1)//.save(flush: true, failOnError:true)
        def card2 = new Card(number: 4,cardSet: cardset2)//.save(flush: true, failOnError:true)

        cardset1.addToCards(card1)
        cardset2.addToCards(card2)
        card1.save(failOnError:true)
        card2.save(failOnError:true)
        cardset1.save(failOnError:true)
        cardset2.save(flush: true, failOnError:true)
    }

    def cleanup() {
    }

    void "test showAllCardSets method"() {
        when:"retrieving all card sets"
            controller.showAllCardSets()
        then:"return the index view"
            view == "/cardSet/searchType"
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
            res.size() == 2
            res.get(0) == 2003
            res.get(1) == 2006
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
}
