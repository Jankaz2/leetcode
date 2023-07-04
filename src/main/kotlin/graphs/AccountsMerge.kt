package graphs

class UnionFind(n: Int) {
    private val par = IntArray(n) { it }
    private val rank = IntArray(n) { 1 }

    fun find(x: Int): Int {
        var xVar = x
        while (xVar != par[xVar]) {
            par[xVar] = par[par[xVar]]
            xVar = par[xVar]
        }
        return xVar
    }

    fun union(x1: Int, x2: Int): Boolean {
        val p1 = find(x1)
        val p2 = find(x2)
        if (p1 == p2) {
            return false
        }
        if (rank[p1] > rank[p2]) {
            par[p2] = p1
            rank[p1] += rank[p2]
        } else {
            par[p1] = p2
            rank[p2] += rank[p1]
        }
        return true
    }
}

class AccountsMerge {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val uf = UnionFind(accounts.size)
        val emailToAcc = mutableMapOf<String, Int>()

        for ((i, a) in accounts.withIndex()) {
            for (e in a.subList(1, a.size)) {
                if (e in emailToAcc) {
                    uf.union(i, emailToAcc[e]!!)
                } else {
                    emailToAcc[e] = i
                }
            }
        }

        val emailGroup = mutableMapOf<Int, MutableList<String>>()
        for ((e, i) in emailToAcc) {
            val leader = uf.find(i)
            emailGroup
                .getOrPut(leader) {
                    mutableListOf()
                }
                .add(e)
        }

        val res = mutableListOf<List<String>>()
        for ((i, emails) in emailGroup) {
            val name = accounts[i][0]
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

