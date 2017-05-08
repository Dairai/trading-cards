package com.cards

import groovy.transform.TupleConstructor

@TupleConstructor
class CardSet implements Serializable{

    int id
    int year
    String cardSetImageURL
    int numCardsInSet
    // future upgrade: include - string setName - which will allow for sub-sets

    static hasOne = [brand:Brand, sport:Sport]
    static hasMany = [cards:Card]

    static constraints = {
        year nullable:false
        year min: 1920
        year max: Calendar.getInstance().get(Calendar.YEAR)
        numCardsInSet min:1
        numCardsInSet max:1000
        id(unique: ['year','sport','brand'])
    }
}
