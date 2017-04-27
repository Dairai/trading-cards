package com.cards

import groovy.transform.TupleConstructor

@TupleConstructor
class CardSet {

    int year
    // future upgrade: include - string setName - which will allow for sub-sets

    static hasOne = [brand:Brand, sport:Sport]
    static hasMany = [cards:Card]

    static constraints = {
        year nullable:false
        year min: 1920
        year max: Calendar.getInstance().get(Calendar.YEAR)
        brand(unique:'year')
    }
}
