package services

import models.Account
import models.LedgerEntry
import models.Transaction

class LedgerService {
    fun withdraw(account: Account, amount: Double) {
        require(amount > 0) { "Amount must be positive." }
        require(account.balance >= amount) { "Insufficient funds." }

        account.balance -= amount
    }

    fun deposit(account: Account, amount: Double) {
        require(amount > 0) { "Amount must be positive." }
        account.balance += amount
    }

    fun postTransaction(transaction: Transaction): List<LedgerEntry> {
        withdraw(transaction.from, transaction.amount)
        deposit(transaction.to, transaction.amount)

        return listOf(
            LedgerEntry(transaction.id, transaction.from.id, -transaction.amount),
            LedgerEntry(transaction.id, transaction.to.id, transaction.amount)
        )
    }

    fun checkBalance(accounts: List<Account>) {
        val total = accounts.sumOf { it.balance }
        println("Total across accounts: $total")
    }

    fun printLedger(entries: List<LedgerEntry>) {
        println("Ledger:")
        entries.forEach { println(it) }
    }

}