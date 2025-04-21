package com.example.data.datasource.local.fridge

import com.example.data.datasource.local.fridge.database.Ingredient
import com.example.data.datasource.local.fridge.database.IngredientDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FridgeLocalDataSourceImpl @Inject constructor(
    private val ingredientDao: IngredientDao
): FridgeLocalDataSource {

    override suspend fun getAllIngredient(): Flow<List<Ingredient>> = ingredientDao.getAllIngredient()

    override suspend fun getIngredientById(id: Int): Ingredient = ingredientDao.getIngredientById(id)

    override suspend fun getIngredientBySpaceType(spaceType: String): Flow<List<Ingredient>> = ingredientDao.getIngredientBySpaceType(spaceType)

    override suspend fun upsertIngredient(ingredient: Ingredient) = ingredientDao.upsertIngredient(ingredient)

    override suspend fun deleteIngredient(ingredient: Ingredient) = ingredientDao.deleteIngredient(ingredient)
}