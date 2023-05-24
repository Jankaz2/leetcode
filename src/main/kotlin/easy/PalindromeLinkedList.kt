package easy

import ListNode
import java.util.Stack

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true

        val firstHalfOfGivenList = Stack<Int>()
        var slow = head
        var fast = head
        var size = 0

        while (fast?.next != null) {
            firstHalfOfGivenList.push(slow?.`val`!!)
            slow = slow.next
            fast = fast.next?.next
            size += 2
        }

        fast?.let { size++ }

        if (size % 2 == 1) {
            slow = slow?.next
        }

        while (slow != null) {
            if (slow.`val` != firstHalfOfGivenList.pop()) {
                return false
            }
            slow = slow.next
        }

        return true
    }
}

fun main() {
    val solution = PalindromeLinkedList()
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(1)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    head.next!!.next!!.next!!.next!!.next = ListNode(6)
    println(solution.isPalindrome(head))
}
