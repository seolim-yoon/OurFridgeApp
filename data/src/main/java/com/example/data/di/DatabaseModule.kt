package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.datasource.local.fridge.database.AppDatabase
import com.example.data.datasource.local.fridge.database.IngredientDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "user_db"
    ).fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideIngredientDao(appDatabase: AppDatabase): IngredientDao = appDatabase.ingredientDao()

}