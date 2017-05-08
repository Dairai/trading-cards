package com.cards

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import grails.transaction.*
import org.springframework.security.core.context.SecurityContextHolder
import spock.lang.*
import geb.spock.*

import javax.security.auth.login.LoginException

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */

@Integration
@TestFor(CardSetController)
@Mock([CardSetController,User])
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

        when:"accessing secured page"
            go '/brand'

        then:"login redirect"
            title == "Login"

        when:"accessing secured page"
            go '/sport'

        then:"login redirect"
            title == "Login"

        when:"accessing secured page"
            go '/card'

        then:"login redirect"
            title == "Login"

        when:"accessing secured page"
            go '/cardSet'

        then:"login redirect"
            title == "Login"
    }

    void "test Page access"() {
        when:"publicly viewable page"
            go '/cardSet/searchByYear'
        then:"redirected to the correct page"
            title != "Login"

        when:"publicly viewable page"
            go '/cardSet/searchBySport'
        then:"redirected to the correct page"
            title != "Login"

        when:"publicly viewable page"
            go '/cardSet/searchByBrand'
        then:"redirected to the correct page"
            title != "Login"
    }
}
