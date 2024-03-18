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
            System.out.println("Welcome to the Bank System. Please choose an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Account");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    viewAccount();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Exiting the Bank System. Have a good day!");
        scanner.close();
    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating a new account:");
        
        // Prompt for account type
        System.out.println("Enter account type (1 for Checking, 2 for Gold, 3 for Regular):");
        int accountType = scanner.nextInt();
    
        // Prompt for account number
        System.out.println("Enter account number:");
        String accountNumber = scanner.next();
    
        // Prompt for initial balance
        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();
    
        // Prompt for customer details
        System.out.println("Enter customer ID:");
        String customerId = scanner.next();
        System.out.println("Enter customer name:");
        String customerName = scanner.next();
        Customer customer = new Customer(customerId, customerName);
    
        Account account = null;
        switch (accountType) {
            case 1:
                account = new Checking(accountNumber, balance, customer);
                break;
            case 2:
                account = new Gold(accountNumber, balance, customer);
                break;
            case 3:
                account = new Regular(accountNumber, balance, customer);
                break;
            default:
                System.out.println("Invalid account type.");
                return;
        }
    
        accounts.add(account);
        System.out.println("Account created successfully: " + account);
    }    

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Depositing money:");
    
        // Prompt for the account number
        System.out.println("Enter the account number:");
        String accountNumber = scanner.next();
    
        // Prompt for the deposit amount
        System.out.println("Enter the amount to deposit:");
        double amount = scanner.nextDouble();
    
        // Find the account and deposit the amount
        boolean accountFound = false;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amount);
                accountFound = true;
                System.out.println("Deposited $" + amount + " into account " + accountNumber);
                break;
            }
        }
    
        if (!accountFound) {
            System.out.println("Account not found.");
        }
    }    

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Withdrawing money:");
    
        // Prompt for the account number
        System.out.println("Enter the account number:");
        String accountNumber = scanner.next();
    
        // Prompt for the withdrawal amount
        System.out.println("Enter the amount to withdraw:");
        double amount = scanner.nextDouble();
    
        // Find the account and attempt to withdraw the amount
        boolean accountFound = false;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accountFound = true;
                if (account instanceof Gold || account.getBalance() >= amount) {
                    account.withdraw(amount);
                    System.out.println("Withdrew $" + amount + " from account " + accountNumber);
                } else {
                    System.out.println("Insufficient funds for withdrawal.");
                }
                break;
            }
        }
    
        if (!accountFound) {
            System.out.println("Account not found.");
        }
    }    

    private static void viewAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Viewing account details:");
    
        // Prompt for the account number
        System.out.println("Enter the account number:");
        String accountNumber = scanner.next();
    
        // Find the account and display its details
        boolean accountFound = false;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accountFound = true;
                System.out.println("Account Details:");
                System.out.println(account); // Assuming a meaningful toString() method in Account class
                break;
            }
        }
    
        if (!accountFound) {
            System.out.println("Account not found.");
        }
    }
}