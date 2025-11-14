package com.survivalcoding

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class YukymController {

    val nowDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    fun getTyA(): String {
        val month = nowDate.substring(5, 7)
        return when (month) {
            "01", "02" -> "경오1국"
            "03", "04" -> "경오2국"
            "05", "06" -> "경오3국"
            "07", "08" -> "경오4국"
            "09", "10" -> "경오5국"
            "11", "12" -> "경오6국"
            else -> "경오7국"
        }
    }

    fun getTyB(): String {
        val timeData = YukymTimeModel()
        val nowTime = LocalDateTime.now()
        when (nowTime.hour) {
            in 0..1 -> return timeData.ty1
            in 4..5 -> return timeData.ty2
            in 6..7 -> return timeData.ty3
            in 8..9 -> return timeData.ty4
            in 10..11 -> return timeData.ty5
            in 12..13 -> return timeData.ty6
            in 16..17 -> return timeData.ty7
            in 18..19 -> return timeData.ty8
            in 20..21 -> return timeData.ty9
            in 22..23 -> return timeData.ty10
        }

        return timeData.ty12
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