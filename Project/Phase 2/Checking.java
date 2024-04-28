package Phase2;

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
     * @param balance       The initial balance of the account.
     * @param customer      The customer who owns this account.
     */
    public Checking(double balance, Customer customer) {
        super(balance, customer);
        this.transactionCount = 0;
    }

    /**
     * Increments the transaction count for the account.
     */
    private void incrementTransactionCount() {
        transactionCount++;
    }

    /**
     * Deposits the specified amount into the account and tracks the transaction
     * 
     *
     * @param amount The amount to be deposited.
     */
    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        incrementTransactionCount();
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
        incrementTransactionCount();
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
