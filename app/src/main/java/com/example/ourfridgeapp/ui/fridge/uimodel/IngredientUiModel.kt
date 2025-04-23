package com.example.ourfridgeapp.ui.fridge.uimodel

import com.example.ourfridgeapp.util.CategoryType
import com.example.ourfridgeapp.util.DateViewType
import com.example.ourfridgeapp.util.SpaceType
import java.time.LocalDate

data class IngredientUiModel(
    val id: Int = 0,
    val space: SpaceType = SpaceType.FRIDGE,
    val category: CategoryType = CategoryType.DEFAULT,
    val name: String = "",
    val quantity: Int = 1,
    val purchaseDate: String = "",
    val expirationDate: String = "",
    val dateViewType: DateViewType = DateViewType.REMAINING,
    val dDay: Int = 0,
    val memo: String = ""
)

data class DraftIngredient(
    val id: Int = 0,
    val space: SpaceType = SpaceType.FRIDGE,
    val category: CategoryType = CategoryType.DEFAULT,
    val name: String = "",
    val quantity: Int = 1,
    val purchaseDate: String = LocalDate.now().toString(),
    val expirationDate: String = LocalDate.now().toString(),
    val dateViewType: DateViewType = DateViewType.REMAINING,
    val memo: String = ""
)