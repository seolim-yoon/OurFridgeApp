package com.example.ourfridgeapp.util

import androidx.annotation.StringRes
import com.example.ourfridgeapp.R

enum class DateViewType(
    val index: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
) {
    REMAINING(
        0,
        title = R.string.expiration_remaining_title,
        description = R.string.expiration_remaining_description
    ),
    ELAPSED(
        1,
        title = R.string.purchase_elapsed_title,
        description = R.string.purchase_elapsed_description
    );

    companion object {
        fun fromValueByIndex(index: Int): DateViewType {
            return DateViewType.entries.find { it.index == index } ?: REMAINING
        }
    }

}