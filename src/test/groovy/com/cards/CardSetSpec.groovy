package com.cards

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CardSet)
class CardSetSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test for invalid card set"() {
        when:"a new card set is created"
            CardSet testSet = new CardSet()

        then:"card set is invalid"
            !testSet.validate()

        when:"a card set is created with a brand and year over 2100"
            Brand brand = new Brand(name: "Test brand")
            testSet  = new CardSet(year: 2106, brand: brand)

        then:"the object is invalid"
            !testSet.validate()

        when:"a card set is created with a brand and incorrect year below 1960"
            brand = new Brand(name: "Test brand")
            testSet  = new CardSet(year: 1900, brand: brand)

        then:"the object is invalid"
            !testSet.validate()

        when:"a card set is created with a brand and year"
            testSet  = new CardSet(year: 2013, brand: brand)

        then:"the object is valid"
            testSet.validate()
    }

    void "test for unique name and year"()
    {
        when:"a card set is created with a brand and year below 2013"
            Brand brand = new Brand(name: "Test brand")
            CardSet testSet1  = new CardSet( year: 2013, brand: brand).save()

        then:"the object is valid"
            testSet1.validate()

        when:"another card set is created with the same brand and year"
            CardSet testSet2  = new CardSet(year: 2013, brand: brand).save()

        then:"the object is valid"
            testSet2.validate()
    }
}
