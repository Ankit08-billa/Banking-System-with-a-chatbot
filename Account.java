

public class Account {
    private String accountId;
    private String name;
    private double balance;

    public Account(String accountId, String name) {
        this.accountId = accountId;
        this.name = name;
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }
}
