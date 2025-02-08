/**
 * Transaction class representing a transaction on an account.
 */
public class Transaction {
    private final String accountNumber;
    private final String type; // "Deposit", "Withdrawal", "Interest"
    private final double amount;
    private final double balanceAfterTransaction;

    /**
     * Constructs a new Transaction with the specified details.
     *
     * @param accountNumber the account number
     * @param type the type of transaction
     * @param amount the amount of the transaction
     * @param balanceAfterTransaction the balance after the transaction
     */
    public Transaction(String accountNumber, String type, double amount, double balanceAfterTransaction) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
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
     * Gets the type of transaction.
     *
     * @return the type of transaction
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the amount of the transaction.
     *
     * @return the amount of the transaction
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the balance after the transaction.
     *
     * @return the balance after the transaction
     */
    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    /**
     * Returns a string representation of the transaction.
     *
     * @return a string representation of the transaction
     */
    @Override
    public String toString() {
        return type + " of $" + amount + " on account " + accountNumber + ". Balance: $" + balanceAfterTransaction;
    }
}
