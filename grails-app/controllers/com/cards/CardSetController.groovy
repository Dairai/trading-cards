package com.cards

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CardSetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CardSet.list(params), model:[cardSetCount: CardSet.count()]
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