package com.myhome.rpgkeyboard.activities.address

import androidx.room.*

@Entity(tableName = "tb_address")
data class AddressEn(
    @PrimaryKey(autoGenerate = true) val id:Long,
    var name: String
)