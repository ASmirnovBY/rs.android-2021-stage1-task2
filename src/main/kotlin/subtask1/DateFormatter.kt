package subtask1

class DateFormatter {
    companion object {
        private val DAY_IN_MONTH = arrayOf(31, 28, 31, 30,
                                           31, 30, 31, 31,
                                           30, 31, 30, 31, 29)

        private val DAY_OF_WEEK = arrayOf("Такого дня не существует", "понедельник", "вторник",
        "среда", "четверг", "пятница", "суббота", "воскресенье")

        private val MONTH_NAME = arrayOf("високосный февраль","января", "февраля", "марта",
            "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря")
    }

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {

        return ""
    }

    private fun isLeapYear(year: String): Int {
        val parsYear = Integer.parseInt(year)
        return if ((parsYear % 4 === 0) && ((parsYear % 100 !== 0)
                    || (parsYear % 400 === 0))) 1 else 0
    }
}
