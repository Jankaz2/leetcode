package easy

import java.util.*

class ImplementQueueUsingStacks {

    private val stack1 = Stack<Int>()
    private val stack2 = Stack<Int>()
    private var front = -1;

    fun push(x: Int) {
        if (stack1.isEmpty()) {
            front = x;
        }
        while(stack1.isNotEmpty()) {
            stack2.push(stack1.pop())
        }
        stack2.push(x)
        while(stack2.isNotEmpty()) {
            stack1.push(stack2.pop())
        }
    }

    fun pop(): Int {
        val value = stack1.pop();
        front = if (stack1.isEmpty()) value else stack1.peek();
        return value;
    }

    fun peek(): Int {
        return front;
    }

    fun empty(): Boolean {
        return stack1.isEmpty()
    }

}
