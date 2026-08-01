package com.bank.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank("Test Bank");
    }

    @Test
    @DisplayName("Should add customer successfully")
    public void testAddCustomer() {
        Customer customer = new Customer(1, "John Doe", "12345-6789012-3", "03001234567", "Lahore, Pakistan");
        bank.addCustomer(customer);

        assertEquals(1, bank.getCustomers().size());
        assertEquals("John Doe", bank.getCustomers().get(0).getName());
        assertEquals("Lahore, Pakistan", bank.getCustomers().get(0).getAddress());
    }

    @Test
    @DisplayName("Should add account successfully")
    public void testAddAccount() {
        Account account = new Account(101, 1, "Savings", 5000.0);
        bank.addAccount(account);

        assertEquals(1, bank.getAccounts().size());
        assertEquals(101, bank.getAccounts().get(0).getAccountId());
        assertEquals(5000.0, bank.getAccounts().get(0).getBalance());
    }

    @Test
    @DisplayName("Should update account balance correctly")
    public void testUpdateBalance() {
        Account account = new Account(101, 1, "Savings", 5000.0);
        account.setBalance(7500.0);

        assertEquals(7500.0, account.getBalance());
    }
}
