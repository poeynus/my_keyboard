package com.myhome.rpgkeyboard.activities.email

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmailDao {
    @Query("SELECT * FROM tb_email")
    fun getAll(): List<EmailEn>

    @Insert
    fun insertAll(vararg contacts: EmailEn)

    @Delete
    fun delete(contacts: EmailEn)
}