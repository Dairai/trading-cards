package com.cards

import grails.transaction.Transactional
import org.hibernate.Query
import org.hibernate.Session
import org.hibernate.Transaction

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

        String hql = "FROM UserCard"
        Query query = session.createQuery(hql)
        List results = query.list()



		return results
	}
}
