package com.example.financecontrol2.tools

import android.content.Context
import android.content.SharedPreferences
import com.example.financecontrol2.model.FinanceUser

class ManageCache(var context: Context) {

    var cacheName: SharedPreferences = context.getSharedPreferences(
        "name",
        Context.MODE_PRIVATE
    )
    var cacheDate: SharedPreferences = context.getSharedPreferences(
        "date",
        Context.MODE_PRIVATE
    )
    var cacheValue: SharedPreferences = context.getSharedPreferences(
        "value",
        Context.MODE_PRIVATE
    )
    var cacheId: SharedPreferences = context.getSharedPreferences(
        "id",
        Context.MODE_PRIVATE
    )

    init {
        cacheName
        cacheDate
        cacheValue

    }

    fun saveInfoCache(info: FinanceUser): Boolean {

        val editName = cacheName.edit()
        editName.putString(info.name, info.date)

        val editValue = cacheValue.edit()
        editValue.putInt(info.value.toString(), info.date.toInt())

        return editValue.commit() && editName.commit()
    }

    fun findAll(id: Int?): FinanceUser? {
        val name = cacheName.getString(id.toString(), "")
        val value = cacheValue.getString(id.toString(), "")
        val date = cacheDate.getString(id.toString(), "")

        if (name != null && value != null && !name.isEmpty() && !value.isEmpty()) {
            return FinanceUser(name.toString(), value.toDouble(), date!!)
        } else {
            return null
        }
    }
}