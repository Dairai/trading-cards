package com.cards

import grails.test.mixin.*
import spock.lang.*

@TestFor(CardController)
@Mock(Card)
class CardControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        CardSet testSet = new CardSet()
        params["number"] = 12345
        params["cardSet"] = testSet
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.cardList
            model.cardCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.card!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def card = new Card()
            card.validate()
            controller.save(card)

        then:"The create view is rendered again with the correct model"
            model.card!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            card = new Card(params)

            controller.save(card)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/card/show/1'
            controller.flash.message != null
            Card.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def card = new Card(params)
            controller.show(card)

        then:"A model is populated containing the domain instance"
            model.card == card
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def card = new Card(params)
            controller.edit(card)

        then:"A model is populated containing the domain instance"
            model.card == card
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/card/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def card = new Card()
            card.validate()
            controller.update(card)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.card == card

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            card = new Card(params).save(flush: true)
            controller.update(card)

        then:"A redirect is issued to the show action"
            card != null
            response.redirectedUrl == "/card/show/$card.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/card/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def card = new Card(params).save(flush: true)

        then:"It exists"
            Card.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(card)

        then:"The instance is deleted"
            Card.count() == 0
            response.redirectedUrl == '/card/index'
            flash.message != null
    }
}
