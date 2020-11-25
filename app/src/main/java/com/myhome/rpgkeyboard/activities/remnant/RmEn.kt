package com.myhome.rpgkeyboard.activities.remnant

import androidx.room.*

@Entity(tableName = "tb_remnant")
data class RmEn(
    @PrimaryKey(autoGenerate = true) val id:Long,
    var name: String
)