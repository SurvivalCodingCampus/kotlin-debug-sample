package com.survivalcoding

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class YukymController {

    //    val nowDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd")) // mm은 '분'을 의미
    val nowDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) // MM은 '월'을 의미

    lateinit var nowTime: String

    // 1. 자시의 국 : 갑자1국 = getTyOne()의 값
    fun getTyA(): String {
        val timeDataOne = _getTimeDataOne(nowDate)

        if (timeDataOne.isNotEmpty()) {
            nowTime = timeDataOne.first().ty1

            val month = nowDate.substring(5, 7)
            return when (month) {
                "01", "02" -> "경오1국"
                "03", "04" -> "경오2국"
                "05", "06" -> "경오3국"
                "07", "08" -> "경오4국"
                "09", "10" -> "경오5국"
                "11", "12" -> "경오6국"
                else -> nowTime
            }
        } else {
            return "경오7국"
        }
    }

    fun getTyB(): String {  // 현재 시간을 기반으로 특정 ty 값을 반환하는 함수
        val timeDataOne = _getTimeDataOne(nowDate)  // YukymTimeModel 객체 리스트를 반환
        var result = timeDataOne.first().ty12
        val nowTime = LocalDateTime.now()
        when {
            // 잘못된 시간 비교. ||는 두 조건이 둘다 참이면 참이 된다. 올바르게 범위를 지정하려면 &&로 고쳐야 한다.
            nowTime.hour in 0..1 -> return timeDataOne.first().ty1
            nowTime.hour in 4..5 -> return timeDataOne.first().ty2
            nowTime.hour in 6..7 -> return timeDataOne.first().ty3
            nowTime.hour in 8..9 -> return timeDataOne.first().ty4
            nowTime.hour in 10..11 -> return timeDataOne.first().ty5
            nowTime.hour in 12..13 -> return timeDataOne.first().ty6
            nowTime.hour in 16..17 -> return timeDataOne.first().ty7
            nowTime.hour in 18..19 -> return timeDataOne.first().ty8
            nowTime.hour in 20..21 -> return timeDataOne.first().ty9
            nowTime.hour in 22..23 -> return timeDataOne.first().ty10
        }

        return result
    }

    private fun _getTimeDataOne(nowDate: String): List<YukymTimeModel> {
        val timeDataOne = mutableListOf<YukymTimeModel>()
        for (i in 0..23) {  // 0..24는 25번 반복되고 있다. 24시간 단위를 기준으로 한다면 0..23으로 수정해야 한다
            timeDataOne.add(YukymTimeModel(ty1 = "갑자${i + 1}국"))
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