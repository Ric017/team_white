/**
 * Represents a checking account with transaction fees.
 */
public class Checking extends Account {
    private static final double transactionFee = 3.0;
    private static final int freeTransactions = 2;
    private int transactionCount;

    /**
     * Constructs a new Checking account with the specified details.
     *
     * @param accountNumber The account number for this checking account.
     * @param balance       The initial balance of the account.
     * @param customer      The customer who owns this account.
     */
    public Checking(int accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
        this.transactionCount = 0;
    }

    /**
     * Increments the transaction count for the account.
     */
    private void incrementTransactionCount() {
        transactionCount++;
    }

    /**
     * Deposits the specified amount into the account and applies a transaction fee if necessary.
     *
     * @param amount The amount to be deposited.
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            incrementTransactionCount();
        }
    }

    /**
     * Withdraws the specified amount from the account if the balance is sufficient,
     * considering the transaction fee if necessary.
     *
     * @param amount The amount to be withdrawn.
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() >= amount) {
            setBalance(getBalance() - amount);
            incrementTransactionCount();
        }
    }

    /**
     * Modifies account balances at the end of the month
     * by applying transaction fees as necessary.
     */
    @Override
    public void applyEndOfMonth() {
        if (transactionCount > freeTransactions) {
            setBalance(getBalance() - (transactionCount - freeTransactions) * transactionFee);
        }
        transactionCount = 0;
    }
}
