package com.myhome.rpgkeyboard.activities.password

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface PwDao {
    @Query("SELECT * FROM tb_password")
    fun getAll(): List<PwEn>

    @Insert
    fun insertAll(vararg contacts: PwEn)

    @Delete
    fun delete(contacts: PwEn)
}