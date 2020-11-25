package com.myhome.rpgkeyboard.activities.bank

import androidx.room.*

@Entity(tableName = "tb_bank")
data class BankEn(
    @PrimaryKey(autoGenerate = true) val id:Long,
    var name: String
)