package easy

class MergeSortedArrays {
    fun mergeSortedArrays(arr1: IntArray, arr2: IntArray): IntArray {
        if (arr1.isEmpty()) return arr2
        if (arr2.isEmpty()) return arr1

        val mergedArray = IntArray(arr1.size + arr2.size)
        var i = 0
        var j = 0
        var k = 0

        while (i < arr1.size && j < arr2.size) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k] = arr1[i++]
            } else {
                mergedArray[k] = arr2[j++]
            }
            k++
        }

        while (i < arr1.size) {
            mergedArray[k++] = arr1[i++]
        }

        while (j < arr2.size) {
            mergedArray[k++] = arr2[j++]
        }

        return mergedArray
    }
}

fun main() {
    val solution = MergeSortedArrays()
    val result = solution.mergeSortedArrays(intArrayOf(0, 3, 4, 31), intArrayOf(4, 6, 30))
    result.forEach { print("$it ") }
}
