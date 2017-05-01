package com.cards

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(CardSetService)
@Mock([CardSet,User,UserCard,Card, SpringSecurityService])
class CardSetServiceSpec extends Specification {

    def setup() {
        def testSet = new CardSet(year: 2013,
                 cardSetImageURL:"www.facebook.com" ,numCardsInSet: 1)
        def user1 = new User(firstName: "first", lastName: "last",username: "user1",email: "user1@test.com",
                password: "test").save(flush: true, failOnError: true)
        def newCard = new Card(number: 12324,cardSet: testSet).save(flush: true, failOnError: true)
        def newCard1 = new Card(number: 56789,cardSet: testSet).save(flush: true, failOnError: true)
        new UserCard(user: user1, card: newCard).save(flush: true, failOnError: true)
        new UserCard(user: user1, card: newCard1).save(flush: true, failOnError: true)

        //define the auth service
        def springUserService = Stub(SpringSecurityService)
        springUserService.getCurrentUser() >> user1
        service.springSecurityService = springUserService
    }

    def cleanup() {
    }

    void "test getUserSets method"() {
        when:"user card set is requested"
            List<Card> res = service.getUserSets()
        then:"user's cards are returned"
            res.size() == 2
            res.get(1).number == 56789
    }
}
