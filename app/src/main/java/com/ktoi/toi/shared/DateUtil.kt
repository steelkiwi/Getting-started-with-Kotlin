package com.ktoi.toi.shared

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class DateUtil {

    companion object {

        fun formatDate(originalDate: String): String {

            try {
                val sdf = SimpleDateFormat(Constants.DATE_PATTERN, Locale.ENGLISH)
                val timeZone = TimeZone.getTimeZone(Constants.IST_TIME_ZONE)
                sdf.timeZone = timeZone
                val date = sdf.parse(originalDate)
                val calendar = Calendar.getInstance()
                calendar.time = date
                val month = calendar.getDisplayName(
                        Calendar.MONTH,
                        Calendar.SHORT,
                        Locale.getDefault())
                val dayOFMonth = calendar.get(Calendar.DAY_OF_MONTH)
                val hours = calendar.get(Calendar.HOUR_OF_DAY)
                val minutes = calendar.get(Calendar.MINUTE)

                return StringBuilder()
                        .append(dayOFMonth.toString())
                        .append(" ")
                        .append(month)
                        .append(" ")
                        .append(String.format(Locale.getDefault(), Constants.LEADING_ZERO_TEMPLATE, hours))
                        .append(":")
                        .append(String.format(Locale.getDefault(), Constants.LEADING_ZERO_TEMPLATE, minutes))
                        .toString()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return originalDate
        }
    }

}