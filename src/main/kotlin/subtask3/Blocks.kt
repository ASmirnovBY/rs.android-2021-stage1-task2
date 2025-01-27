package subtask3

import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.reflect.KClass

class Blocks {

    companion object {
        private val INT_CLASS = Int::class
        private val STRING_CLASS = String::class
        private val DATE_CLASS = LocalDate::class
    }

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if(blockA.isEmpty()) throw IllegalAccessError("No date in blockA")

        return when(blockB) {
            INT_CLASS -> sumOfInt(blockA)
            STRING_CLASS -> contString(blockA)
            DATE_CLASS -> lastDateOfDates(blockA)
            else -> throw IllegalArgumentException("Only Int, String, LocalDate KClass")
        }
    }

    private fun lastDateOfDates(blockA: Array<*>): Any {
        val nowDate = LocalDate.now()
        var findDate = LocalDate.now()
        var prevDateFirstDate = 0L
        var nextDate = 0L
        for (obj in blockA) {
            if (obj is LocalDate) {
                if (prevDateFirstDate == 0L) {
                    prevDateFirstDate = ChronoUnit.DAYS.between(obj, nowDate)
                }
                nextDate = ChronoUnit.DAYS.between(obj, nowDate)
                if (nextDate <= prevDateFirstDate) {
                    findDate = obj
                }
            }
        }
        val format: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return findDate.format(format)
    }

    private fun contString(blockA: Array<*>): Any {
        val sBuilder = StringBuilder("")
        for (obj in blockA) {
            if(obj is String) {
                sBuilder.append(obj)
            }
        }
        return sBuilder.toString()
    }

    private fun sumOfInt(blockA: Array<*>): Any {
        var sum = 0
        for (obj in blockA) {
            if (obj is Int) {
                sum += obj
            }
        }
        return sum
    }
}
