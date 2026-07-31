import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();
        if (connection == null) {
            System.out.println(" Database connection failed! Program stopped.");
            return;
        }

        Bank bank = DataStore.loadOrInit("UET Bank", connection);

        javax.swing.SwingUtilities.invokeLater(() -> new BankGUI(bank));
    }
}
