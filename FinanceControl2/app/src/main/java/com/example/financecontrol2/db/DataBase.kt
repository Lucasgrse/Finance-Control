package com.example.financecontrol2.db

class DataBase {

    companion object { // Creating the name and version of the lite database

        val NAME_DB = "finance_control"
        val Version = 1
    }

    object user_tabel {

        val TABLE_NAME = "user"
        val ID = "id"
        val NAME_USER = "name"
        val VALUE_USER = "value"
        val DATE_VALUE = "date"
        val TYPE_ENTRY = "entry"
        val CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME" + "($ID INTEGER PRIMARRY KEY AUTOINCREMENT, " +
                    "$NAME_USER text, $VALUE_USER real, $DATE_VALUE text, $TYPE_ENTRY integer)"
    }

}