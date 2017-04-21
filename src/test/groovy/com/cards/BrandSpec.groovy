package com.cards

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Brand)
//@Mock(CardSet)
class BrandSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test card creation of Brand object"() {
        when: "New brand is created with no name"
            Brand newBrand = new Brand()

        then:"there object is not valid"
            !newBrand.validate()

        when: "New brand is created with a name"
            newBrand = new Brand(name: "Test Brand")

        then:"there object is valid"
            newBrand.validate()

    }

    void "Test card sets addition to the brand"() {
        when:"New brand is created with a card set"
            CardSet set = new CardSet()
            Brand newBrand = new Brand(name:"test brand")
            newBrand.cardSets.add(set)

        then:"Brand is valid"
            newBrand.validate()
    }
}
