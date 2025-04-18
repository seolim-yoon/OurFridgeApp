package com.example.ourfridgeapp.ui.fridge.uimodel

import com.example.ourfridgeapp.util.CategoryType

data class IngredientUiModel(
    val id: Int = 0,
    val space: String = "",
    val category: CategoryType = CategoryType.DEFAULT,
    val name: String = "",
    val quantity: Int = 0,
    val purchaseDate: String = "",
    val expirationDate: String = "",
    val dDay: Int = 0,
    val memo: String = ""
)

data class DraftIngredient(
    val id: Int = 0,
    val space: String = "",
    val category: CategoryType = CategoryType.DEFAULT,
    val name: String = "",
    val quantity: Int = 0,
    val purchaseDate: String = "",
    val expirationDate: String = "",
    val memo: String = ""
)