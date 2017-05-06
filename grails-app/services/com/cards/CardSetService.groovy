package com.cards

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class CardSetService {

	def springSecurityService

    def getUserSets() {
	    def user = springSecurityService.getCurrentUser()
	    List usersets = CardSet.findAll()
	    return usersets
    }

	def getUserPerCardCount(int id) {
		def cardcount = [:]
        def currentUser = springSecurityService.getCurrentUser()
        def currentCardSet = CardSet.findById(id)

        def dataSource
        /*def results = {
            def sql = new Sql(dataSource)
            [temp: sql.rows("SELECT card.number, qty \n" +
                            "FROM card_set, card, user_card, user\n" +
                            "WHERE   user_card.card_id = card.id \n" +
                            "AND user_card.user_id = user.id \n" +
                            "AND card_set.id = 1\n" +
                            "AND user.id = 5;")]
        }*/

        def sql = new Sql(dataSource)
        def rows = sql.rows("SELECT card.number, qty \\n\" +\n" +
                "                            \"FROM card_set, card, user_card, user\\n\" +\n" +
                "                            \"WHERE   user_card.card_id = card.id \\n\" +\n" +
                "                            \"AND user_card.user_id = user.id \\n\" +\n" +
                "                            \"AND card_set.id = 1\\n\" +\n" +
                "                            \"AND user.id = 5;")
        sql.close()

		return rows
	}
}
