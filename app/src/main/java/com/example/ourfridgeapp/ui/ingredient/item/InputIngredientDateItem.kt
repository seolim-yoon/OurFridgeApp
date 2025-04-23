package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.ingredient.screen.DatePickerScreen
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.util.parseToLocalDate
import java.time.LocalDate

@Composable
internal fun InputIngredientDateItem(
    title: String,
    date: String,
    onSelectDate: (String) -> Unit
) {
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember(date) { mutableStateOf(parseToLocalDate(date)) }

    AddIngredientTitleItem(
        title = title
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_8dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.CalendarMonth,
                contentDescription = null,
                tint = Color.Gray
            )

            Text(
                text = selectedDate.toString(),
                style = FridgeAppTheme.typography.body16,
                color = Color.Gray,
                modifier = Modifier
                    .clickable {
                        showDatePicker = true
                    }
                    .background(
                        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_8dp)),
                        color = Color.LightGray
                    )
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_8dp),
                        horizontal = dimensionResource(R.dimen.padding_12dp)
                    )
            )
        }
    }

    if (showDatePicker) {
        DatePickerScreen(
            selectedDateTime = selectedDate,
            onDismissRequest = {
                showDatePicker = false
            },
            onClickConfirm = { selectedDateMillis ->
                if (selectedDateMillis !== null) {
                    selectedDate =
                        LocalDate.ofInstant(
                            java.time.Instant.ofEpochMilli(selectedDateMillis),
                            java.time.ZoneId.systemDefault()
                        )
                    onSelectDate(selectedDate.toString())
                }
                showDatePicker = false
            },
            onClickCancel = {
                showDatePicker = false
            })
    }
}