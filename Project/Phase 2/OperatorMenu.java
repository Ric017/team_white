import java.util.Scanner;

/*
 * You will write a Java application to simulate a simple (unrealistic) bank system. This 
 * bank supports three different kinds of accounts: Checking, Gold, and Regular. 
 * Information common to all account types include account number, balance, and 
 * customer information (customer ID, customer name, etc) of the customer who owns 
 * the account.
 * 
 * The Checking account is interest free and charges transaction fees. The first two 
 * monthly transactions are free. It charges a $3 fee for every extra transaction (deposit, 
 * withdrawal).
 * 
 * The Gold account gives a fixed interest at 5% while the Regular account gives fixed 
 * interest at 6%. Regular accounts are charged $10 monthly as a maintenance fee.
 * 
 * Whenever a withdrawal from a Regular or a Checking account is attempted and the 
 * given value is higher than the account's current balance, only the money currently 
 * available on the account is withdrawn. Unlike all other accounts, a Gold account 
 * holder can withdraw indefinitely. There is no transaction fee for customers with Gold 
 * or Regular accounts.
 * 
 * The system is host-centered program currently supporting only one kind of user – a 
 * bank operator who accesses the system to perform regular system administrative work.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Provides a command-line interface for bank operators to interact with the bank system.
 */
public class OperatorMenu {
    private static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("    Bank Menu");
            System.out.println("=====================");
            System.out.println("1. Create Checking Account");
            System.out.println("2. Create Gold Account");
            System.out.println("3. Create Regular Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Display Account Info");
            System.out.println("7. Remove an Account");
            System.out.println("8. Apply end of month (Interest/Fees)");
            System.out.println("9. Display Bank Statistics");
            System.out.println("10. Exit");
            System.out.print("\nPlease input your choice (1-10): ");

            int choice = 0;

            try {
                choice = scanner.nextInt();
            }
            catch (Exception e) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    createCheckingAccount();
                    break;
                case 2:
                    createGoldAccount();
                    break;
                case 3:
                    createRegularAccount();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    withdraw();
                    break;
                case 6:
                    viewAccount();
                    break;
                case 7:
                    removeAccount();
                    break;
                case 8:
                    applyEndOfMonth();
                    break;
                case 9:
                    displayBankStatistics();
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the Bank System. Have a good day!");
        scanner.close();
    }

    private static String requestCustomerName() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please input the customer name: ");
            String customerName = scanner.nextLine();

            // Verify a name was entered –– a name must contain at least one character, followed by a space, and then at least one more character
            while (!customerName.matches(".* .+")) {
                System.out.println("Invalid name. Please try again.");
                System.out.print("Please input the customer name: ");
                customerName = scanner.nextLine();
            }

            return customerName;
        } catch (Exception e) {
            System.out.println("Invalid name. Please try again.");
            return requestCustomerName(); // Recursive call to request the customer name again
        }
    }

    private static String requestCustomerId() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please input the customer ID: ");
            String customerId = scanner.nextLine();

            // Verify a valid customer ID was entered –– a valid customer ID must contain at least one character
            while (customerId.isEmpty()) {
                System.out.println("Invalid customer ID. Please try again.");
                System.out.print("Please input the customer ID: ");
                customerId = scanner.nextLine();
            }

            return customerId;
        } catch (Exception e) {
            System.out.println("Invalid customer ID. Please try again.");
            return requestCustomerId(); // Recursive call to request the customer ID again
        }
    }

    private static void createCheckingAccount() {
        // Prompt for the customer name
        String customerName = requestCustomerName();

        // Prompt for the customer ID
        String customerId = requestCustomerId();

        // Create the account and add it to the list
        Customer customer = new Customer(customerId, customerName);
        Account account = new Checking(0, customer);
        accounts.add(account);
        System.out.println("\nAccount " + account.getAccountNumber() + " created successfully!\n");
    }

    private static void createGoldAccount() {
        // Prompt for the customer name
        String customerName = requestCustomerName();

        // Prompt for the customer ID
        String customerId = requestCustomerId();

        // Create the account and add it to the list
        Customer customer = new Customer(customerId, customerName);
        Account account = new Gold(0, customer);
        accounts.add(account);
        System.out.println("\nAccount " + account.getAccountNumber() + " created successfully!\n");
    }

    private static void createRegularAccount() {
        // Prompt for the customer name
        String customerName = requestCustomerName();

        // Prompt for the customer ID
        String customerId = requestCustomerId();

        // Create the account and add it to the list
        Customer customer = new Customer(customerId, customerName);
        Account account = new Regular(0, customer);
        accounts.add(account);
        System.out.println("\nAccount " + account.getAccountNumber() + " created successfully!\n");
    }

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
    
        // Prompt for the account number
        System.out.print("Please input the account number: ");
        int accountNumber = scanner.nextInt();
    
        // Prompt for the deposit amount
        System.out.print("Please input the amount: ");
        double amount = scanner.nextDouble();
    
        // Find the account and deposit the amount
        boolean accountFound = false;
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                account.deposit(amount);
                accountFound = true;
                System.out.println("Account updated successfully!");
                break;
            }
        }
    
        if (!accountFound) {
            System.out.println("\nAccount number not found!");
        }
    }    

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);
    
        // Prompt for the account number
        System.out.print("Please input the account number: ");
        int accountNumber = scanner.nextInt();
    
        // Prompt for the withdrawal amount
        System.out.print("Please enter the amount: ");
        double amount = scanner.nextDouble();
    
        // Find the account and attempt to withdraw the amount
        boolean accountFound = false;
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                accountFound = true;
                account.withdraw(amount);
                System.out.println("Account updated successfully!");
                break;
            }
        }
    
        if (!accountFound) {
            System.out.println("\nAccount number not found!");
        }
    }    

    private static void viewAccount() {
        Scanner scanner = new Scanner(System.in);
    
        // Prompt for the account number
        System.out.print("Please input the account number: ");
        int accountNumber = scanner.nextInt();
    
        // Find the account and display its details
        boolean accountFound = false;
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                accountFound = true;
                System.out.println("\nDetails of account# " + accountNumber + " :");
                System.out.println(account); // Assuming a meaningful toString() method in Account class
                break;
            }
        }
    
        if (!accountFound) {
            System.out.println("\nAccount number not found!");
        }
    }

    private static void removeAccount() {
        Scanner scanner = new Scanner(System.in);
    
        // Prompt for the account number
        System.out.print("Please input the account number: ");
        int accountNumber = scanner.nextInt();
    
        // Find the account and remove it
        boolean accountFound = false;
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                accountFound = true;
                accounts.remove(account);
                System.out.println("Account removed successfully!");
                break;
            }
        }
    
        if (!accountFound) {
            System.out.println("\nAccount number not found!");
        }
    }

    private static void applyEndOfMonth() {
        for (Account account : accounts) {
            account.applyEndOfMonth();
        }
        System.out.println("\nEnd of month processing completed!");
    }

    // Method to display bank statistics
    private static void displayBankStatistics() {

        if(accounts.size() == 0) {
            System.out.println("\nThe bank has no accounts.\n");
            return;
        }

        double totalBalance = 0;
        int zeroBalanceAccounts = 0;
        double maxBalance = Double.MIN_VALUE;
        int maxBalanceAccountNumber = -1;

        for (Account account : accounts) {
            totalBalance += account.getBalance();
            if (account.getBalance() == 0) {
                zeroBalanceAccounts++;
            }
            if (account.getBalance() > maxBalance) {
                maxBalance = account.getBalance();
                maxBalanceAccountNumber = account.getAccountNumber();
            }
        }

        double averageBalance = totalBalance / accounts.size();

        System.out.println("Total sum of all accounts: $" + totalBalance);
        System.out.println("Number of zero-balance accounts: " + zeroBalanceAccounts);
        System.out.println("Average balance of accounts: $" + averageBalance);
        System.out.println("Account with largest balance: Account " + maxBalanceAccountNumber + " with balance $" + maxBalance);
    }
}