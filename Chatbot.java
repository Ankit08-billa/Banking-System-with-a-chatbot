// Removed package declaration and unnecessary imports
import java.util.Scanner;

public class Chatbot {
    private BankingService service = new BankingService();
    private SmartAdvisor advisor = new SmartAdvisor();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Hi! I'm your AI Banking Assistant.");
        while (true) {
            System.out.println("Type your command (create, deposit, withdraw, balance, exit):");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "create":
                    handleCreate();
                    break;
                case "deposit":
                    handleDeposit();
                    break;
                case "withdraw":
                    handleWithdraw();
                    break;
                case "balance":
                    handleBalance();
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Sorry, I didn't understand.");
            }
        }
    }

    private void handleCreate() {
        System.out.print("Enter account ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        service.createAccount(id, name);
        System.out.println("Account created!");
    }

    private void handleDeposit() {
        System.out.print("Enter account ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (FraudDetector.isFraudulent(id, amount)) {
            System.out.println("⚠️ Warning: This transaction looks suspicious.");
        }
        if (service.deposit(id, amount)) {
            System.out.println("Deposited successfully.");
        } else {
            System.out.println("Deposit failed. Account not found.");
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter account ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (service.withdraw(id, amount)) {
            System.out.println("Withdrawn successfully.");
        } else {
            System.out.println("Withdrawal failed. Check balance or account ID.");
        }
    }

    private void handleBalance() {
        System.out.print("Enter account ID: ");
        String id = scanner.nextLine();
        double balance = service.getBalance(id);
        if (balance >= 0) {
            System.out.println("Your current balance: ₹" + balance);
            advisor.giveTips(balance);
        } else {
            System.out.println("Account not found.");
        }
    }
}

