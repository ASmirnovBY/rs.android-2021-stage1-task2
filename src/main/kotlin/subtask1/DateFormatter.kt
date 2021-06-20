package subtask1

import java.lang.StringBuilder

class DateFormatter {

    companion object {

        private val DAY_IN_MONTH = arrayOf(29, 31, 28, 31, 30,
                                           31, 30, 31, 31,
                                           30, 31, 30, 31)

        private val DAY_OF_WEEK = arrayOf("воскресенье", "понедельник", "вторник",
        "среда", "четверг", "пятница", "суббота", "Такого дня не существует" )

        private val MONTH_NAME = arrayOf("високосный февраль","января", "февраля", "марта",
            "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря")

        private val MONTH_SOLUTION_TABLE = arrayOf(5, 1, 1, 4, 6, 2, 4, 0, 3, 5, 1, 3)

        private val MONTH_SOLUTION_TABLE_LEAP = arrayOf(4, 0)

        private const val DAYS_IN_WEEK = 7
    }

    fun toTextDay(day: String, month: String, year: String): String {
        val parsDay = Integer.parseInt(day)
        val parMonth = Integer.parseInt(month)
        val parsYear = Integer.parseInt(year)

        var indexDayOfWeek = 0
        if (validationDate(parsDay, parMonth, parsYear)) {
            indexDayOfWeek = findDayOfWeek(parsDay, parMonth, parsYear)
        } else return DAY_OF_WEEK[7]

        val textDayBuilder = StringBuilder()
        textDayBuilder.append(day).append(" ").append(MONTH_NAME[parMonth])
            .append(", ").append(DAY_OF_WEEK[indexDayOfWeek])

        return textDayBuilder.toString()
    }

    private fun validationDate(day: Int, month: Int, year: Int): Boolean {
        var isValid = false
        if (year < 0) return false
        if (month > 12) return false
        if((day <= DAY_IN_MONTH[month]) && (day > 0)) {
            isValid = true
        }
        return isValid
    }

    private fun isLeapYear(year: Int): Boolean {
        return (year % 4 === 0) && ((year % 100 !== 0)
                    || (year % 400 === 0))
    }

    private fun findDayOfWeek(day: Int, month: Int, year: Int): Int {
        var monthTableIndex = 0
        monthTableIndex = if (isLeapYear(year)) {
            when(month) {
                1 -> MONTH_SOLUTION_TABLE_LEAP[0]
                2 -> MONTH_SOLUTION_TABLE_LEAP[1]
                else -> MONTH_SOLUTION_TABLE[month - 1]
            }
        } else {
            MONTH_SOLUTION_TABLE[month - 1]
        }
        return ((year + (year / 4) + monthTableIndex + day) % DAYS_IN_WEEK)
    }
}
