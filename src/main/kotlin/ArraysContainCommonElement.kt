class ArraysContainCommonElement {

    fun arraysContainCommonElement(arr1: IntArray, arr2: IntArray): Boolean {
        val arr1Map = arr1.associateWith { 0 }
        for (i in arr2) {
            if (arr1Map.containsKey(i)) return true
        }
        return false
    }

}

fun main() {
    val solution = ArraysContainCommonElement()

    val arr1 = intArrayOf(1, 2, 3, 4, 5, 6)
    val arr2 = intArrayOf(6, 7, 8, 9)
    val arr3 = intArrayOf(1, 2, 3, 4, 5, 6)
    val arr4 = intArrayOf(7, 8, 9, 10)

    println(solution.arraysContainCommonElement(arr1, arr2))
    println(solution.arraysContainCommonElement(arr3, arr4))
}
