package com.example.ourfridgeapp.util

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Long.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(this), ZoneId.systemDefault())
}

fun LocalDateTime.toLong(): Long {
    return this.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}