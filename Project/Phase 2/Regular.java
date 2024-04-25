/**
 * Represents a regular account with fixed interest and a monthly maintenance fee.
 */
public class Regular extends Account {
    private static final double interestRate = 0.06; // 6% interest rate
    private static final double maintenanceFee = 10.0;

    /**
     * Constructs a new Regular account with the specified details.
     *
     * @param balance       The initial balance of the account.
     * @param customer      The customer who owns this account.
     */
    public Regular(double balance, Customer customer) {
        super(balance, customer);
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount The amount to be deposited.
     */
    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    /**
     * Withdraws the specified amount from the account and tracks the transaction
     *
     * @param amount The amount to be deposited.
     */
    @Override
    public void withdraw(double amount) {
        if(amount > getBalance()) {
            amount = getBalance();
        }

        setBalance(getBalance() - amount);
    }

    /**
     * Applies the fixed interest rate to the account balance.
     */
    private void applyInterest() {
        setBalance(getBalance() + (getBalance() * (interestRate / 12)));
    }

    /**
     * Charges the maintenance fee on the account.
     */
    private void chargeMaintenanceFee() {
        setBalance(getBalance() - maintenanceFee);
    }

    /**
     * Modifies account balances at the end of the month by applying interest and maintenance fees.
     */
    @Override
    public void applyEndOfMonth() {
        // @note: Our bank charges maintenance fees first so that we can reduce our interest payout requirements (we are greedy)
        chargeMaintenanceFee();
        applyInterest();
    }
}
