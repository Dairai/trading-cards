package com.cards

class Card {

    int number

    static belongsTo = [set: CardSet]

    static constraints = {
    }
}
