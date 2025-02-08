import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class representing a bank account.
 */
public abstract class Account {
    private final String accountNumber;
    protected double balance;
    protected List<Transaction> transactionHistory;

    /**
     * Constructs a new Account with the specified account number and initial balance.
     *
     * @param accountNumber the account number
     * @param initialBalance the initial balance
     */
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount the amount to deposit
     * @return true if the deposit was successful, false otherwise
     */
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit", amount);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    public abstract boolean withdraw(double amount);

    /**
     * Adds a transaction to the transaction history.
     *
     * @param type the type of transaction
     * @param amount the amount of the transaction
     */
    protected void addTransaction(String type, double amount) {
        Transaction transaction = new Transaction(accountNumber, type, amount, balance);
        transactionHistory.add(transaction);
    }

    // Getters

    /**
     * Gets the account number.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the current balance.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the transaction history.
     *
     * @return the transaction history
     */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
