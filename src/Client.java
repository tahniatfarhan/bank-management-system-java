import java.sql.Connection;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if (con == null) return;

        Bank bank = DataStore.loadOrInit("UET Bank", con);
        BankDAO dao = new BankDAO(con);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account ID for Deposit: ");
        int accId = sc.nextInt();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        dao.deposit(accId, amount);

        System.out.print("Enter Account ID for Withdrawal: ");
        int wAcc = sc.nextInt();
        System.out.print("Enter amount: ");
        double wAmt = sc.nextDouble();
        dao.withdraw(wAcc, wAmt);
    }
}