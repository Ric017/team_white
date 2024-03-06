public class Account {
    private Integer accountNumber;
    private Float balance;
    private Integer CustomerID;
    private String accountType;
    private Integer numMonthlyTransactions;
    private Float monthlyFee;
    private Float fixedInterestRate;

    /*
     * Create a new account
     * 
     * @param accountNumber the account's number
     * @param balance the account's balance
     * @param CustomerID the customer's ID
     * @param accountType the account's type (checking, regular, gold)
     * @param monthlyFee the account's monthly fee
     * @param fixedInterestRate the account's fixed interest rate
     * 
     * @return void
     */
    public Account(Integer accountNumber, Float balance, Integer CustomerID, String accountType, Float monthlyFee, Float fixedInterestRate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.CustomerID = CustomerID;
        this.accountType = accountType;
        this.numMonthlyTransactions = 0;
        this.monthlyFee = monthlyFee;
        this.fixedInterestRate = fixedInterestRate;
    }

    /*
     * Get an account by its number
     * 
     * @param accountNumber the account's number
     * 
     * @return the account
     */
    public static Account getAccountByNumber(Integer accountNumber) {

    }

    /*
     * Deposit money into the account
     * If the account is a checking account, the first two transactions are free.
     * If the account is a checking account, it charges a $3 fee for every transaction after the first two.
     * 
     * @param amount the amount to deposit
     * 
     * @return void
     */
    public void deposit(Float amount) {

        // Amount must be positive
        if (amount < 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }

        if (this.accountType.equals("checking")) {
            if (this.numMonthlyTransactions < 2) {
                this.balance += amount;
            }
            else {
                this.balance += amount - 3;
            }
        }
        else {
            this.balance += amount;
        }
        
        this.numMonthlyTransactions++;
    }

    /*
     * Withdraw money from the account
     * If the account is a checking account, the first two transactions are free.
     * If the account is a checking account, it charges a $3 fee for every transaction after the first two.
     * 
     * Overdrafts are only allowed for gold accounts.
     * 
     * If the account is not a gold account and the withdrawal amount is greater than the balance,
     * the withdrawal amount is reduced to the available balance.
     * 
     * @param amount the amount to withdraw
     * 
     * @return void
     */
    public void withdraw(Float amount) {

        // Amount must be positive
        if (amount < 0) {
            System.out.println("Withdrawal amount must be positive");
            return;
        }

        if (!this.accountType.equalsIgnoreCase("gold")) {
            if (this.balance - amount < 0) {
                amount = this.balance;
                System.out.println("Insufficient funds, widthdrawal was reduced to the available balance.");
            }
        }

        if (this.accountType.equals("checking")) {
            if (this.numMonthlyTransactions < 2) {
                this.balance -= amount;
            }
            else {
                this.balance -= amount + 3;
            }
        }
        else {
            this.balance -= amount;
        }
        
        this.numMonthlyTransactions++;
    }

    /*
     * Get the account's number
     * 
     * @return the account's number
     */
    public Integer getAccountNumber() {
        return accountNumber;
    }

    /*
     * Get the account's balance
     * 
     * @return the account's balance
     */
    public Float getBalance() {
        return balance;
    }

    /*
     * Get the customer's ID
     * 
     * @return the customer's ID
     */
    public Integer getCustomerID() {
        return CustomerID;
    }

    /*
     * Get the account's type
     * 
     * @return the account's type
     */
    public String getAccountType() {
        return accountType;
    }

    /*
     * Get the number of monthly transactions
     * 
     * @return the number of monthly transactions
     */
    public Integer getNumMonthlyTransactions() {
        return numMonthlyTransactions;
    }

    /*
     * Set the account's balance
     * 
     * @param balance the account's balance
     * 
     * @return void
     */
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    /*
     * Set the account's type
     * 
     * @param accountType the account's type
     * 
     * @return void
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /*
     * Set the number of monthly transactions
     * 
     * @param numMonthlyTransactions the number of monthly transactions
     * 
     * @return void
     */
    public void setNumMonthlyTransactions(Integer numMonthlyTransactions) {
        this.numMonthlyTransactions = numMonthlyTransactions;
    }

    /*
     * Get the account's summary
     * 
     * @return the account's summary
     */
    public String toString() {
        return "Account Number: " + this.accountNumber + "\n" +
               "Balance: " + this.balance + "\n" +
               "Customer ID: " + this.CustomerID + "\n" +
               "Account Type: " + this.accountType + "\n" +
               "Number of Monthly Transactions: " + this.numMonthlyTransactions + "\n" +
               "Monthly Fee: " + this.monthlyFee + "\n" +
               "Fixed Interest Rate: " + this.fixedInterestRate + "\n";
    }
}