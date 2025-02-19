import java.util.*;

class BankingSystem {
    private static Map<String, Double> accounts = new HashMap<>();
    private static Queue<String> withdrawalQueue = new LinkedList<>();

    public static void main(String[] args) {
        addAccount("12345", 1000.0);
        addAccount("67890", 2000.0);
        processWithdrawals();
    }

    public static void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public static void requestWithdrawal(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Withdrawal request denied for account: " + accountNumber);
        }
    }

    public static void processWithdrawals() {
        requestWithdrawal("12345", 200.0);
        requestWithdrawal("67890", 1500.0);
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            double amount = 200.0; // Example amount to withdraw
            double newBalance = accounts.get(accountNumber) - amount;
            accounts.put(accountNumber, newBalance);
            System.out.println("Processed withdrawal of $" + amount + " from account " + accountNumber + ". New balance: $" + newBalance);
        }
    }
}