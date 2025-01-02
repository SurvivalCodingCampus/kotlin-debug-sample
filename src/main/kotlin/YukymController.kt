package com.survivalcoding

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class YukymController {
    val nowDate = LocalDateTime.now()

    // 1. 자시의 국 : 갑자1국 = getTyOne()의 값
    fun getTyA(): String = "경오${(nowDate.month.value + 1) / 2}국"
    fun getTyB(): String = "갑자${nowDate.hour / 2 + 1}국"
}