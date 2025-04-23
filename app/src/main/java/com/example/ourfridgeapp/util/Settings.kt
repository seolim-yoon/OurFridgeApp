package com.example.ourfridgeapp.util

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ourfridgeapp.R

enum class Settings(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    val hasCheckOption: Boolean
) {
    NOTIFICATION(R.drawable.notification, R.string.settings_notification, true),
    UPCOMING(R.drawable.update, R.string.settings_upcoming_features, false),
    CONTACT(R.drawable.ask, R.string.settings_contact_us, false),
    FEEDBACK(R.drawable.feedback, R.string.settings_send_feedback, false),
    TERMS(R.drawable.terms, R.string.settings_terms_of_use, false)
}