package com.cards

class Brand {

    String name

    static hasMany = [cardSets: CardSet]

    static constraints = {
    }
}
