package com.cards

class CardSet {

    int year
    static hasMany = [cards:Card]

    static hasOne = [brand:Brand]

    static constraints = {
        unique: ['year','brand']
    }
}
