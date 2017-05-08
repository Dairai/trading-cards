package com.cards

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Sport)
class SportSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test sport object validation"() {
        when:"creating a sport without parameters"
            def sport = new Sport()
        then:"sport is not valid"
            !sport.validate()

        when:"creating a sport with wrong parameters"
            sport = new Sport(sportImage:"sports.jpeg" , sportName: "Lacrosse")
        then:"sport is not valid"
            !sport.validate()

        when:"creating a sport with valid parameters"
            sport = new Sport(sportImage:"sports.jpeg" , sportName: "Soccer")
        then:"sport is valid"
            sport.validate()

    }
}
