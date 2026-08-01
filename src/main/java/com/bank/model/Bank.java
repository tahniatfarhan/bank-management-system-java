package com.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Customer> customers;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }
}
