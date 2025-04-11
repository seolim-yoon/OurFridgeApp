package com.example.ourfridgeapp.mapper

import com.example.data.datasource.local.fridge.database.Ingredient
import com.example.ourfridgeapp.ui.fridge.uimodel.DraftIngredient
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.util.CategoryType
import javax.inject.Inject

class IngredientUiMapper @Inject constructor() {
    fun mapToIngredientUiModelList(ingredientList: List<Ingredient>): List<IngredientUiModel> =
        ingredientList.map { ingredient ->
            IngredientUiModel(
                id = ingredient.id,
                space = ingredient.space,
                category = CategoryType.fromValueByString(ingredient.category),
                name = ingredient.name,
                quantity = ingredient.quantity,
                purchaseDate = ingredient.purchaseDate,
                expirationDate = ingredient.expirationDate,
                dDay = 0,
                memo = ingredient.memo

            )
        }

    fun mapToIngredient(ingredientUiModel: IngredientUiModel): Ingredient =
        Ingredient(
            id = ingredientUiModel.id,
            name = ingredientUiModel.name,
            purchaseDate = ingredientUiModel.purchaseDate,
            space = ingredientUiModel.space,
            category = ingredientUiModel.category.title,
            quantity = ingredientUiModel.quantity,
            expirationDate = ingredientUiModel.expirationDate,
            memo = ingredientUiModel.memo
        )

    fun mapToIngredient(draftIngredient: DraftIngredient): Ingredient =
        Ingredient(
            id = draftIngredient.id,
            name = draftIngredient.name,
            purchaseDate = draftIngredient.purchaseDate,
            space = draftIngredient.space,
            category = draftIngredient.category.title,
            quantity = draftIngredient.quantity,
            expirationDate = draftIngredient.expirationDate,
            memo = draftIngredient.memo
        )

    fun mapToDraftIngredient(ingredient: Ingredient): DraftIngredient =
        DraftIngredient(
            id = ingredient.id,
            name = ingredient.name,
            purchaseDate = ingredient.purchaseDate,
            space = ingredient.space,
            category = CategoryType.fromValueByString(ingredient.category),
            quantity = ingredient.quantity,
            expirationDate = ingredient.expirationDate,
            memo = ingredient.memo
        )

    fun mapToDraftIngredient(ingredientUiModel: IngredientUiModel): DraftIngredient =
        DraftIngredient(
            id = ingredientUiModel.id,
            name = ingredientUiModel.name,
            purchaseDate = ingredientUiModel.purchaseDate,
            space = ingredientUiModel.space,
            category = ingredientUiModel.category,
            quantity = ingredientUiModel.quantity,
            expirationDate = ingredientUiModel.expirationDate,
            memo = ingredientUiModel.memo
        )
}