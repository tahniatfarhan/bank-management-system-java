package com.bank;

import com.bank.dao.DBConnection;
import com.bank.dao.DataStore;
import com.bank.gui.BankGUI;
import com.bank.model.Bank;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = DBConnection.getConnection();
        if (connection == null) {
            System.err.println(" Database connection failed! Program stopped.");
            return;
        }

        Bank bank = DataStore.loadOrInit("UET Bank", connection);

        javax.swing.SwingUtilities.invokeLater(() -> new BankGUI(bank));
    }
}
