package com.example.ourfridgeapp.ui.ingredient.screen

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import java.time.LocalDateTime
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DatePickerScreen(
    selectedDateTime: LocalDateTime,
    onDismissRequest: () -> Unit,
    onClickConfirm: (selectedDateMillis: Long?) -> Unit,
    onClickCancel: () -> Unit
) {
    val selectedDateInMillis =
        selectedDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = selectedDateInMillis
    )

    DatePickerDialog(
        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_12dp)),
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            TextButton(
                onClick = { onClickConfirm(datePickerState.selectedDateMillis) }
            ) {
                Text(
                    text = stringResource(R.string.confirm),
                    style = FridgeAppTheme.typography.body14
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onClickCancel() }
            ) {
                Text(
                    text = stringResource(R.string.cancel),
                    style = FridgeAppTheme.typography.body14
                )
            }
        },
        colors = DatePickerDefaults.colors(
            containerColor = Color.White,
        )
    ) {
        DatePicker(
            state = datePickerState
        )
    }
}