package com.cards

import grails.transaction.Transactional

@Transactional
class CardSetService {

	def springSecurityService

    def getUserSets() {
	    def user = springSecurityService.getCurrentUser()
	    List usercards = UserCard.findAllByUser(user)
        List cards = usercards.card

	    List sets = []

	    return cards
    }
}
