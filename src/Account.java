public class Account {
    private int accountId;
    private int customerId;
    private String accountType;
    private double balance;
    public Account(int accountId, int customerId, String accountType, double balance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
    }
    public int getAccountId() {
        return accountId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getAccountType() {
        return accountType;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}