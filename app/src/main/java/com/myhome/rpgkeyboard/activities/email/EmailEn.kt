package com.myhome.rpgkeyboard.activities.email

import androidx.room.*

@Entity(tableName = "tb_email")
data class EmailEn(
    @PrimaryKey(autoGenerate = true) val id:Long,
    var name: String
)