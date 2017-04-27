package com.cards

class Sport {

    String sport

    static belongsTo = [cardsets: CardSet]

    static constraints = {
    }
}
