package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.PlaceHolderItem
import com.example.ourfridgeapp.ui.theme.Beige
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme

@Composable
internal fun InputIngredientMemoItem(
    inputMemo: String,
    onMemoChange: (String) -> Unit
) {
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
            textStyle = FridgeAppTheme.typography.body16,
            shape = RoundedCornerShape(dimensionResource(R.dimen.radius_12dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Beige,
                unfocusedContainerColor = Beige,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}