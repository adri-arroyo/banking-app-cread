/**
 * SavingsAccount is a type of Account that accrues interest over time.
 */
public class SavingsAccount extends Account {
    private double interestRate;

    /**
     * Constructs a new SavingsAccount with the specified account number, balance, and interest rate.
     *
     * @param accountNumber the account number
     * @param balance the initial balance
     * @param interestRate the interest rate for the account
     */
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    /**
     * Withdraws the specified amount from the account if the amount is valid.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.getBalance()) {
            this.balance -= amount;
            this.addTransaction("Withdrawal", amount);
            return true;
        }
        return false;
    }

    /**
     * Adds interest to the account balance based on the current interest rate.
     */
    public void addInterest() {
        double interest = this.getBalance() * this.interestRate;
        
        this.balance += interest;
        this.addTransaction("Interest", interest);
    }

    /**
     * Gets the interest rate for the account.
     *
     * @return the interest rate
     */
    public double getInterestRate() {
        return this.interestRate;
    }

    /**
     * Sets the interest rate for the account.
     *
     * @param interestRate the new interest rate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
