// Import date class
import java.util.Date;

public class Account {
    private Integer accountNumber;
    private Double balance;
    private Date dateOpened;
    private Branch branch;

    /*
     * Create a new account
     * 
     * @param accountNumber the account number
     * @param balance the initial balance
     * @param dateOpened the date the account was opened
     * 
     * @return void
     */
    public Account(Integer accountNumber, Double balance, Date dateOpened, Branch branch) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateOpened = new java.util.Date();
        this.branch = branch;
    }

    /*
     * Make a deposit to the account
     * 
     * @param amount the amount to deposit
     * 
     * @return void
     */
    public void makeDeposit(Double amount) {
        this.balance += amount;
    }

    /*
     * Make a withdrawal from the account
     * 
     * @param amount the amount to withdraw
     * 
     * @return void
     */
    public void makeWithdrawal(Double amount) {
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
    public Double getBalance() {
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
     * Get the branch
     * 
     * @return the branch
     */
    public Branch getBranch() {
        return this.branch;
    }

    /*
     * Set the balance
     * 
     * @param balance the new balance
     * 
     * @return void
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /*
     * Set the branch
     * 
     * @param branch the new branch
     * 
     * @return void
     */
    public void setBranch(Branch branch) {
        this.branch = branch;
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