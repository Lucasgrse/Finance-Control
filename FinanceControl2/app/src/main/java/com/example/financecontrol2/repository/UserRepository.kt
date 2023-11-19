package com.example.financecontrol2.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.financecontrol2.db.DataBase
import com.example.financecontrol2.db.MainLiteSQL
import com.example.financecontrol2.model.FinanceUser

class UserRepository(var context: Context) {

    lateinit var bd: MainLiteSQL
    lateinit var connection: SQLiteDatabase

    init {
        this.bd = MainLiteSQL(this.context)
        this.connection = this.bd.writableDatabase
    }

    fun saveInfoUser(financeUser: FinanceUser): Boolean {
        val values =
            ContentValues() //create one object when you can fill with values and use to insert into DB

        values.put(DataBase.user_tabel.NAME_USER, financeUser.name)
        values.put(DataBase.user_tabel.VALUE_USER, financeUser.value)


        return this.connection.insert(
            DataBase.user_tabel.TABLE_NAME,
            null, values
        ) > 0

    }

    fun findAll(): List<FinanceUser?> {
        val userList = mutableListOf<FinanceUser>()
        val check: Cursor = this.connection.query(
            DataBase.user_tabel.TABLE_NAME, arrayOf(
                DataBase.user_tabel.NAME_USER,
                DataBase.user_tabel.VALUE_USER,
                DataBase.user_tabel.DATE_VALUE,
                DataBase.user_tabel.TYPE_ENTRY
            ), "id" + "name" + "value" + "date" + "typeEntry", arrayOf(), null, null, null
        )
        while (check.moveToNext()) {
            val id = check.getString(0)
            val name = check.getString(1)
            val value = check.getDouble(2)
            val date = check.getString(3)
            val typeEntry = check.getString(4)

            //creating a object with find values
            val financeUser = FinanceUser(id.toInt(), name, value, date, typeEntry.toInt())
            userList.add(financeUser)
        }
        return userList
    }
}