package com.example.financecontrol2.model

class FinanceUser {

    var id: Int = 0
    var name: String = ""
    var value: Double = 0.0
    var date: String = ""
    var typeEntry: Int = 0


    constructor(id: Int, name: String, value: Double, date: String, typeEntry: Int) { //Here I want recorver all information
        this.id = id
        this.name = name
        this.value = value
        this.date = date
        this.typeEntry = typeEntry
    }

    constructor( name: String, value: Double, date: String) { //Here I want recorver all information
        this.name = name
        this.value = value
        this.date = date
    }

    constructor(id: Int, name: String){ //only information from User
        this.id = id
        this.name = name
    }

    constructor(value: Double, date: String, typeEntry: Int){ //only information from values
        this.value = value
        this.date = date
        this.typeEntry = typeEntry
    }

}



