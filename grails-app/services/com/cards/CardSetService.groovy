package com.cards

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class CardSetService {

	def springSecurityService
	def dataSource

	def getUserSets() {
		def user = springSecurityService.getCurrentUser()
		List usersets = CardSet.findAll()
		return usersets
	}

	def allUsersCardCount(int id) {
		def sql = Sql.newInstance(dataSource)
		def totalCardCount = sql.rows("SELECT card.number, SUM(qty) qty\n" +
				"FROM card_set, card, user_card\n" +
				"WHERE card_set.id = card.card_set_id\n" +
				"AND user_card.card_id = card.id\n" +
				"AND card_set.id = ${id}\n" +
				"GROUP BY card.number ORDER BY card.number;")
		sql.close()
		return totalCardCount
	}

	def currentUserCardCount(long userid, int setid, int numcards) {
		def sql = Sql.newInstance(dataSource)
		def cardsThisUser = sql.rows("SELECT card.number, qty\n" +
				"FROM card_set, card, user_card, user\n" +
				"WHERE   user_card.card_id = card.id\n" +
				"AND user_card.user_id = user.id\n" +
				"AND card_set.id = card.card_set_id\n" +
				"AND card_set_id = ${setid}\n" +
				"AND user.id = ${userid}\n" +
				"ORDER BY card.number;")
		sql.close()

		if(cardsThisUser == []) {
			for (def i=1; i <= numcards; i++) {
				def temp = ['number':i, qty:0]
				cardsThisUser << temp
			}
		}
		return cardsThisUser
	}
}
