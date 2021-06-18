package subtask2

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        val aUpper = a.toUpperCase()
        return search(aUpper, b)
    }

    private fun search(aUpper: String, b: String): String {
        val aToCharArray = aUpper.toCharArray()
        val bToCharArray = b.toCharArray()
        var startIndex = 0;
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
       for (startIndex in a.indices) {
           if (a[startIndex] == charInB) {
               return startIndex
           }
       }
        return -1
    }

    companion object {
        private const val YES = "YES"
        private const val NO = "NO"
    }
}
