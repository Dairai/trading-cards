package com.cards

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

import javax.security.auth.login.LoginException

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
//@Rollback
class CardSetFunctionalSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test home page connection"() {
        when:"The home page is visited"
            go '/'

        then:"The title is correct"
        	title == "Welcome to LFC"
    }

    void "test login page redirect"() {
        when:"a non-login page is visited"
            go '/createCard/create'

        then:"login redirect"
            title == "Login"
    }
}
