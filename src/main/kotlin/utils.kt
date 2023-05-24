class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println()
}
