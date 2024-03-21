/**
 * Represents a regular account with fixed interest and a monthly maintenance fee.
 */
public class Regular extends Account {
    private static final double interestRate = 0.06; // 6% interest rate
    private static final double maintenanceFee = 10.0;

    /**
     * Constructs a new Regular account with the specified details.
     *
     * @param accountNumber The account number for this regular account.
     * @param balance       The initial balance of the account.
     * @param customer      The customer who owns this account.
     */
    public Regular(int accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    /**
     * Deposits the specified amount into the account. Interest is also applied.
     *
     * @param amount The amount to be deposited.
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
        }
    }

    /**
     * Withdraws the specified amount from the account if sufficient balance is available,
     * considering the maintenance fee.
     *
     * @param amount The amount to be withdrawn.
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() >= (amount + maintenanceFee)) {
            setBalance(getBalance() - amount);
        }
    }

    /**
     * Applies the fixed interest rate to the account balance.
     */
    private void applyInterest() {
        setBalance(getBalance() + (getBalance() * interestRate));
    }

    /**
     * Charges the maintenance fee on the account.
     */
    private void chargeMaintenanceFee() {
        setBalance(getBalance() - maintenanceFee);
    }

    /**
     * Returns a string representation of the regular account.
     *
     * @return A string containing the account's details.
     */
    @Override
    public String toString() {
        return "Regular{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", customer=" + getCustomer() +
                '}';
    }

    /**
     * Modifies account balances at the end of the month by applying interest and maintenance fees.
     */
    @Override
    public void applyEndOfMonth() {
        applyInterest();
        chargeMaintenanceFee();
    }
}
