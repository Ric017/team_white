/**
 * Represents a checking account with transaction fees.
 */
public class Checking extends Account {
    private static final double TRANSACTION_FEE = 3.0;
    private static final int FREE_TRANSACTIONS = 2;
    private int transactionCount;

    /**
     * Constructs a new Checking account with the specified details.
     *
     * @param accountNumber The account number for this checking account.
     * @param balance       The initial balance of the account.
     * @param customer      The customer who owns this account.
     */
    public Checking(String accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
        this.transactionCount = 0;
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
     * Increments the transaction count and applies a transaction fee if the free limit is exceeded.
     */
    private void incrementTransactionCount() {
        transactionCount++;
        if (transactionCount > FREE_TRANSACTIONS) {
            setBalance(getBalance() - TRANSACTION_FEE);
        }
    }
}
