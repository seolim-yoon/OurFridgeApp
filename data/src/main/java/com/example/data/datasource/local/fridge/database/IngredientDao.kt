package com.example.data.datasource.local.fridge.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface IngredientDao {
    @Query("SELECT * FROM Ingredient")
    fun getAllIngredient(): Flow<List<Ingredient>>

    @Query("SELECT * FROM Ingredient WHERE ingredient_id = :id")
    fun getIngredientById(id: Int): Ingredient

    @Query("SELECT * FROM Ingredient WHERE space_type = :spaceType")
    fun getIngredientBySpaceType(spaceType: String): Flow<List<Ingredient>>

    @Upsert
    fun upsertIngredient(ingredient: Ingredient)

    @Delete
    fun deleteIngredient(ingredient: Ingredient)
}