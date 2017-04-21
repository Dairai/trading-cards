package com.cards

import groovy.transform.TupleConstructor

@TupleConstructor
class CardSet {

    int year
    Brand brand
    def cards = []

    static constraints = {
        year nullable:false
        year min: 1920
        year max: Calendar.getInstance().get(Calendar.YEAR)
        brand(unique:'year')
    }
}
