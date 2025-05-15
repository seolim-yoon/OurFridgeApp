package com.example.data.datasource.local.fridge.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Ingredient::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ingredientDao(): IngredientDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(
            context: Context
        ): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database"
                ).fallbackToDestructiveMigration()	// TODO : 마이그레이션 로직 추가
                    .build()
                INSTANCE = instance
                instance
            }
        }


    }
}