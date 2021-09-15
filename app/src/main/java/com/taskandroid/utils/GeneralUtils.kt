package com.viewtraksol.kyriopos.utils

import java.text.SimpleDateFormat
import java.util.*

class GeneralUtils {

    companion object {
        fun convertServerTimeForOrderText(time: String): String {
            val outputFmt = SimpleDateFormat("hh:mm a")
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZ")
            parser.timeZone = TimeZone.getTimeZone("GMT")
            return outputFmt.format(parser.parse(time))
        }

        fun getDateTimeWithThreshold(value: Int): String {
            val date = SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ssZZZZ",
                Locale.getDefault()
            )
            val timeInSecs: Long = Calendar.getInstance().timeInMillis
            val afterAdding10Mins = Date(timeInSecs + value * 60 * 1000)
            return date.format(afterAdding10Mins)
        }
    }
}