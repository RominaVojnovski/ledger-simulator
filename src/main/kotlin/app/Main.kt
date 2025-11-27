package app

import models.Account
import models.Transaction
import services.LedgerService

fun main() {
    val ledgerService = LedgerService()

    val acct1 = Account("A1", "Checking", 1000.0)
    val acct2 = Account("A2", "Savings", 500.0)
    val acct3 = Account("A3", "Investment", 2000.0)

    val transactions = listOf(
        Transaction("T1", acct1, acct2, 200.0),
        Transaction("T2", acct2, acct3, 150.0),
        Transaction("T3", acct3, acct1, 300.0)
    )

    val ledgerEntries = transactions.flatMap { ledgerService.postTransaction(it) }

    ledgerService.printLedger(ledgerEntries)
    ledgerService.checkBalance(listOf(acct1, acct2, acct3))
}