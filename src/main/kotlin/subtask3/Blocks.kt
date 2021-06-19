package subtask3

import java.lang.IllegalArgumentException
import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {

    companion object {
        private val INT_CLASS = Int::class
        private val STRING_CLASS = String::class
        private val DATE_CLASS = LocalDate::class
    }

    // TODO: Complete the following function
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
        var nowDate = LocalDate.now()
        for (obj in blockA) {
            if (obj is LocalDate) {
                if () {
                    //TODO DateFinder
                }
            }
        }
        return
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
