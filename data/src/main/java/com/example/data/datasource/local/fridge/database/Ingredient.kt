package com.example.data.datasource.local.fridge.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ingredient")
data class Ingredient(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ingredient_id")
    var id: Int = 0,
    @ColumnInfo(name = "ingredient_name")
    val name: String,
    @ColumnInfo(name = "space_type")
    val space: String,
    @ColumnInfo(name = "category_type")
    val category: String,
    @ColumnInfo(name = "quantity")
    val quantity: Int,
    @ColumnInfo(name = "purchase_date")
    val purchaseDate: String,
    @ColumnInfo(name = "expiration_date")
    val expirationDate: String,
    @ColumnInfo(name = "date_view_type")
    val dateViewType: Int,
    @ColumnInfo(name = "memo")
    val memo: String
)