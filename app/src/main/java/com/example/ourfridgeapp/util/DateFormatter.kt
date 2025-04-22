package com.example.ourfridgeapp.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun parseToLocalDate(dateString: String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return if (dateString.isEmpty())
        LocalDate.now()
    else
        LocalDate.parse(dateString, formatter)
}
