package com.cards

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserCardController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserCard.list(params), model:[userCardCount: UserCard.count()]
    }

    def show(UserCard userCard) {
        respond userCard
    }

    def create() {
        respond new UserCard(params)
    }

    @Transactional
    def save(UserCard userCard) {
        if (userCard == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (userCard.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond userCard.errors, view:'create'
            return
        }

        userCard.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userCard.label', default: 'UserCard'), userCard.id])
                redirect userCard
            }
            '*' { respond userCard, [status: CREATED] }
        }
    }

    def edit(UserCard userCard) {
        respond userCard
    }

    @Transactional
    def update(UserCard userCard) {
        if (userCard == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (userCard.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond userCard.errors, view:'edit'
            return
        }

        userCard.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'userCard.label', default: 'UserCard'), userCard.id])
                redirect userCard
            }
            '*'{ respond userCard, [status: OK] }
        }
    }

    @Transactional
    def delete(UserCard userCard) {

        if (userCard == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        userCard.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'userCard.label', default: 'UserCard'), userCard.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userCard.label', default: 'UserCard'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
