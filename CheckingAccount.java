/**
 * CheckingAccount is a type of Account with a withdrawal limit.
 */
public class CheckingAccount extends Account {
    private double withdrawalLimit;

    /**
     * Constructs a new CheckingAccount with the specified account number, initial balance, and withdrawal limit.
     *
     * @param accountNumber the account number
     * @param initialBalance the initial balance
     * @param withdrawalLimit the withdrawal limit for the account
     */
    public CheckingAccount(String accountNumber, double initialBalance, double withdrawalLimit) {
        super(accountNumber, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    /**
     * Withdraws the specified amount from the account if the amount is valid and within the withdrawal limit.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.getBalance() && amount <= this.withdrawalLimit) {
            this.balance -= amount;
            this.addTransaction("Withdrawal", amount);
            return true;
        }
        return false;
    }

    /**
     * Gets the withdrawal limit for the account.
     *
     * @return the withdrawal limit
     */
    public double getWithdrawalLimit() {
        return this.withdrawalLimit;
    }

    /**
     * Sets the withdrawal limit for the account.
     *
     * @param withdrawalLimit the new withdrawal limit
     */
    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

}

