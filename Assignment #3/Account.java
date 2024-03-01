// Import date class
import java.util.Date;

public class Account {
    private Integer accountNumber;
    private Float balance;
    private Date dateOpened;
    private String branch; // @todo - do we want the branch to be tracked as an attribute here? Or, should there be a separate class?

    /*
     * Create a new account
     * 
     * @param accountNumber the account number
     * @param balance the initial balance
     * @param dateOpened the date the account was opened
     * 
     * @return void
     */
    public Account(Integer accountNumber, Float balance, Date dateOpened) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateOpened = new java.util.Date();
    }

    /*
     * Make a deposit to the account
     * 
     * @param amount the amount to deposit
     * 
     * @return void
     */
    public void makeDeposit(Float amount) {
        this.balance += amount;
    }

    /*
     * Make a withdrawal from the account
     * 
     * @param amount the amount to withdraw
     * 
     * @return void
     */
    public void makeWithdrawal(Float amount) {
        this.balance -= amount;
    }

    /*
     * Get the account number
     * 
     * @return the account number
     */
    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    /*
     * Get the current balance
     * 
     * @return the current balance
     */
    public Float getBalance() {
        return this.balance;
    }

    /*
     * Get the date the account was opened
     * 
     * @return the date the account was opened
     */
    public Date getDateOpened() {
        return this.dateOpened;
    }

    /*
     * Set the balance
     * 
     * @param balance the new balance
     * 
     * @return void
     */
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    /*
     * Return a string representation of the account
     */
    public String toString() {
        String output = "Account Number: " + this.accountNumber + "\n";
        output += "Balance: " + this.balance + "\n";
        output += "Date Opened: " + this.dateOpened + "\n";

        return output;
    }
}