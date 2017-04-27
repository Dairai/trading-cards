package com.cards

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SportController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Sport.list(params), model:[sportCount: Sport.count()]
    }

    def show(Sport sport) {
        respond sport
    }

    def create() {
        respond new Sport(params)
    }

    @Transactional
    def save(Sport sport) {
        if (sport == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (sport.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond sport.errors, view:'create'
            return
        }

        sport.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sport.label', default: 'Sport'), sport.id])
                redirect sport
            }
            '*' { respond sport, [status: CREATED] }
        }
    }

    def edit(Sport sport) {
        respond sport
    }

    @Transactional
    def update(Sport sport) {
        if (sport == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (sport.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond sport.errors, view:'edit'
            return
        }

        sport.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sport.label', default: 'Sport'), sport.id])
                redirect sport
            }
            '*'{ respond sport, [status: OK] }
        }
    }

    @Transactional
    def delete(Sport sport) {

        if (sport == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        sport.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sport.label', default: 'Sport'), sport.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sport.label', default: 'Sport'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
