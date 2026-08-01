package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class BankDAO {
    private Connection con;

    public BankDAO(Connection con) {
        this.con = con;
    }

    public void deposit(int accountId, double amount) {
        if (con == null) {
            System.err.println("Database connection is null.");
            return;
        }
        try (CallableStatement cs = con.prepareCall("{CALL DepositMoney(?, ?)}")) {
            cs.setInt(1, accountId);
            cs.setDouble(2, amount);
            cs.execute();
            System.out.println("Deposit successful!");
        } catch (SQLException e) {
            System.err.println("Deposit failed: " + e.getMessage());
        }
    }

    public void withdraw(int accountId, double amount) {
        if (con == null) {
            System.err.println("Database connection is null.");
            return;
        }
        try (CallableStatement cs = con.prepareCall("{CALL WithdrawMoney(?, ?)}")) {
            cs.setInt(1, accountId);
            cs.setDouble(2, amount);
            cs.execute();
            System.out.println("Withdrawal successful!");
        } catch (SQLException e) {
            System.err.println("Withdrawal failed: " + e.getMessage());
        }
    }
}
