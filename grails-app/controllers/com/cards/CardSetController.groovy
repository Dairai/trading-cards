package com.cards

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import groovy.sql.Sql
import groovy.sql.GroovyRowResult

@Transactional(readOnly = true)
@Secured([Role.ROLE_ADMIN])
class CardSetController {

	static scaffold = CardSet

	def springSecurityService
	def CardSetService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CardSet.list(params), model:[cardSetCount: CardSet.count()]
    }

    @Secured([Role.ROLE_USER,Role.ROLE_ANONYMOUS,Role.ROLE_ADMIN])
    def showAllCardSets() {
        render view: 'searchType'
    }

	@Secured([Role.ROLE_USER,Role.ROLE_ANONYMOUS,Role.ROLE_ADMIN])
    def searchByBrand() {
        List allBrands = Brand.findAll()
        render view: 'byBrand', model:[brands:allBrands]
    }

    @Secured([Role.ROLE_USER,Role.ROLE_ANONYMOUS,Role.ROLE_ADMIN])
    def showBrand() {
        def brand = Brand.get(params.id)
        List brandCardSets = CardSet.findAllByBrand(brand)
        brandCardSets = brandCardSets.sort{it.year}
        render view: 'showBrand', model:[brandcardsets:brandCardSets]
    }

    @Secured([Role.ROLE_USER,Role.ROLE_ANONYMOUS,Role.ROLE_ADMIN])
    def searchByYear() {
		def allYears = CardSet.findAll().year
		allYears = allYears.sort{it}.unique()
        render view: 'byYear', model:[years:allYears]
    }

	@Secured([Role.ROLE_USER,Role.ROLE_ANONYMOUS,Role.ROLE_ADMIN])
    def searchBySport() {
        List allSports = Sport.findAll()
        render view: 'bySport', model:[sports:allSports]
    }

    @Secured([Role.ROLE_USER,Role.ROLE_ANONYMOUS,Role.ROLE_ADMIN])
    def showCardSet() {
		def year = params.year
	    def brandname = params.brand
	    def brand = Brand.findByName(brandname)
	    def sportname = params.sport
	    def sport = Sport.findBySportName(sportname)
        def thiscardset = CardSet.findByYearAndBrandAndSport(year,brand,sport)
	    List cardsInSet = Card.findAllByCardSet(thiscardset)
	    def cardCount = CardSetService.getCardCount(cardsInSet)
        render view: 'showCardSet', model:[thiscardset:thiscardset, cardcount:cardCount]
    }

    @Secured([Role.ROLE_USER,Role.ROLE_ADMIN])
    def userSets() {
		def usersets = CardSetService.getUserSets()
        render view: 'showUserSets', model: [usersets:usersets]
    }

	@Secured([Role.ROLE_USER,Role.ROLE_ADMIN])
	def myTrades() {
		render view: 'myTrades'
	}

    @Secured([Role.ROLE_ADMIN, Role.ROLE_USER])
    def userInput() {
        render view: 'userInput'
    }

    def show(CardSet cardSet) {
        respond cardSet
    }

    def create() {
        respond new CardSet(params)
    }

    @Transactional
    def save(CardSet cardSet) {
        if (cardSet == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cardSet.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cardSet.errors, view:'create'
            return
        }

        cardSet.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cardSet.label', default: 'CardSet'), cardSet.id])
                redirect cardSet
            }
            '*' { respond cardSet, [status: CREATED] }
        }
    }

    def edit(CardSet cardSet) {
        respond cardSet
    }

    @Transactional
    def update(CardSet cardSet) {
        if (cardSet == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cardSet.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cardSet.errors, view:'edit'
            return
        }

        cardSet.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cardSet.label', default: 'CardSet'), cardSet.id])
                redirect cardSet
            }
            '*'{ respond cardSet, [status: OK] }
        }
    }

    @Transactional
    def delete(CardSet cardSet) {

        if (cardSet == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        cardSet.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cardSet.label', default: 'CardSet'), cardSet.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cardSet.label', default: 'CardSet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
