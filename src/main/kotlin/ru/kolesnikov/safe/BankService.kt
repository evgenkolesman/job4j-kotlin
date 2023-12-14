package ru.kolesnikov.safe

class BankService {

    private val users: HashMap<User, ArrayList<Account>> = HashMap()

    fun addUser(user: User) {
        users.putIfAbsent(user, ArrayList())
    }

    private fun findByRequisite(passport: String, requisite: String): Account? =
        findByPassport(passport).let { user ->
            users[user]?.firstOrNull { account ->
                account.requisite == requisite
            }
        }

    fun addAccount(passport: String, account: Account) = findByPassport(passport).let { user ->
        users[user]?.add(account)
    }


    fun findByPassport(passport: String): User? {
        return users.keys.firstOrNull { it.passportNumber == passport }
    }

    fun transferMoney(
        srcPassport: String, srcRequisite: String,
        destPassport: String, descRequisite: String, amount: Double
    ): Boolean {
        val source = findByRequisite(srcPassport, srcRequisite)
        val dest = findByRequisite(destPassport, descRequisite)
        source?.balance?.minus(amount.toFloat())
        dest?.let { d -> d.balance + amount.toFloat() }
        return true
    }

}

fun main() {
    val bank = BankService()
    bank.addUser(User("321", "Petr Arsentev", passportNumber = "3211"))
    var user = bank.findByPassport("3211")
    println(user?.name)
    user = bank.findByPassport("321")
    println(user?.name)
}