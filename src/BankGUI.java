import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BankGUI extends JFrame {
    private Bank bank;
    private BankDAO dao;

    public BankGUI(Bank bank) {
        this.bank = bank;

        setTitle(bank.getClass().getSimpleName() + " - Bank Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton viewCustomers = new JButton("View Customers");
        viewCustomers.addActionListener(e -> displayCustomers());

        JButton viewAccounts = new JButton("View Accounts");
        viewAccounts.addActionListener(e -> displayAccounts());

        add(viewCustomers);
        add(viewAccounts);

        setVisible(true);
    }

    private void displayCustomers() {
        List<Customer> customers = bank.getCustomers();
        StringBuilder sb = new StringBuilder();
        for (Customer c : customers) {
            sb.append("ID: ").append(c.getId())
                    .append(", Name: ").append(c.getName())
                    .append(", CNIC: ").append(c.getCnic())
                    .append(", Phone: ").append(c.getPhone())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No customers found.");
    }

    private void displayAccounts() {
        List<Account> accounts = bank.getAccounts();
        StringBuilder sb = new StringBuilder();
        for (Account a : accounts) {
            sb.append("Account ID: ").append(a.getAccountId())
                    .append(", Customer ID: ").append(a.getCustomerId())
                    .append(", Type: ").append(a.getAccountType())
                    .append(", Balance: ").append(a.getBalance())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No accounts found.");
    }
}
