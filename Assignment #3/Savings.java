import java.util.Date;

public final class Savings extends Account {
    private Float interestRate;

    // @todo - getInterestRate()...

    // @todo - setInterestRate()...

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
    public Savings(Integer accountNumber, Double balance, Date dateOpened, Float interestRate, String branch) {
        super(accountNumber, balance, dateOpened, branch);
        this.interestRate = interestRate;
    }

    /*
     * Use this account's current balance to calculate the interest earned for 
     * a given future date. We'll assume that the interest is compounded monthly
     * 
     * @param futureDate the date for which we want to calculate the interest
     * 
     * @return void
     */
    public void calculateInterest(Date futureDate) {
        // Calculate the number of months between the current date and the future date
        long months = (futureDate.getTime() - this.getDateOpened().getTime()) / 1000 / 60 / 60 / 24 / 30;
        // Print the amount of interest that will be earned by that future date
        System.out.println("Interest earned by " + futureDate + ": " + (this.getBalance() * Math.pow(1 + this.interestRate / 12, months) - this.getBalance()));
    }
}
