package subtask2

class Abbreviation {

    companion object {
        private const val YES = "YES"
        private const val NO = "NO"
    }

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        val aUpper = a.toUpperCase()
        return search(aUpper, b)
    }

    private fun search(aUpper: String, b: String): String {
        val aToCharArray = aUpper.toCharArray()
        val bToCharArray = b.toCharArray()
        var startIndex = -1;
        for(i in b.indices) {
           startIndex = searchCharBinAIndex(aToCharArray, bToCharArray[i], startIndex)
           if (startIndex == -1) {
                return NO
            }
        }
        return YES
    }

    private fun searchCharBinAIndex(a: CharArray, charInB: Char,
                                    startIndex: Int): Int {
       val shiftStartIndex = startIndex + 1
       for (i in shiftStartIndex until a.size) {
           if (a[i] == charInB) {
               return i
           }
       }
        return -1
    }
}
