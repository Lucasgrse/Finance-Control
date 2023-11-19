package com.example.financecontrol2.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MainLiteSQL(
    context: Context
) : SQLiteOpenHelper(
    context,
    DataBase.NAME_DB, null, DataBase.Version
) {
    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL(DataBase.user_tabel.CREATE_TABLE)
    }

    /**
     * Here I defined variables p1 as old and p2 as new
     * Will be executed when the version at constructor is different of installed
     * */
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}