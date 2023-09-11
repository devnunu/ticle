package com.devnunu.ticle.util

import java.text.DecimalFormat

object NumberFormatUtil {

    /**
     * @param value 변환시킬 숫자
     * @param addUnit "원" 단위 추가 유무
     * @return 한국 돈 단위로 변경
     * */
    @JvmStatic
    fun toKrCurrencyText(value: Long?, addUnit: Boolean = false): String {
        if (value == null || value == 0L) return if (addUnit) "0원" else "0"
        var remainValue = value
        var result = ""
        if (remainValue >= 100000000) {
            result += "${toCurrencyFormText(remainValue / 100000000)}억 "
            remainValue -= remainValue / 100000000 * 100000000
        }
        if (remainValue >= 10000) {
            result += "${toCurrencyFormText(remainValue / 10000)}만 "
            remainValue -= remainValue / 10000 * 10000
        }
        if (remainValue >= 1) {
            result += "$remainValue"
        }
        return if (addUnit) "${result.trim()}원" else result.trim()
    }

    @JvmStatic
    fun toKrCurrencyFullText(value: Long?, addUnit: Boolean = false): String {
        if (value == null || value == 0L) return if (addUnit) "0원" else "0"
        var remainValue = value
        var result = ""
        if (remainValue >= 100000000) {
            result += "${toCurrencyFormText(remainValue / 100000000)}억 "
            remainValue -= remainValue / 100000000 * 100000000
        }
        if (remainValue >= 10000) {
            result += "${toCurrencyFormText(remainValue / 10000)}만 "
            remainValue -= 10000
            remainValue -= remainValue / 10000 * 10000
        }
        result += toCurrencyFormText(remainValue)
        return if (addUnit) "${result.trim()}원" else result.trim()
    }

    @JvmStatic
    fun toKrCurrencyNoSpaceInUnitText(value: Long?): String {
        if (value == null) return "0원"
        var remainValue = value
        var result = ""
        if (remainValue >= 100000000) {
            result += "${toCurrencyFormText(remainValue / 100000000)}억 "
            remainValue -= remainValue / 100000000 * 100000000
        }
        if (remainValue >= 10000) {
            result += "${toCurrencyFormText(remainValue / 10000)}만 "
            remainValue -= 10000
        }
        return "${result.trim()}원"
    }

    /**
     * @return 1000 단위마다 콜론 추가된 String 값
     * */
    @JvmStatic
    fun toCurrencyFormText(value: Any?): String {
        if (value == null) return "0"
        val decimalFormat = DecimalFormat("#,###")
        return try {
            decimalFormat.format(value)
        } catch (e: IllegalArgumentException) {
            "0"
        }
    }

    @JvmStatic
    fun toCurrencyFormText(value: Any?, addUnit: Boolean = false): String {
        val result = toCurrencyFormText(value)
        return if (addUnit) {
            "${result}원"
        } else {
            result
        }
    }

    /**
     * 퍼센트
     * @param numerator 분자
     * @param denominator 분모
     * */
    @JvmStatic
    fun getPercentage(numerator: Long?, denominator: Long?): Int {
        return getPercentageDouble(numerator, denominator).toInt()
    }

    @JvmStatic
    fun getPercentageDouble(numerator: Long?, denominator: Long?): Double {
        if (numerator == null || denominator == null) return 0.0
        return if (denominator != 0L) {
            numerator.toDouble() * 100 / denominator.toDouble()
        } else {
            0.0
        }
    }

    /**
     * @param value 변환시킬 숫자
     * @param decimalPointNum 소숫점 자리수
     * @param addUnit "%" 단위 추가 유무
     * @return 지정된 소숫점 자릿수로 포메팅된 String 값
     * */
    @JvmStatic
    fun toRateFormText(value: Double?, decimalPointNum: Int, addUnit: Boolean? = false): String {
        if (value == null) return if (addUnit == true) "0%" else "0"

        var pattern = "#"
        if (decimalPointNum > 0) { // 소수점 자릿수 만큼 더해줌
            pattern += "."
            for (i in 0 until decimalPointNum) {
                pattern += "#"
            }
        }

        return try {
            var result = DecimalFormat(pattern).format(value)

            if (addUnit == true) "$result%" else result
        } catch (e: IllegalArgumentException) {
            if (addUnit == true) "0%" else "0"
        }
    }
}
