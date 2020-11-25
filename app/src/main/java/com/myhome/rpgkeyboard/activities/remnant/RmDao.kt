package com.myhome.rpgkeyboard.activities.remnant

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RmDao {
    @Query("SELECT * FROM tb_remnant")
    fun getAll(): List<RmEn>

    @Insert
    fun insertAll(vararg contacts: RmEn)

    @Delete
    fun delete(contacts: RmEn)
}