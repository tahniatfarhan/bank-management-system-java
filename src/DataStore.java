import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataStore {
    public static Bank loadOrInit(String bankName, Connection con) {
        Bank bank = new Bank(bankName);
        try {
            // Load Customers
            String sqlCust = "SELECT * FROM Customers";
            PreparedStatement psCust = con.prepareStatement(sqlCust);
            ResultSet rsCust = psCust.executeQuery();
            while (rsCust.next()) {
                int id = rsCust.getInt("customer_id");
                String name = rsCust.getString("name");
                String cnic = rsCust.getString("cnic");
                String phone = rsCust.getString("phone");
                String address = rsCust.getString("address");

                bank.addCustomer(new Customer(id, name, cnic, phone, address));
            }
            String sqlAcc = "SELECT * FROM Accounts";
            PreparedStatement psAcc = con.prepareStatement(sqlAcc);
            ResultSet rsAcc = psAcc.executeQuery();
            while (rsAcc.next()) {
                int accId = rsAcc.getInt("account_id");
                int custId = rsAcc.getInt("customer_id");
                String type = rsAcc.getString("account_type");
                double bal = rsAcc.getDouble("balance");

                bank.addAccount(new Account(accId, custId, type, bal));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bank;
    }
}
