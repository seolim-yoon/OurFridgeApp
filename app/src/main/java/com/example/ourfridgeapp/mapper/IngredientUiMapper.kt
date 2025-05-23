package com.example.ourfridgeapp.mapper

import com.example.data.datasource.local.fridge.database.Ingredient
import com.example.ourfridgeapp.ui.fridge.uimodel.DraftIngredient
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.util.CategoryType
import com.example.ourfridgeapp.util.DateViewType
import com.example.ourfridgeapp.util.SpaceType
import com.example.ourfridgeapp.util.toLocalDateTime
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import javax.inject.Inject

class IngredientUiMapper @Inject constructor() {
    fun mapToIngredientUiModelList(ingredientList: List<Ingredient>): List<IngredientUiModel> =
        ingredientList.map { ingredient ->
            IngredientUiModel(
                id = ingredient.id,
                space = SpaceType.fromValueByString(ingredient.space),
                category = CategoryType.fromValueByString(ingredient.category),
                name = ingredient.name,
                quantity = ingredient.quantity,
                purchaseDate = ingredient.purchaseDate,
                expirationDate = ingredient.expirationDate,
                dateViewType = DateViewType.fromValueByIndex(ingredient.dateViewType),
                dDay = getDayByViewType(ingredient.purchaseDate, ingredient.expirationDate, DateViewType.fromValueByIndex(ingredient.dateViewType)),
                memo = ingredient.memo

            )
        }

    private fun getDayByViewType(
        purchaseDate: Long,
        expirationDate: Long,
        viewType: DateViewType
    ): Int {
        val today = LocalDate.now()
        val dDay = ChronoUnit.DAYS.between(today, expirationDate.toLocalDateTime().toLocalDate()).toInt()
        val elapsed = ChronoUnit.DAYS.between(purchaseDate.toLocalDateTime().toLocalDate(), today).toInt() + 1

        return when (viewType) {
            DateViewType.REMAINING -> dDay
            DateViewType.ELAPSED -> elapsed
        }
    }

    fun mapToIngredient(draftIngredient: DraftIngredient): Ingredient =
        Ingredient(
            id = draftIngredient.id,
            name = draftIngredient.name,
            purchaseDate = draftIngredient.purchaseDate,
            space = draftIngredient.space.title,
            category = draftIngredient.category.title,
            quantity = draftIngredient.quantity,
            expirationDate = draftIngredient.expirationDate,
            dateViewType = draftIngredient.dateViewType.index,
            memo = draftIngredient.memo
        )

    fun mapToDraftIngredient(ingredient: Ingredient): DraftIngredient =
        DraftIngredient(
            id = ingredient.id,
            name = ingredient.name,
            purchaseDate = ingredient.purchaseDate,
            space = SpaceType.fromValueByString(ingredient.space),
            category = CategoryType.fromValueByString(ingredient.category),
            quantity = ingredient.quantity,
            expirationDate = ingredient.expirationDate,
            dateViewType = DateViewType.fromValueByIndex(ingredient.dateViewType),
            memo = ingredient.memo
        )
}