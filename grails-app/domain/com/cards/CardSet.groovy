package com.cards

import groovy.transform.TupleConstructor

@TupleConstructor
class CardSet implements Serializable{

    int year
    String cardSetImageURL
    int numCardsInSet
    // future upgrade: include - string setName - which will allow for sub-sets

    static hasOne = [brand:Brand, sport:Sport]
    static hasMany = [cards:Card]

    static mapping = {
        id composite: ['year','sport','brand']
    }

    static constraints = {
        year nullable:false
        year min: 1920
        year max: Calendar.getInstance().get(Calendar.YEAR)
        //brand(unique:['year','sport'])   // need to fix this...not working as intended - I added the sport part, and now not working....thought I did it right with the brackets
        numCardsInSet min:1
        numCardsInSet max:1000
    }
}
