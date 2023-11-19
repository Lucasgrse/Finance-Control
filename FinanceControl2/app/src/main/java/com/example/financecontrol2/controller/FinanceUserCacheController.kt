package com.example.financecontrol2.controller

import android.content.Context
import com.example.financecontrol2.model.FinanceUser
import com.example.financecontrol2.tools.ManageCache

class FinanceUserCacheController(var context: Context) {

    lateinit var cache: ManageCache

    init {
        cache = ManageCache(context)
    }

    //Here will register one information
    fun saveAllInfo(name: String, value: Double, date: String): Boolean {
        if (!name.isEmpty() && !value.isNaN() && !date.isEmpty()) {
            val info = FinanceUser(name, value, date)

            return cache.saveInfoCache(info)
        } else {
            return false //some information is wrong
        }
    }

    fun getAllInfo(id: Int?): FinanceUser? {
        if (id != null) {
            return cache.findAll(id)
        } else {
            return null
        }
    }
}