import java.sql.CallableStatement;
import java.sql.Connection;

public class BankDAO {
    private Connection con;

    public BankDAO(Connection con) {
        this.con = con;
    }

    public void deposit(int accountId, double amount) {
        try {
            CallableStatement cs = con.prepareCall("{CALL DepositMoney(?, ?)}");
            cs.setInt(1, accountId);
            cs.setDouble(2, amount);
            cs.execute();
            System.out.println("Deposit successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdraw(int accountId, double amount) {
        try {
            CallableStatement cs = con.prepareCall("{CALL WithdrawMoney(?, ?)}");
            cs.setInt(1, accountId);
            cs.setDouble(2, amount);
            cs.execute();
            System.out.println("Withdrawal successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
