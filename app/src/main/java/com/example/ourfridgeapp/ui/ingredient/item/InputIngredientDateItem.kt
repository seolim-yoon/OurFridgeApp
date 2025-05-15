package com.example.ourfridgeapp.ui.ingredient.item

import android.util.Log
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
import com.example.ourfridgeapp.ui.theme.Beige
import com.example.ourfridgeapp.ui.theme.Brown
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.util.toLocalDateTime
import java.time.LocalDate
import java.time.LocalDateTime

@Composable
internal fun InputIngredientDateItem(
    title: String,
    date: Long,
    onSelectDate: (LocalDateTime) -> Unit
) {
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember(date) { mutableStateOf(date.toLocalDateTime()) }

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
                tint = Brown
            )

            Text(
                text = selectedDate.toLocalDate().toString(),
                style = FridgeAppTheme.typography.body16,
                color = Color.Black,
                modifier = Modifier
                    .clickable {
                        showDatePicker = true
                    }
                    .background(
                        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_8dp)),
                        color = Beige
                    )
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_8dp),
                        horizontal = dimensionResource(R.dimen.padding_12dp)
                    )
            )
        }
    }

    if (showDatePicker) {
        Log.d("seolim", "selectedDate : " + selectedDate)
        DatePickerScreen(
            selectedDate = selectedDate,
            onDismissRequest = {
                showDatePicker = false
            },
            onClickConfirm = { selectedDateMillis ->
                if (selectedDateMillis !== null) {
                    selectedDate = selectedDateMillis.toLocalDateTime()

                    onSelectDate(selectedDate)
                }
                showDatePicker = false
            },
            onClickCancel = {
                showDatePicker = false
            })
    }
}