/**
 * Represents a generic bank account.
 */
public abstract class Account {
    private String accountNumber;
    private double balance;
    private Customer customer;

    /**
     * Constructs a new Account with the specified account number, initial balance, and customer.
     *
     * @param accountNumber The account number for this account.
     * @param balance       The initial balance of the account.
     * @param customer      The customer who owns this account.
     */
    public Account(String accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    /**
     * Gets the account number.
     *
     * @return A string representing the account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber A string containing the new account number.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the current balance of the account.
     *
     * @return A double representing the current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the current balance of the account.
     *
     * @param balance A double containing the new balance.
     */
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Gets the customer who owns this account.
     *
     * @return The customer object associated with this account.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer who owns this account.
     *
     * @param customer The customer object to be associated with this account.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount The amount to be deposited.
     */
    public abstract void deposit(double amount);

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount The amount to be withdrawn.
     */
    public abstract void withdraw(double amount);
}