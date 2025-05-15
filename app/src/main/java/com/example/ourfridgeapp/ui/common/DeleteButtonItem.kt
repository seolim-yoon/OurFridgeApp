package com.example.ourfridgeapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.Gray

@Composable
internal fun DeleteButtonItem(
    onClickDeleteButton: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = dimensionResource(R.dimen.padding_8dp),
            alignment = Alignment.CenterHorizontally
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClickDeleteButton()
            }
            .border(
                width = 1.dp,
                color = Gray,
                shape = RoundedCornerShape(
                    dimensionResource(R.dimen.radius_12dp)
                )
            )
            .background(
                color = Color.Transparent
            )
            .padding(vertical = dimensionResource(R.dimen.padding_12dp))
    ) {
        Icon(
            painter = painterResource(R.drawable.delete),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = stringResource(R.string.delete),
            style = FridgeAppTheme.typography.title16
        )
    }
}