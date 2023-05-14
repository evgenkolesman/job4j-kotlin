package ru.kolesnikov.safe

class BankService {

    private val users: HashMap<User, ArrayList<Account>> = HashMap()

    fun addUser(user: User) {
        users.putIfAbsent(user, ArrayList())
    }

    fun findByRequisite(passport: String, requisite: String): Account? {
        val user = findByPassport(passport) ?: return null
        return users[user]?.firstOrNull { account -> account.requisite == requisite }

    }

    fun addAccount(passport: String, account: Account) {
        val user = findByPassport(passport)
            ?: return
        users[user]?.add(account)

    }


    fun findByPassport(passport: String): User? {
        for (user in users.keys) {
            if (user.passportNumber == passport) {
                return user
            }
        }
        return null
    }

    fun transferMoney(
        srcPassport: String, srcRequisite: String,
        destPassport: String, descRequisite: String, amount: Double
    ): Boolean {
        val source = findByRequisite(srcPassport, srcRequisite)
        val dest = findByRequisite(destPassport, descRequisite)
        source ?. apply { balance.minus(amount.toFloat()) }
        dest ?.apply { balance + amount.toFloat() }
        return true
    }

}

fun main() {
    val bank = BankService()
    bank.addUser(User("321", "Petr Arsentev", passportNumber = "3211"))
    var user = bank.findByPassport("3211")
    System.out.println(user?.name)
    user = bank.findByPassport("321")
    System.out.println(user?.name)
}