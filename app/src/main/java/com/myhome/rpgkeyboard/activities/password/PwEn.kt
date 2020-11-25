package com.myhome.rpgkeyboard.activities.password

import androidx.room.*

@Entity(tableName = "tb_password")
data class PwEn(
    @PrimaryKey(autoGenerate = true) val id:Long,
    var name: String
)