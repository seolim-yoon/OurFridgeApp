package com.example.ourfridgeapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitLongPressOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.theme.Beige
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import com.example.ourfridgeapp.util.NumberCountType
import kotlinx.coroutines.delay

@Composable
fun NumberCounter(
    value: Int,
    onChangeCount: (NumberCountType) -> Unit,
    range: IntRange,
) {
    val updateValue by rememberUpdatedState(value)

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        CounterButtonItem(
            isEnable = updateValue > range.first,
            imageVector = Icons.Default.Remove,
            onLongPressed = {
                onChangeCount(NumberCountType.MINUS)
            },
            onClick = {
                if (updateValue > range.first) {
                    onChangeCount(NumberCountType.MINUS)
                }
            }
        )

        Text(
            text = value.toString(),
            style = FridgeAppTheme.typography.body16,
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_12dp))
        )

        CounterButtonItem(
            isEnable = updateValue < range.last,
            imageVector = Icons.Default.Add,
            onLongPressed = {
                if (updateValue < range.last) {
                    onChangeCount(NumberCountType.PLUS)
                }
            },
            onClick = {
                if (updateValue < range.last) {
                    onChangeCount(NumberCountType.PLUS)
                }
            }
        )
    }
}

@Composable
fun CounterButtonItem(
    isEnable: Boolean,
    imageVector: ImageVector,
    onLongPressed: () -> Unit,
    onClick: () -> Unit
) {
    var isLongPressed by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(key1 = isLongPressed) {
        while (isLongPressed) {
            onLongPressed()
            delay(500L)
        }
    }

    Box(
        modifier = Modifier
            .background(
                shape = RoundedCornerShape(dimensionResource(R.dimen.radius_8dp)),
                color = Beige
            )
            .pointerInput(Unit) {
                awaitEachGesture {
                    val down = awaitFirstDown()
                    isLongPressed = false

                    val longPress = awaitLongPressOrCancellation(down.id)

                    if (longPress != null) {
                        isLongPressed = true
                        while (longPress.pressed) {
                            val event = awaitPointerEvent()
                            if (event.changes.all { !it.pressed }) break
                        }
                    } else {
                        isLongPressed = false
                        onClick()

                    }
                    isLongPressed = false
                }
            }
            .padding(dimensionResource(R.dimen.padding_2dp))
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = if (isEnable) Color.Black else Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNumberCounter() {
    OurFridgeAppTheme {
        NumberCounter(
            value = 0,
            onChangeCount = {},
            range = 0..10
        )
    }
}