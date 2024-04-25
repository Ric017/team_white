/**
 * Represents a gold account with fixed interest and special withdrawal features.
 */
public class Gold extends Account {
    // @note: With respect to the interest rate, we assume this is the ANNUAL interest rate
    private static final double interestRate = 0.05; // 5% interest rate

    /**
     * Constructs a new Gold account with the specified details.
     *
     * @param balance       The initial balance of the account.
     * @param customer      The customer who owns this account.
     */
    public Gold(double balance, Customer customer) {
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
        setBalance(getBalance() - amount);
    }

    /**
     * Applies the fixed interest rate to the account balance.
     */
    private void applyInterest() {
        setBalance(getBalance() + (getBalance() * (interestRate / 12)));
    }

    /**
     * Modifies account balances at the end of the month by applying interest.
     */
    @Override
    public void applyEndOfMonth() {
        applyInterest();
    }
}
