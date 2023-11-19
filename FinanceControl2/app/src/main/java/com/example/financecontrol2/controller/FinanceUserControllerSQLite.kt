package com.example.financecontrol2.controller

import android.content.Context
import com.example.financecontrol2.model.FinanceUser
import com.example.financecontrol2.repository.UserRepository

class FinanceUserControllerSQLite(var context: Context) {

    lateinit var repository: UserRepository

    init {
        repository = UserRepository(context)
    }

    fun getAllInfo(id: Int?): List<FinanceUser?> {
        if (id != null) {
            return repository.findAll()
        } else {
            return emptyList()
        }
    }

    fun saveAllInfo(name: String, value: Double, date: String): Boolean {
        if (!name.isEmpty() && !value.isNaN() && !date.isEmpty()) {
            val info = FinanceUser(name, value, date)

            return repository.saveInfoUser(info)
        } else {
            return false
        }
    }
}