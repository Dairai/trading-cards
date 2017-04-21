package com.cards

class Card {

    int number

    static belongsTo = [set: CardSet]

    static constraints = {
        number nullable:false
        number min: 0
    }
}
