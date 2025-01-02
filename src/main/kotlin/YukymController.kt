package com.survivalcoding

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class YukymController {
    val nowDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    lateinit var nowTime: String

    // 1. 자시의 국 : 갑자1국 = getTyOne()의 값
    fun getTyA(): String {
        val timeDataOne = _getTimeDataOne(nowDate)

        return if (timeDataOne.isNotEmpty()) {
            nowTime = timeDataOne.first().ty1

            val month = nowDate.substring(5, 7)
            when (month) {
                "01", "02" -> "경오1국"
                "03", "04" -> "경오2국"
                "05", "06" -> "경오3국"
                "07", "08" -> "경오4국"
                "09", "10" -> "경오5국"
                "11", "12" -> "경오6국"
                else -> nowTime
            }
        } else {
            "경오7국"
        }
    }

    fun getTyB(): String {
        val timeDataOne = _getTimeDataOne(nowDate)

        val nowTime = LocalDateTime.now()
        return when (nowTime.hour) {
            in 0..1 -> timeDataOne.first().ty1
            in 2..3 -> timeDataOne.first().ty2
            in 4..5 -> timeDataOne.first().ty3
            in 6..7 -> timeDataOne.first().ty4
            in 8..9 -> timeDataOne.first().ty5
            in 10..11 -> timeDataOne.first().ty6
            in 12..13 -> timeDataOne.first().ty7
            in 14..15 -> timeDataOne.first().ty8
            in 16..17 -> timeDataOne.first().ty9
            in 18..19 -> timeDataOne.first().ty10
            in 20..21 -> timeDataOne.first().ty11
            in 22..23 -> timeDataOne.first().ty12
            else -> timeDataOne.first().ty12
        }
    }

    private fun _getTimeDataOne(nowDate: String): List<YukymTimeModel> {
        val timeDataOne = mutableListOf<YukymTimeModel>()
        for (i in 0..<24) {
            timeDataOne.add(YukymTimeModel())
        }
        return timeDataOne
    }
}

data class YukymTimeModel(
    val ty1: String = "갑자1국",
    val ty2: String = "갑자2국",
    val ty3: String = "갑자3국",
    val ty4: String = "갑자4국",
    val ty5: String = "갑자5국",
    val ty6: String = "갑자6국",
    val ty7: String = "갑자7국",
    val ty8: String = "갑자8국",
    val ty9: String = "갑자9국",
    val ty10: String = "갑자10국",
    val ty11: String = "갑자11국",
    val ty12: String = "갑자12국"
)