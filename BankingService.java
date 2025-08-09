// Removed package declaration and unnecessary import
import java.util.HashMap;

public class BankingService {
    private static HashMap<String, Account> accounts = new HashMap<>();

    public void createAccount(String id, String name) {
        accounts.put(id, new Account(id, name));
    }

    public boolean deposit(String id, double amount) {
        Account acc = accounts.get(id);
        if (acc != null) {
            acc.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(String id, double amount) {
        Account acc = accounts.get(id);
        if (acc != null) {
            return acc.withdraw(amount);
        }
        return false;
    }

    public double getBalance(String id) {
        Account acc = accounts.get(id);
        return (acc != null) ? acc.getBalance() : -1;
    }

    public boolean accountExists(String id) {
        return accounts.containsKey(id);
    }
}

