package models

data class Transaction(
    val id: String,
    val from: Account,
    val to: Account,
    val amount: Double
)