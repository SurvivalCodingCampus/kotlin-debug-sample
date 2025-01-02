package com.survivalcoding

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class YukymController {
    private val now = LocalDateTime.now()
    fun getTyA(): String = now.toLocalDate().to경오()
    fun getTyB(): String = now.toLocalTime().to갑자()
}

private fun indexed(value: Int, groupOf: Int, span: IntRange): Int {
    val normalized = value - span.first + 1
    val length = span.last - span.first + 1
    val groups = length / groupOf
    return (normalized / groups) * (normalized / groupOf) + normalized % groupOf
}

fun LocalDate.to경오() = indexed(monthValue, 2, 1..12).let { "경오${it}국" }
fun LocalTime.to갑자() = indexed(hour, 2, 0..23).let { "갑자${it}국" }
