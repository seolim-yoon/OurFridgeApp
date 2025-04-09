package com.example.ourfridgeapp.ui.fridge.uimodel

data class IngredientUiModel(
    val id: Int,
    val space: String,
    val category: String,
    val name: String,
    val quantity: Int,
    val purchaseDate: String,
    val expirationDate: String,
    val dDay: Int,
    val memo: String
)

data class DraftIngredient(
    val space: String,
    val category: String,
    val name: String,
    val quantity: Int,
    val purchaseDate: String,
    val expirationDate: String,
    val memo: String
)