package com.example.ourfridgeapp.ui.fridge.uimodel

import com.example.ourfridgeapp.util.CategoryType
import com.example.ourfridgeapp.util.DateViewType
import com.example.ourfridgeapp.util.SpaceType
import com.example.ourfridgeapp.util.toLong
import java.time.LocalDate
import java.time.LocalDateTime

data class IngredientUiModel(
    val id: Int = 0,
    val space: SpaceType = SpaceType.FRIDGE,
    val category: CategoryType = CategoryType.DEFAULT,
    val name: String = "",
    val quantity: Int = 1,
    val purchaseDate: Long = 0L,
    val expirationDate: Long = 0L,
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
    val purchaseDate: Long = LocalDateTime.now().toLong(),
    val expirationDate: Long = LocalDateTime.now().toLong(),
    val dateViewType: DateViewType = DateViewType.REMAINING,
    val memo: String = ""
)