package com.survivalcoding

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class YukymController {

    val nowDate = LocalDateTime.now()

    fun getTyA(): String {
        return when (nowDate.monthValue) {
            1,2 -> "경오1국"
            3,4 -> "경오2국"
            5,6 -> "경오3국"
            7,8 -> "경오4국"
            9,10 -> "경오5국"
            11,12 -> "경오6국"
            else -> "경오7국"
        }
    }

    fun getTyB(): String {
        val timeData = YukymTimeModel()
        return when (nowDate.hour) {
            in 0..1 -> timeData.ty1
            in 4..5 -> timeData.ty2
            in 6..7 -> timeData.ty3
            in 8..9 -> timeData.ty4
            in 10..11 -> timeData.ty5
            in 12..13 -> timeData.ty6
            in 16..17 -> timeData.ty7
            in 18..19 -> timeData.ty8
            in 20..21 -> timeData.ty9
            in 22..23 -> timeData.ty10
            else -> timeData.ty12
        }

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