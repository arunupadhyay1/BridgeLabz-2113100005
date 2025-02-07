public class BankTest {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount();
        savings.accountNumber = "SAV123";
        savings.balance = 5000;
        savings.interestRate = 3.5;
        savings.displayAccountType();

        CheckingAccount checking = new CheckingAccount();
        checking.accountNumber = "CHK123";
        checking.balance = 2000;
        checking.withdrawalLimit = 1000;
        checking.displayAccountType();
    }
}

class BankAccount {
    String accountNumber;
    double balance;

    void displayAccountType() {}
}

class SavingsAccount extends BankAccount {
    double interestRate;

    void displayAccountType() {
        System.out.println("Account Type: Savings");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    void displayAccountType() {
        System.out.println("Account Type: Checking");
    }
}

class FixedDepositAccount extends BankAccount {
    int maturityPeriod;

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit");
    }
}
