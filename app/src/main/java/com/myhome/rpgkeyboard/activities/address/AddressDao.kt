package com.myhome.rpgkeyboard.activities.address

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AddressDao {
    @Query("SELECT * FROM tb_address")
    fun getAll(): List<AddressEn>

    @Insert
    fun insertAll(vararg contacts: AddressEn)

    @Delete
    fun delete(contacts: AddressEn)
}