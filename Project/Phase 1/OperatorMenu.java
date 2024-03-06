import java.util.Scanner;

public class OperatorMenu {
    
    public void main() {
        Scanner scanner = new Scanner(System.in);

        /*
         * Print the Operator Menu:
         * 1. Create a Checking account
         * 2. Create a Gold account
         * 3. Create a Regular account
         * 4. Deposite a specified amount of money to a given account
         * 5. Witdraw money from a given account
         * 6. Display account information
         * 7. Remove an account
         * 8. Apply end of month account updates. This function should be used once
         *    every end of month and will apply interest to the Regular and Gold accounts
         *    and deduct transaction fees from Checking accounts whenever applicable
         * 9. Display Bank statistics: this feature will display a simple report for bank
         *    administrators that include things like the total sum of all accounts in the
         *    bank, number of zero-balance accounts, average balance of accounts, the
         *    account with largest balance, etc.
         * 10. Exit: quit the system
         */

        System.out.println("Operator Menu:");
        System.out.println("1. Create a Checking account");
        System.out.println("2. Create a Gold account");
        System.out.println("3. Create a Regular account");
        System.out.println("4. Deposit a specified amount of money to a given account");
        System.out.println("5. Withdraw money from a given account");
        System.out.println("6. Display account information");
        System.out.println("7. Remove an account");
        System.out.println("8. Apply end of month account updates");
        System.out.println("9. Display Bank statistics");
        System.out.println("10. Exit");

        System.out.println("Enter your choice: ");
        Integer choice = scanner.nextInt();

        switch(choice) {
            case 1:
                // Create a Checking account
                Float monthlyFee = 0.0f;
                Float fixedInterestRate = 0.0f;

                this.createAccount(monthlyFee, fixedInterestRate, "checking");
                break;
            case 2:
                // Create a Gold account
                monthlyFee = 5.0f;
                fixedInterestRate = 0.0f;

                this.createAccount(monthlyFee, fixedInterestRate, "gold");
                break;
            case 3:
                // Create a Regular account
                monthlyFee = 10.0f;
                fixedInterestRate = 6.0f;

                this.createAccount(monthlyFee, fixedInterestRate, "regular");
                break;
            case 4:
                // Deposit a specified amount of money to a given account
                Account account = this.chooseAccount();

                System.out.println("Enter the amount to deposit: ");
                Float amount = scanner.nextFloat();
                break;
            case 5:
                // Withdraw money from a given account
                break;
            case 6:
                // Display account information
                break;
            case 7:
                // Remove an account
                break;
            case 8:
                // Apply end of month account updates
                break;
            case 9:
                // Display Bank statistics
                break;
            case 10:
                // Exit
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }

    public Integer chooseAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the account number: ");
        Integer accountNumber = scanner.nextInt();


        Account account = Account.getAccountByNumber(accountNumber);

        return accountNumber;
    }

    public void createAccount(Float monthlyFee, Float fixedInterestRate, String accountType) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the account number: ");
        Integer accountNumber = scanner.nextInt();

        System.out.println("Enter the balance: ");
        Float balance = scanner.nextFloat();

        System.out.println("Enter the customer ID: ");
        Integer customerID = scanner.nextInt();

        new Account(accountNumber, balance, customerID, accountType, monthlyFee, fixedInterestRate);

        scanner.close();
    }

    public void oldCreateAccount(Integer accountNumber, Float balance, Integer customerID, String accountType, Float monthlyFee, Float fixedInterestRate) {
        new Account(accountNumber, balance, customerID, accountType, monthlyFee, fixedInterestRate);
    }
}
