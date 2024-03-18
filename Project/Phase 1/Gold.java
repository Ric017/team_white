/**
 * Represents a gold account with fixed interest and special withdrawal features.
 */
public class Gold extends Account {
    private static final double INTEREST_RATE = 0.05; // 5% interest rate

    /**
     * Constructs a new Gold account with the specified details.
     *
     * @param accountNumber The account number for this gold account.
     * @param balance       The initial balance of the account.
     * @param customer      The customer who owns this account.
     */
    public Gold(String accountNumber, double balance, Customer customer) {
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
            applyInterest();
        }
    }

    /**
     * Withdraws the specified amount from the account, even if it exceeds the current balance.
     *
     * @param amount The amount to be withdrawn.
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            setBalance(getBalance() - amount); // Gold accounts allow overdrafts.
        }
    }

    /**
     * Applies the fixed interest rate to the account balance.
     */
    private void applyInterest() {
        setBalance(getBalance() + (getBalance() * INTEREST_RATE));
    }

    /**
     * Returns a string representation of the gold account.
     *
     * @return A string containing the account's details.
     */
    @Override
    public String toString() {
        return "Gold{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", customer=" + getCustomer() +
                '}';
    }
}
