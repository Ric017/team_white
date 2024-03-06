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

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        // Create a Checking account for a commercial customer in Chicago’s branch and add it to the array list
        CommercialCustomer commercialCustomer = new CommercialCustomer(
            1,
            "Acme Inc.",
            "123 Main St.",
            "555-123-4567",
            100,
            "John Doe",
            "987-654-3210"
        );

        Checking checking = new Checking(
            1,
            100.00,
            new Date(),
            "Standard",
            25.00,
            "Chicago"
        );

        commercialCustomer.addAccount(checking);

        customers.add(commercialCustomer);

        // Create a separate method to display the customer information and account balance. Call the method on behalf of the customer you created in the previous step.
        displayCustomerInfoAndAccountBalance(customers.get(0));

        // Deposit a $100 into the account you created in ‘a’, and then display the new info.
        customers.get(0).getAccounts().get(0).makeDeposit(100.00);

        displayCustomerInfoAndAccountBalance(customers.get(0));

        // Create a Savings account for an individual customer in some branch with initial balance of $100 and interest rate of 10% and add it to the array list.
        PersonalCustomer individualCustomer = new PersonalCustomer(
            2,
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
            0.10f,
            "New York"
        );

        individualCustomer.addAccount(savings);

        customers.add(individualCustomer);

        // Display the savings account information
        displayCustomerInfoAndAccountBalance(customers.get(1));
    }

    public static void displayCustomerInfoAndAccountBalance(Customer customer) {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Phone: " + customer.getPhoneNumber());
        
        // Loop through the customer's accounts and display the account number and balance
        for (Account account : customer.getAccounts()) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Branch: " + account.getBranch());
            System.out.println("Balance: " + account.getBalance());
        }
    }
}