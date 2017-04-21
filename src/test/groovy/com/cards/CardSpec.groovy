package com.cards

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Card)
class CardSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test for invalid Card"() {
        when:"new card is created with no number"
            Card newCard = new Card()

        then:"card is invalid"
            !newCard.validate()

        when:"new card is created with a number less than 0"
            newCard = new Card(number: -1)

        then:"Card is invalid"
            !newCard.validate()

        when:"new card is created with a valid number"
            CardSet testSet = new CardSet()
            newCard = new Card(number: 12324,set: testSet)

        then:"Card is valid"
            newCard.validate()
    }
}
