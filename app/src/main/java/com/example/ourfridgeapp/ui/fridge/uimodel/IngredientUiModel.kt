package com.example.ourfridgeapp.ui.fridge.uimodel

data class IngredientUiModel(
    val id: Int,
    val category: String,
    val name: String,
    val count: Int,
    val purchaseDate: String,
    val expirationDate: String,
    val dDay: Int
)
