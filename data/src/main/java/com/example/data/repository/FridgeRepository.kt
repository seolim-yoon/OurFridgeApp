package com.example.data.repository

import com.example.data.datasource.local.fridge.FridgeLocalDataSource
import com.example.data.datasource.local.fridge.database.Ingredient
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FridgeRepository @Inject constructor(
    private val fridgeLocalDataSource: FridgeLocalDataSource
) {
    suspend fun getAllIngredient(): Flow<List<Ingredient>> = fridgeLocalDataSource.getAllIngredient()

    suspend fun getIngredientById(id: Int): Ingredient = fridgeLocalDataSource.getIngredientById(id)

    suspend fun upsertIngredient(ingredient: Ingredient) = fridgeLocalDataSource.upsertIngredient(ingredient)

    suspend fun deleteIngredient(ingredient: Ingredient) = fridgeLocalDataSource.deleteIngredient(ingredient)
}