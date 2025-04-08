package com.example.ourfridgeapp.ui.fridge.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.NumberCounter
import com.example.ourfridgeapp.ui.common.PlaceHolderItem
import com.example.ourfridgeapp.ui.fridge.item.SpaceTabRowItem
import com.example.ourfridgeapp.ui.common.TitleItem
import com.example.ourfridgeapp.ui.fridge.item.AddIngredientTitleItem
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme

@Composable
internal fun AddIngredientScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_20dp))
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_24dp)),
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "2025.04.08 화요일", // TODO : 오늘 날짜
                style = FridgeAppTheme.typography.body12,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(top = dimensionResource(R.dimen.padding_20dp))
            )

            TextField(
                value = "",
                onValueChange = {},
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
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.padding_16dp))
            )

            SpaceTabRowItem(
                tabs = listOf("냉장", "냉동", "김치냉장고"),
                selectedTabIndex = 0,
                onTabSelected = {  },
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
                    },
                    range = 0..100
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
                    value = "",
                    onValueChange = {},
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

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            TitleItem(
                text = stringResource(R.string.save)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAddIngredientScreen() {
    OurFridgeAppTheme {
        AddIngredientScreen(

        )
    }
}