package com.cards

import grails.transaction.Transactional

@Transactional
class CardSetService {

	def springSecurityService

    def getUserSets() {
	    def user = springSecurityService.getCurrentUser()
	    List usersets = CardSet.findAll()
	    return usersets
    }

	def getCardCount(List cardsInSet) {
		def cardcount = [:]
		cardsInSet.eachWithIndex { card, index ->
			cardcount << [index:2]
		}
		return cardcount
	}
}
