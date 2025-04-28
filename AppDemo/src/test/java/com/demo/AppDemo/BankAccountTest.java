package com.demo.AppDemo;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        // This will run before each test to initialize the account.
        account = new BankAccount("John Doe", 1000.0);
    }

    @Test
    public void testAccountCreation() {
        assertEquals("John Doe", account.getAccountHolder());
        assertEquals(1000.0, account.getBalance(), 0.0);
    }

    @Test
    public void testDeposit() {
        account.deposit(200.0);
        assertEquals(1200.0, account.getBalance(), 0.0);
    }

    @Test
    public void testWithdraw() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), 0.0);
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        try {
            account.withdraw(1200.0); // Withdrawal more than balance
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Insufficient balance", e.getMessage());
        }
    }

    @Test
    public void testDepositNegativeAmount() {
        try {
            account.deposit(-100.0); // Negative deposit amount
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Deposit amount must be positive", e.getMessage());
        }
    }

    @Test
    public void testWithdrawNegativeAmount() {
        try {
            account.withdraw(-50.0); // Negative withdraw amount
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Withdraw amount must be positive", e.getMessage());
        }
    }

    @Test
    public void testNegativeInitialBalance() {
        try {
            new BankAccount("Jane Doe", -100.0); // Negative initial balance
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Initial balance cannot be negative", e.getMessage());
        }
    }
}
