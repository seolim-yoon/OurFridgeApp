package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.NumberCounter
import com.example.ourfridgeapp.ui.common.PlaceHolderItem
import com.example.ourfridgeapp.ui.common.TitleItem
import com.example.ourfridgeapp.ui.fridge.item.SpaceTabRowItem
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.util.NumberCountType

@Composable
internal fun AddIngredientInputItem(
    inputName: String,
    inputMemo: String,
    onNameChange: (String) -> Unit,
    onSpaceSelect: (Int) -> Unit,
    onCountQuantity: (IngredientUiModel, NumberCountType) -> Unit,
    onMemoChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_24dp)),
        modifier = modifier
    ) {
        TextField(
            value = inputName,
            onValueChange = onNameChange,
            placeholder = {
                PlaceHolderItem(
                    placeHolder = stringResource(R.string.msg_input_ingredient_name)
                )
            },
            shape = RoundedCornerShape(dimensionResource(R.dimen.radius_12dp)),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.padding_20dp))
        )

        SpaceTabRowItem(
            tabs = listOf("냉장", "냉동", "김치냉장고"),
            selectedTabIndex = 0,
            onTabSelected = onSpaceSelect,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_8dp))
        )

        // category
        AddIngredientTitleItem(
            title = stringResource(R.string.category)
        ) {
            Button(
                onClick = {}
            ) {
                TitleItem(
                    text = stringResource(R.string.select_category)
                )
            }
        }

        // quantity
        AddIngredientTitleItem(
            title = stringResource(R.string.quantity)
        ) {
            NumberCounter(
                value = 0,
                onChangeCount = { type ->
//                    onCountQuantity(fruit, type)
                },
                range = 0..100
            )
        }

        // purchase_date
        AddIngredientTitleItem(
            title = stringResource(R.string.purchase_date)
        ) {
            Text(
                text = "2025.04.08", // TODO : 오늘 날짜
                style = FridgeAppTheme.typography.body14,
                color = Color.Gray
            )
        }


        // expired_date
        AddIngredientTitleItem(
            title = stringResource(R.string.expired_date)
        ) {
            Text(
                text = "2025.04.08", // TODO : 버튼으로 변경
                style = FridgeAppTheme.typography.body14,
                color = Color.Gray
            )
        }

        // memo
        AddIngredientTitleItem(
            title = stringResource(R.string.memo)
        ) {
            TextField(
                value = inputMemo,
                onValueChange = onMemoChange,
                placeholder = {
                    PlaceHolderItem(
                        placeHolder = stringResource(R.string.msg_input_memo)
                    )
                },
                shape = RoundedCornerShape(dimensionResource(R.dimen.radius_12dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}