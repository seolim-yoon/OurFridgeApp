package com.example.data.di

import com.example.data.datasource.local.fridge.FridgeLocalDataSource
import com.example.data.datasource.local.fridge.FridgeLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    @Singleton
    fun bindsFridgeLocalDataSource(fridgeLocalDataSourceImpl: FridgeLocalDataSourceImpl): FridgeLocalDataSource
}