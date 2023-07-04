package graphs

class UnionFind(n: Int) {
    private val parent = IntArray(n) { it }
    private val rank = IntArray(n) { 1 }

    fun find(x: Int): Int {
        var temp = parent[x]
        while (temp != parent[temp]) {
            parent[temp] = parent[parent[temp]]
            temp = parent[temp]
        }
        return temp
    }

    fun union(x1: Int, x2: Int): Boolean {
        val p1 = find(x1)
        val p2 = find(x2)

        if (p1 == p2) return false

        if (rank[p1] > rank[p2]) {
            rank[p2] = p1
            rank[p1] += rank[p2]
        } else {
            rank[p1] = p2
            rank[p2] += rank[p1]
        }

        return true
    }
}

class AccountsMerge {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val uf = UnionFind(accounts.size)
        val emailToAcc = mutableMapOf<String, Int>()

        for ((index, acc) in accounts.withIndex()) {
            for (email in acc.subList(1, acc.size)) {
                if (email in emailToAcc) {
                    uf.union(index, emailToAcc[email]!!)
                } else {
                    emailToAcc[email] = index
                }
            }
        }

        val emailGroup = mutableMapOf<Int, MutableList<String>>()
        for ((email, index) in emailToAcc) {
            val leader = uf.find(index)
            emailGroup.getOrPut(leader) { mutableListOf() }.add(email)
        }

        val res = mutableListOf<List<String>>()
        for ((leader, emails) in emailGroup) {
            val name = accounts[leader][0]
            res.add(listOf(name) + emails.sorted())
        }

        return res
    }
}

fun main() {
    val solution = AccountsMerge()
    val accounts = listOf(
        listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
        listOf("John", "johnsmith@mail.com", "john00@mail.com"),
        listOf("Mary", "mary@mail.com"),
        listOf("John", "johnnybravo@mail.com"),
    )

    solution.accountsMerge(accounts)
}

