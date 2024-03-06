import java.util.Date;

public final class Checking extends Account {
    private String checkStyle;
    private Double minimumBalance;

    /*
     * Create a new checking account
     * 
     * @param accountNumber the account number
     * @param balance the initial balance
     * @param dateOpened the date the account was opened
     * @param checkStyle the style of checks that can be used with this account
     * @param minimumBalance the minimum balance required
     * @param branch the branch where the account was opened
     * 
     * @return void
     */
    public Checking(Integer accountNumber, Double balance, Date dateOpened, String checkStyle, Double minimumBalance, String branch) {
        super(accountNumber, balance, dateOpened, branch);
        this.checkStyle = checkStyle;
        this.minimumBalance = minimumBalance;
    }

    /*
     * Get the style of checks that can be used with this account
     * 
     * @param checkStyle the style of checks
     * 
     * @return void
     */
    public void setCheckStyle(String checkStyle) {
        this.checkStyle = checkStyle;
    }

    /*
     * Get the style of checks that can be used with this account
     * 
     * @return the style of checks
     */
    public String getCheckStyle() {
        return this.checkStyle;
    }

    /*
     * Set the minimum balance required
     * 
     * @param minimumBalance the minimum balance required
     * 
     * @return void
     */
    public void setMinimumBalance(Double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    /*
     * Get the minimum balance required
     * 
     * @return the minimum balance required
     */
    public Double getMinimumBalance() {
        return this.minimumBalance;
    }
}