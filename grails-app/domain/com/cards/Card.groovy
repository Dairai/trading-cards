package com.cards

class Card {

    int number                          //future upgrade: make string for cards with char in card number

    static belongsTo = [cardSet: CardSet]
    static hasMany = [userCard:UserCard]

    static constraints = {
        number nullable:false
        number min: 0

        number(unique: 'cardSet')
    }
}
