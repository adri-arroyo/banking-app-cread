/**
 * Main class to test the bank system.
 */
public class Main {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank("MyBank");

        // Load users and accounts from CSV files
        DataLoader.loadUsers("input/users.csv", bank);
        DataLoader.loadAccounts("input/accounts.csv", bank);

        // Now the bank is populated with users and accounts
        // You can perform transactions or display information

        // Example: Display all users and their accounts
        for (User user : bank.getUsers()) {
            System.out.println("\nUser: " + user.getName() + " (ID: " + user.getUserId() + ")");
            for (Account account : user.getAccounts()) {
                System.out.println(" - " + account.getClass().getSimpleName() + " " + account.getAccountNumber() + " Balance: $" + account.getBalance());
            }
        }

        // Perform some transactions
        User user1 = bank.findUserById("U001");
        if (user1 != null) {
            for (Account account : user1.getAccounts()) {
                if (account instanceof SavingsAccount) {
                    if (account.deposit(500)) {
                        SavingsAccount savingsAccount = (SavingsAccount) account;
                        System.out.println("Deposited $500 to Savings Account " + account.getAccountNumber());
                        savingsAccount.addInterest();
                        System.out.println("Added interest to Savings Account " + account.getAccountNumber());
                    } else {
                        System.out.println("Invalid deposit amount for Savings Account " + account.getAccountNumber());
                    }
                } else if (account instanceof CheckingAccount) {
                    if (account.withdraw(200)) {
                        System.out.println("Withdrew $200 from Checking Account " + account.getAccountNumber());
                    } else {
                        System.out.println("Invalid withdrawal amount or exceeds limit for Checking Account " + account.getAccountNumber());
                    }
                }
            }
        }

        // Display updated balances
        System.out.println("\n--- Updated Balances ---");
        for (User user : bank.getUsers()) {
            System.out.println("User: " + user.getName());
            for (Account account : user.getAccounts()) {
                System.out.println(" - " + account.getClass().getSimpleName() + " " + account.getAccountNumber() + " Balance: $" + account.getBalance());
            }
        }
    }
}
