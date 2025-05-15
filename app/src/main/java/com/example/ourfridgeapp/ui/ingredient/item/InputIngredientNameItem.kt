package com.example.ourfridgeapp.ui.ingredient.item

import android.graphics.Paint.Align
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
import androidx.compose.ui.text.TextStyle
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.PlaceHolderItem
import com.example.ourfridgeapp.ui.theme.Beige
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme

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
        textStyle = FridgeAppTheme.typography.centerBody18,
        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_12dp)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(R.dimen.padding_16dp))
    )
}