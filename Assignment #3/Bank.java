/*

Create a simple test program. The name of this test program is Bank.java, it should make 
use of the above classes. Bank.java should declare an ArrayList to hold all kinds of bank 
accounts. The test program should utilize the system capabilities; The following are 
sample operations that demonstrate the systems capabilities: a. Create a Checking account for a commercial customer in Chicago’s branch and 
add it to the array list b. Create a separate method to display the customer information and account 
balance. Call the method on behalf of the customer you created in the previous 
step. c. Deposit a $100 into the account you created in ‘a’, and then display the new info. d. Create a Savings account for an individual customer in some branch with initial 
balance of $100 and interest rate of 10% and add it to the array list. e. Display the savings account information f. Make a $100 deposit to the savings account, calculate the interest, then display 
the information 

*/

import java.util.Date;

class Bank {
    // Our bank's policy is that the minimum balance is always $25.00
    private bankPolicyMinimumCheckingBalance = 25.00;

    public static void main() {
        ArrayList<Customers> customers = new ArrayList<Customers>();
        ArrayList<Account> accounts = new ArrayList<Account>();
        Checking checking = new Checking(123, 100.0, new Date(), "style", 50.0);

        System.out.println("Main menu");
        System.out.println("1: Create customer");
        System.out.println("2: Work with an existing customer");
        System.out.println("3: Exit");
        System.out.print("Enter a choice: ");
        int mainMenuSelection = input.nextInt();

        switch (mainMenuSelection) {
            case 1:
                break;
            case 2:
                System.out.println("Enter the customer ID:");
                int customerId = input.nextInt();

                Customers selectedCustomer = this.getCustomerById(customers, customerId);

                System.out.println("A: Create checking account");
                System.out.println("B: Create savings account");
                System.out.println("C: Work with an existing account");
                System.out.println("D: Exit");

                String customerMenuSelection = input.nextln();
                switch(customerMenuSelection) {
                    case "A":
                        break;
                    case "B":
                        this.createSavings(selectedCustomer);
                        break;
                    case "C":
                        System.out.println("Enter the account number:");
                        int accountNumber = input.nextInt();

                        Account selectedAccount = this.getAccountByNumber(accounts, accountNumber);

                        System.out.println("A: Display account details");
                        System.out.println("B: Deposit to the account");
                        System.out.println("C: Withdraw from the account");
                        System.out.println("E: Exit");
                        break;
                    case "D":
                        System.out.println("Thank you for using our app.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                break;
            case 3:
                System.out.println("Thank you for using our app.");
                break;
            default:
                System.out.println("Invalid choice");
        }

        if (choice == 3) {
            break;
        }
    }

    // Loop through all customers to find the customer with the given ID
    public static Customers getCustomerById(ArrayList<Customers>, Integer id) {

        // @todo - return Customer
    }

    // Loop through all accounts to find the account with the given account number
    public static Account getAccountByNumber(ArrayList<Accounts>, Integer accountNumber) {

        // @todo = return Account
    }

    public static Customers createCustomer() {

    }

    public static Checking createChecking(Customers customer) {
        System.out.println("Enter an account number:");
        int newCheckingAccountNumber = input.nextInt();

        System.out.println("Enter the starting balance:");
        Float newCheckingBalance = input.nextFloat();

        System.out.println("Enter the check style:");
        String newCheckingCheckStyle = input.nextln();

        Float newCheckingMinimumBalance = this.bankPolicyMinimumCheckingBalance;

        Customers.addAcount(newCheckingAccountNumber);

        return new Checking(newCheckingAccountNumber, newCheckingBalance, newCheckingCheckStyle, newCheckingMinimumBalance);
    }

    public static Savings createSavings(Customers customer) {
        System.out.println("Enter an account number:");
        int newSavingsAccountNumber = input.nextInt();

        System.out.println("Enter the starting balance:");
        Float newSavingsBalance = input.nextFloat();

        System.out.println("Enter the interest rate:");
        Float newSavingsInterestRate = input.nextFloat();

        Customers.addAcount(newSavingsAccountNumber);

        return new Savings(newSavingsAccountNumber, newSavingsBalance, newSavingsInterestRate);
    }
}