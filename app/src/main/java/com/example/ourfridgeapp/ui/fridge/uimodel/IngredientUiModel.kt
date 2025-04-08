package com.example.ourfridgeapp.ui.fridge.uimodel

data class IngredientUiModel(
    val id: Int,
    val category: String,
    val name: String,
    val count: Int,
    val expiration: String,
    val dDay: Int
)
