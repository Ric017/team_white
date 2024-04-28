package Phase2;

public abstract class Account {
    private int accountNumber;
    private double balance;
    private Customer customer;
    private Utils utils = new Utils();

    public Account(double balance, Customer customer) {
    	this.accountNumber = utils.getNextAccountNumber();
        this.balance = balance;
        this.customer = customer;
        System.out.println("Account created with account number: " + accountNumber);
    }

    public String toString() {
        return "Account #" + accountNumber + ": " + getClass().getSimpleName() + "\n" +// getClass().getSimpleName() returns the type of class, which gives us the account type
               "Balance: $" + String.format("%.2f", balance) + "\n" +
               "Customer: " + customer.toString();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void applyEndOfMonth();
}