/**
 * MainAccounts class to test SavingsAccount and CheckingAccount functionalities.
 */
public class MainAccounts {
    public static void main(String[] args) {
        // Test SavingsAccount
        System.out.println("=== Testing SavingsAccount ===");
        SavingsAccount savingsAccount = new SavingsAccount("SA5001", 1000.0, 0.04);
        System.out.println("Created SavingsAccount with Account Number: " + savingsAccount.getAccountNumber());
        System.out.println("Initial Balance: $" + savingsAccount.getBalance());

        // Deposit into SavingsAccount
        savingsAccount.deposit(500.0);
        System.out.println("Balance after deposit of $500: $" + savingsAccount.getBalance());

        // Withdraw from SavingsAccount
        savingsAccount.withdraw(200.0);
        System.out.println("Balance after withdrawal of $200: $" + savingsAccount.getBalance());

        // Add interest to SavingsAccount
        savingsAccount.addInterest();
        System.out.println("Balance after adding interest: $" + savingsAccount.getBalance());

        // Display transaction history for SavingsAccount
        System.out.println("\nTransaction History for SavingsAccount:");
        for (Transaction transaction : savingsAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }

        // Test CheckingAccount
        System.out.println("\n=== Testing CheckingAccount ===");
        CheckingAccount checkingAccount = new CheckingAccount("CA5001", 800.0, 300.0);
        System.out.println("Created CheckingAccount with Account Number: " + checkingAccount.getAccountNumber());
        System.out.println("Initial Balance: $" + checkingAccount.getBalance());
        System.out.println("Withdrawal Limit: $" + checkingAccount.getWithdrawalLimit());

        // Deposit into CheckingAccount
        checkingAccount.deposit(200.0);
        System.out.println("Balance after deposit of $200: $" + checkingAccount.getBalance());

        // Withdraw within limit
        checkingAccount.withdraw(250.0);
        System.out.println("Balance after withdrawal of $250: $" + checkingAccount.getBalance());

        // Attempt to withdraw beyond limit
        checkingAccount.withdraw(400.0);
        System.out.println("Balance after attempting to withdraw $400: $" + checkingAccount.getBalance());

        // Display transaction history for CheckingAccount
        System.out.println("\nTransaction History for CheckingAccount:");
        for (Transaction transaction : checkingAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}
