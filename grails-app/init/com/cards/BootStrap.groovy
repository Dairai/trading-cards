package com.cards

import com.cards.User
import com.cards.Role
import com.cards.UserRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

    }

	def saveObject(object) {
		if (!object.save(flush:true)) {
			object.errors.allErrors.each { println it }
		}
	}

    def destroy = {
    }
}
