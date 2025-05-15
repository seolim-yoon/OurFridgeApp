package com.example.ourfridgeapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.theme.Beige
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import com.example.ourfridgeapp.util.DateViewType

@Composable
internal fun RadioButtonItem(
    viewType: DateViewType,
    isChecked: Boolean,
    onSelectedType: (DateViewType) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { onSelectedType(viewType) }
        ) {
            RadioButton(
                selected = isChecked,
                onClick = { onSelectedType(viewType) },
                modifier = Modifier.padding(0.dp)
            )

            Text(
                text = stringResource(viewType.title),
                style = FridgeAppTheme.typography.title16,
            )
        }

        if (isChecked) {
            Text(
                text = stringResource(viewType.description),
                style = FridgeAppTheme.typography.body14,
                modifier = Modifier.fillMaxWidth()
                    .background(
                        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_8dp)),
                        color = Beige
                    ).padding(
                        horizontal = dimensionResource(R.dimen.padding_16dp),
                        vertical = dimensionResource(R.dimen.padding_12dp)
                    )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewRadioButtonItem(@PreviewParameter(RadioButtonParameterProvider::class) isChecked: Boolean) {
    OurFridgeAppTheme {
        RadioButtonItem(
            viewType = DateViewType.REMAINING,
            isChecked = isChecked,
            onSelectedType = {  }
        )
    }
}

private class RadioButtonParameterProvider(
    override val values: Sequence<Boolean> = sequenceOf(
        checkedCase,
        unCheckedCase
    )
) : PreviewParameterProvider<Boolean>

private const val checkedCase = true
private const val unCheckedCase = false

