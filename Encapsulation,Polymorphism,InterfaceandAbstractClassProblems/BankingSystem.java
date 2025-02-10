public class BankingSystem {
    public static void main(String[] args) {
        BankAccount savingsAccount = new SavingsAccount("SAV123", "Alice", 0.04);
        savingsAccount.deposit(1000);
        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Interest Earned: " + savingsAccount.calculateInterest());

        BankAccount currentAccount = new CurrentAccount("CUR123", "Bob", 500);
        currentAccount.deposit(2000);
        System.out.println("Current Account Balance: " + currentAccount.getBalance());
        System.out.println("Interest Earned: " + currentAccount.calculateInterest());
    }
}
// Interface
interface Loanable {
    void applyForLoan();
    boolean calculateLoanEligibility();
}

// Abstract Class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public abstract double calculateInterest();

    public double getBalance() {
        return balance;
    }
}

// Subclass for Savings Account
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double interestRate) {
        super(accountNumber, holderName);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
}

// Subclass for Current Account
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double overdraftLimit) {
        super(accountNumber, holderName);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest for current accounts
    }
}

