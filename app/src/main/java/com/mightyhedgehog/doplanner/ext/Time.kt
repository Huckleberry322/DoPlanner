package com.mightyhedgehog.doplanner.ext

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun LocalDateTime.toEpochMillis() = this.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()

fun toLocalDateTime(epochMillis: Long): LocalDateTime =
    LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), ZoneId.systemDefault())

fun LocalDateTime.toString(pattern: String): String = this
    .format(DateTimeFormatter.ofPattern(pattern))

fun LocalDate.toString(pattern: String): String = this
    .format(DateTimeFormatter.ofPattern(pattern))
