package services

import models.Account
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LedgerServiceTest {
    private lateinit var ledgerService: LedgerService
    private lateinit var account1: Account
    private lateinit var account2: Account

    @BeforeEach
    fun setUp() {
        ledgerService = LedgerService()
    }

    @Test
    fun `deposit should increase account balance`() {
        val account = Account("A1", "Romina", 100.0)

        ledgerService.deposit(account, 50.0)

        assertEquals(150.0, account.balance)
    }
}