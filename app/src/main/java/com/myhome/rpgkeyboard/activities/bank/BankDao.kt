package com.myhome.rpgkeyboard.activities.bank

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BankDao {
    @Query("SELECT * FROM tb_bank")
    fun getAll(): List<BankEn>

    @Insert
    fun insertAll(vararg contacts: BankEn)

    @Delete
    fun delete(contacts: BankEn)

}