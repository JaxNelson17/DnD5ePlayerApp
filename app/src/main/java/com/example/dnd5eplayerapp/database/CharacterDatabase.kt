package com.example.dnd5eplayerapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

//@Database(entities = [Character::class], version = 1, exportSchema = false)
//
//abstract class CharacterDatabase : RoomDatabase() {
//
//    abstract val characterDao: CharacterDao
//
//    companion object {
//        @Volatile private var instance: CharacterDatabase? = null
//
//        //creates instance of db
//        fun getInstance(context: Context): CharacterDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//        }
//
//        //actually builds the db
//        private fun buildDatabase(context: Context): UserDatabase {
//            return Room.databaseBuilder(context, UserDatabase::class.java, DATABASE_NAME)
//                .addCallback(
//                    object : Callback() {
//                        override fun onCreate(db: SupportSQLiteDatabase) {
//                            super.onCreate(db)
//                            val request = OneTimeWorkRequestBuilder<DatabaseWorker>().build()
//                        }
//                    }
//                )
//                .build()
//        }
//
//    }
//}