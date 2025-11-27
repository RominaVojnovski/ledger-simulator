package models

data class LedgerEntry(
    val transactionId: String,
    val accountId: String,
    val amount: Double
)