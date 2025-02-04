public class BankAccount {
    private static String bankName = "MyBank";
    private static int totalAccounts = 0; 

    private final String accountNumber;
    private String accountHolderName;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++; 
    }
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    public void displayAccountDetails() {
        if (this instanceof BankAccount) { 
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder Name: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        }
    }
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Alice", "123456789");
        BankAccount account2 = new BankAccount("Bob", "987654321");

        account1.displayAccountDetails();
        account2.displayAccountDetails();

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}	