package com.example.data.datasource.local.fridge

import com.example.data.datasource.local.fridge.database.Ingredient
import kotlinx.coroutines.flow.Flow

interface FridgeLocalDataSource {
    suspend fun getAllIngredient(): Flow<List<Ingredient>>

    suspend fun getIngredientById(id: Int): Ingredient

    suspend fun getIngredientBySpaceType(spaceType: String): Flow<List<Ingredient>>

    suspend fun upsertIngredient(ingredient: Ingredient)

    suspend fun deleteIngredient(ingredient: Ingredient)
}