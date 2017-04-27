package com.cards

class Brand {

    String name
    String logo_url

    static hasMany = [cardSets: CardSet]

    static constraints = {
    }
}
