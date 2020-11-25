package com.myhome.rpgkeyboard

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myhome.rpgkeyboard.activities.address.AddressDao
import com.myhome.rpgkeyboard.activities.address.AddressEn
import com.myhome.rpgkeyboard.activities.bank.BankDao
import com.myhome.rpgkeyboard.activities.bank.BankEn
import com.myhome.rpgkeyboard.activities.email.EmailDao
import com.myhome.rpgkeyboard.activities.email.EmailEn
import com.myhome.rpgkeyboard.activities.password.PwDao
import com.myhome.rpgkeyboard.activities.password.PwEn
import com.myhome.rpgkeyboard.activities.remnant.RmDao
import com.myhome.rpgkeyboard.activities.remnant.RmEn


@Database(entities = arrayOf(BankEn::class, AddressEn::class, EmailEn::class, PwEn::class, RmEn::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bankDao(): BankDao
    abstract fun addressDao(): AddressDao
    abstract fun emailDao(): EmailDao
    abstract fun pwDao(): PwDao
    abstract fun rmDao(): RmDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database-contacts"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}
