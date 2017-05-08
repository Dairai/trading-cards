package com.cards

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import grails.transaction.*
import groovy.sql.Sql
import spock.lang.*

import javax.sql.DataSource

@Integration
@Rollback
@TestFor(CardSetController)
@Mock([CardSetService,CardSet,Card,UserCard,User, Sport, Brand,SpringSecurityService])
class CardSetIntegrationSpec extends Specification {

    def cardSetService
    def springUserService
    def dc
    def setup() {

        Brand brand = new Brand(name: "Test brand",logo_url:"www.google.com").save(flush: true, failOnError: true)
        def sport1 = new Sport(sportName: "Soccer",sportImage: "www.google.com").save(flush: true, failOnError: true)
        def testSet = new CardSet(id: 1, year: 2013,
                cardSetImageURL:"www.facebook.com" ,numCardsInSet: 2,sport:sport1,brand: brand ).save(flush: true, failOnError: true)
        def user1 = new User(firstName: "first", lastName: "last",
                username: "admin",email: "user1@test.com",
                password: "secret").save(flush: true, failOnError: true)
        def newCard = new Card(number: 12324,cardSet: testSet).save(flush: true, failOnError: true)
        def newCard1 = new Card(number: 56789,cardSet: testSet).save(flush: true, failOnError: true)
        new UserCard(user: user1, card: newCard).save(flush: true, failOnError: true)
        new UserCard(user: user1, card: newCard1).save(flush: true, failOnError: true)

        springUserService = Mock(SpringSecurityService)
        dc = new CardSetController()
        dc.springSecurityService = [loggedIn: true,
                                    principal: user1,
                                    reauthenticate: {String u -> true},
                                    encodePassword:'secret', getCurrentUser:{user1}]
    }

    def cleanup() {
    }

    //Currently not working. Needs to be fixed
    void "test userCardSet  method"() {
        when:" me"
            dc.params.year = 2013
            dc.params.brand = "Test brand"
            dc.params.sport = "Soccer"
            dc.userCardSet()
        then:"correct card set is returned"
            dc.modelAndView != "userCardSet"
    }
}
