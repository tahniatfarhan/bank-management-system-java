package com.bank.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class BankDAOTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private CallableStatement mockCallableStatement;

    private BankDAO bankDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        when(mockConnection.prepareCall(anyString())).thenReturn(mockCallableStatement);
        bankDAO = new BankDAO(mockConnection);
    }

    @Test
    @DisplayName("Should execute deposit procedure without throwing exception")
    public void testDeposit() throws SQLException {
        bankDAO.deposit(101, 1500.0);

        verify(mockConnection, times(1)).prepareCall("{CALL DepositMoney(?, ?)}");
        verify(mockCallableStatement, times(1)).setInt(1, 101);
        verify(mockCallableStatement, times(1)).setDouble(2, 1500.0);
        verify(mockCallableStatement, times(1)).execute();
        verify(mockCallableStatement, times(1)).close();
    }

    @Test
    @DisplayName("Should execute withdraw procedure without throwing exception")
    public void testWithdraw() throws SQLException {
        bankDAO.withdraw(101, 500.0);

        verify(mockConnection, times(1)).prepareCall("{CALL WithdrawMoney(?, ?)}");
        verify(mockCallableStatement, times(1)).setInt(1, 101);
        verify(mockCallableStatement, times(1)).setDouble(2, 500.0);
        verify(mockCallableStatement, times(1)).execute();
        verify(mockCallableStatement, times(1)).close();
    }
}
