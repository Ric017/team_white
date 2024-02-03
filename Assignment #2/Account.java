/*
 * 9.7 The Account class
 * 
 * @author Team White
 * @date 2024-02-03
 */
class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private java.util.Date dateCreated;

    /*
     * No-arg constructor that creates a default account
     */
    public Account() {
        this(0, 0.0d, 0.0d);
    }

    /*
     * Constructor that creates an account with the specified id and initial balance
     */
    public Account(int newId, double initialBalance, double initialInterestRate) {
        this.id = newId;
        this.balance = initialBalance;
        this.annualInterestRate = initialInterestRate;
        this.dateCreated = new java.util.Date();
    }

    /*
     * Accessor for id
     */
    public int getId() {
        return this.id;
    }

    /*
     * Accessor for balance
     */
    public double getBalance() {
        return this.balance;
    }

    /*
     * Accessor for annualInterestRate
     */
    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    /*
     * Mutator for id
     */
    public void setId(int newId) {
        this.id = newId;
    }

    /*
     * Mutator for balance
     */
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    /*
     * Mutator for annualInterestRate
     */
    public void setAnnualInterestRate(double newAnnualInterestRate) {
        this.annualInterestRate = newAnnualInterestRate;
    }

    /*
     * Accessor for dateCreated
     */
    public java.util.Date getDateCreated() {
        return this.dateCreated;
    }

    /*
     * Calculate the monthly interest rate
     */
    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    /*
     * Calculate the monthly interest amount
     */
    public double getMonthlyInterest() {
        return (this.balance * (this.getMonthlyInterestRate() / 100));
    }

    /*
     * Withdraw a specified amount from the account
     */
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    /*
     * Deposit a specified amount to the account
     */
    public void deposit(double amount) {
        this.balance += amount;
    }
}