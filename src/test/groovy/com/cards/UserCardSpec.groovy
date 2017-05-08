package com.cards

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(UserCard)
class UserCardSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test UserCard domain"() {
        when:"creating a user card without parameters"
            def usercard = new UserCard()
        then:"sport is not valid"
            !usercard.validate()

        when:"user card with valid parameters"
            usercard = new UserCard(qty: 1, card: new Card(),user: new User())
        then:"Card is invalid"
            usercard.validate()
    }
}
