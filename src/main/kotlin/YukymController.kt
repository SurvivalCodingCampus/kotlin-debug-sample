package com.survivalcoding

import java.time.LocalDate
import java.time.LocalTime

class YukymController {

    fun getTyA(date: LocalDate = LocalDate.now()): String = "경오${(date.monthValue + 1) / 2}국"

    fun getTyB(
        time: LocalTime = LocalTime.now(),
        timeData: YukymTimeModel = YukymTimeModel(),
    ): String {
        return when (val hour = time.hour) {
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
