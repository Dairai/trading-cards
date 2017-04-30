package com.cards

class UserCard {

    int qty

    static hasOne = [user:User, card:Card]

    static constraints = {
        // need constraint for unique: user / card
    }
}
