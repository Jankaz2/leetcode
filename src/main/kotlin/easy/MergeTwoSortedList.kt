package easy

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var dummy = ListNode(-1)
        val head = dummy
        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                dummy.next = l1
                l1 = l1.next
            } else {
                dummy.next = l2
                l2 = l2.next
            }

            dummy = dummy.next!!
        }

        l1?.let { dummy.next = l1 }
        l2?.let { dummy.next = l2 }

        return head.next
    }
}

fun main() {
    val solution = Solution()
    solution.mergeTwoLists(ListNode(1), ListNode(2))
}
