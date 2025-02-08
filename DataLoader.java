import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * DataLoader is a helper class that provides methods to load users and accounts from CSV files.
 */
public class DataLoader {

    /**
     * Loads users from a CSV file and adds them to the specified bank.
     *
     * @param filePath the path to the CSV file containing user data
     * @param bank the bank to which the users will be added
     */
    public static void loadUsers(String filePath, Bank bank) {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                bank.addUser(new User(id, name));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads accounts from a CSV file and adds them to the corresponding users in the specified bank.
     *
     * @param filePath the path to the CSV file containing account data
     * @param bank the bank to which the accounts will be added
     */
    public static void loadAccounts(String filePath, Bank bank) {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                String accountNumber = data[0];
                String userId = data[1];
                String accountType = data[2];
                double initialBalance = Double.parseDouble(data[3]);
                double interestRate = Double.parseDouble(data[4]);
                
                User user = bank.findUserById(userId);
                if (user != null) {
                    if (accountType.equals("Checking")) {
                        CheckingAccount account = new CheckingAccount(accountNumber, initialBalance, interestRate);
                        user.addAccount(account);
                    } else if (accountType.equals("Savings")) {
                        SavingsAccount account = new SavingsAccount(accountNumber, initialBalance, interestRate);
                        user.addAccount(account);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
