package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

@Composable
internal fun InputIngredientNameItem(
    inputName: String,
    onNameChange: (String) -> Unit
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
            .padding(top = dimensionResource(R.dimen.padding_16dp))
    )
}