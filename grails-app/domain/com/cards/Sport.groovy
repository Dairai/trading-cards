package com.cards

class Sport {

    String sportName
    String sportImage

    String toString() {
        return sportName
    }

    static hasMany = [cardSets:CardSet]

    static constraints = {
        sportName inList: ['Baseball', 'Hockey', 'Football', 'Soccer', 'Basketball']
    }
}
