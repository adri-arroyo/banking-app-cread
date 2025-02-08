import java.util.ArrayList;
import java.util.List;

/**
 * User class representing a bank customer with multiple accounts.
 */
public class User {
    private final String userId;
    private String name;
    private List<Account> accounts;

    /**
     * Constructs a new User with the specified user ID and name.
     *
     * @param userId the user ID
     * @param name the name of the user
     */
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    /**
     * Adds an account to the user.
     *
     * @param account the account to add
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Getters

    /**
     * Gets the user ID.
     *
     * @return the user ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of accounts associated with the user.
     *
     * @return the list of accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }
}