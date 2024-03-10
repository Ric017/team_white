/*

Create a simple test program. The name of this test program is Bank.java, and it should make use of the above classes.

Bank.java should declare an ArrayList to hold all kinds of bank accounts.

The test program should utilize the system capabilities; The following are sample operations that demonstrate the systems capabilities:
  a. Create a Checking account for a commercial customer in Chicago’s branch and add it to the array list
  b. Create a separate method to display the customer information and account balance. Call the method on behalf of the customer you created in the previous step.
  c. Deposit a $100 into the account you created in ‘a’, and then display the new info.
  d. Create a Savings account for an individual customer in some branch with initial balance of $100 and interest rate of 10% and add it to the array list.
  e. Display the savings account information f. Make a $100 deposit to the savings account, calculate the interest, then display the information 

*/

import java.util.Date;
import java.util.ArrayList;

class Bank {

    /*
     * Operate the bank
     * 
     * @param String[] Any arguments
     * 
     * @return void
     */
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        Branch chicagoBranch = new Branch("Chicago");

        // Create a Checking account for a commercial customer in Chicago’s branch and add it to the array list
        CommercialCustomer commercialCustomer = new CommercialCustomer(
            "Acme Inc.",
            "123 Main St.",
            "555-123-4567",
            100,
            "John Doe",
            "987-654-3210"
        );

        Checking checking = new Checking(
            1,
            25.00,
            new Date(),
            chicagoBranch,
            "Standard",
            25.00
        );

        commercialCustomer.addAccount(checking);

        customers.add(commercialCustomer);

        // Create a separate method to display the customer information and account balance. Call the method on behalf of the customer you created in the previous step.
        displayCustomerInfoAndAccountBalance(customers.get(0));

        // Deposit a $100 into the account you created in ‘a’, and then display the new info.
        customers.get(0).getAccounts().get(0).makeDeposit(100.00);

        displayCustomerInfoAndAccountBalance(customers.get(0));

        Branch newYorkBranch = new Branch("New York");

        // Create a Savings account for an individual customer in some branch with initial balance of $100 and interest rate of 10% and add it to the array list.
        PersonalCustomer individualCustomer = new PersonalCustomer(
            "Jane Doe",
            "456 Elm St.",
            "555-987-4432",
            "555-987-2321",
            "555-987-4432"
        );

        Savings savings = new Savings(
            2,
            100.00,
            new Date(),
            newYorkBranch,
            0.10f
        );

        individualCustomer.addAccount(savings);

        customers.add(individualCustomer);

        // Make a $100 deposit to the savings account, calculate the interest, then display the information         
        savings.makeDeposit(100.00);

        // @note - We were not given a date or complete information about the "interest", so we're going to assume
        // (a) - Interest is annualized at 10%
        // (b) - The question intends to ask us to calculate the interest 1 year from today
        // (c) - We are calculating interest over the now FULL value of the Savings account ($100 initial deposit + $100 subsequent deposit)
        // (d) - Interest is compounded monthly (so month 1's interest will earn interest in month 2, and so on)
        savings.calculateInterest(12);

        // Display the savings account information
        displaySavingsAccountInformation(savings);

        // Implement other operations of your choice!
        System.out.println("\nJane Doe decided she wants a checking account, too. So we'll create one with $200 starting balance.");
        Checking checking2 = new Checking(
            3,
            200.00,
            new Date(),
            newYorkBranch,
"goldfish",
25.00
        );

        individualCustomer.addAccount(checking2);

        System.out.println("\nJane Doe wants to transfer $50.00 from savings to checking so she can pay for tutoring at IU.");
        moveMoneyBetweenAccounts(savings, checking2, 50.00);
        displayCustomerInfoAndAccountBalance(individualCustomer);
    }

    /*
     * Move money between two accounts.
     * 
     * @param Account the account from which to withdraw money
     * @param Account the account into which money should be deposited
     * 
     * @return void
     */
    public static void moveMoneyBetweenAccounts(Account fromAccount, Account toAccount, Double amountToMove) {
        // FYI - our bank allows overdrafts :)
        fromAccount.makeWithdrawal(amountToMove);
        toAccount.makeDeposit(amountToMove);
    }

    /*
     * Display customer information, including account balance details for each account
     * 
     * @param Customer the customer to display information for
     * 
     * @return void
     */
    public static void displayCustomerInfoAndAccountBalance(Customer customer) {
        System.out.println("\n\nDisplaying the customer information:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Phone: " + customer.getPhoneNumber());
        
        // Loop through the customer's accounts and display the account number and balance
        for (Account account : customer.getAccounts()) {
            System.out.println("\n\nDisplaying the account balance for account " + account.getAccountNumber() + ":");
            System.out.println("Balance: " + account.getBalance());
        }
    }

    /*
     * Displays savings account information specifically
     * 
     * @param Savings the savings account to display information for
     * 
     * @return void
     */
    public static void displaySavingsAccountInformation(Savings savings) {
        System.out.println("\n\nDisplaying the savings account information:");
        System.out.println("Account Number: " + savings.getAccountNumber());
        System.out.println("Branch: " + savings.getBranch());
        System.out.println("Balance: " + savings.getBalance());
        System.out.println("Interest Rate: " + savings.getInterestRate());
    }

/*
     * Displays checking account information specifically
     * 
     * @note - We recognize this isn't in use per the assignment's instructions,
     * but we wanted to have an equivalent method for displaySavingsAccountInformation().
     * 
     * @param Checking the checking account to display information for
     * 
     * @return void
     */
    public static void displayCheckingAccountInformation(Checking checking) {
        System.out.println("\n\nDisplaying the checking account information:");
        System.out.println("Account Number: " + checking.getAccountNumber());
        System.out.println("Branch: " + checking.getBranch());
        System.out.println("Balance: " + checking.getBalance());
        System.out.println("Minimum Balance: " + checking.getMinimumBalance());
        System.out.println("Check Style: " + checking.getCheckStyle());
    }
}