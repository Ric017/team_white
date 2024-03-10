import java.util.Date;

public final class Savings extends Account {
    private Float interestRate;

    /*
     * Create a new savings account
     * 
     * @param accountNumber the account number
     * @param balance the initial balance
     * @param dateOpened the date the account was opened
     * @param interestRate the interest rate
     * @param branch the branch where the account was opened
     * 
     * @return void
     */
    public Savings(Integer accountNumber, Double balance, Date dateOpened, Branch branch, Float interestRate) {
        super(accountNumber, balance, dateOpened, branch);
        this.interestRate = interestRate;
    }

    /*
     * Get the interest rate
     * 
     * @return the interest rate
     */
    public Float getInterestRate() {
        return this.interestRate;
    }

    /*
     * Set the interest rate
     * 
     * @param interestRate the interest rate
     * 
     * @return void
     */
    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }
    
    /*
     * Use this account's current balance to calculate the interest earned for 
     * a given future date. We'll assume that the interest is compounded monthly
     * 
     * @param int periods the number of compounding periods (months)
     * 
     * @return void
     */
    public void calculateInterest(int periods) {
        
        Double interestEarned = this.getBalance() * Math.pow((1 + (this.interestRate / 12)), periods) - this.getBalance();

        // Limit interestEarned to 2 decimal places
        interestEarned = Math.round(interestEarned * 100.0) / 100.0;
        System.out.println("\n\nBalance before interest: " + this.getBalance());
        System.out.println("Interest earned after " + periods + " months: " + interestEarned);
        System.out.println("Balance after interest: " + (this.getBalance() + interestEarned));
    }
}
