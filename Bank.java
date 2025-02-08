import java.util.ArrayList;
import java.util.List;

/**
 * Bank class representing a bank with users.
 */
public class Bank {

    private final String bankName;
    private List<User> users;

    /**
     * Constructs a new Bank with the specified name.
     *
     * @param bankName the name of the bank
     */
    public Bank(String bankName) {
        this.bankName = bankName;
        this.users = new ArrayList<>();
    }

    /**
     * Adds an user to the bank.
     *
     * @param user the user to add
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Finds an user by their user ID.
     *
     * @param userId the user ID
     * @return the user with the specified ID, or null if not found
     */
    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    // Getters

    /**
     * Gets the list of users in the bank.
     *
     * @return the list of users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Gets the name of the bank.
     *
     * @return the name of the bank
     */
    public String getBankName() {
        return bankName;
    }

}

