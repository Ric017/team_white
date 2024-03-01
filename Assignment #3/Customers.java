/*
 * Customers Class
 * All customers have a name, an address, and a phone number. In 
 * addition, a customer can have as many accounts as he needs
 * 
 */
class Customers {
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
    private Integer[] accounts; // @todo - is this really right?
    
    /*
     * Create a new customer
     * 
     * @param name the customer's name
     * @param address the customer's address
     * @param phoneNumber the customer's phone number
     * 
     * @return void
     */
    public Customers(Integer id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accounts = new Account[999]; // @todo - is there a way to not use a defined array length?
    }

    /*
     * Get the customer's ID
     *
     * @return this customer's ID
     */
    public Integer getId() {
        return this.id;
    }
    
    /*
     * Get the customer's name
     * 
     * @return the customer's name
     */
    public String getName() {
        return this.name;
    }
    
    /*
     * Get the customer's address
     * 
     * @return the customer's address
     */
    public String getAddress() {
        return this.address;
    }
    
    /*
     * Get the customer's phone number
     * 
     * @return the customer's phone number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    /*
     * Get the customer's list of accounts
     * 
     * @return the customer's list of accounts
     */
    public Account[] getAccounts() {
        return this.accounts;
    }

    /*
     * Set the customer's name
     *
     * @param name the customer's name
     * 
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Set the customer's address
     *
     * @param address the customer's address
     * 
     * @return void
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /*
     * Set the customer's phone number
     *
     * @param phoneNumber the customer's phone number
     * 
     * @return void
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*
     * Add an account to the customer's list of accounts
     *
     * @param account the account to add
     * 
     * @return void
     */
    public void addAccount(Integer account) {
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i] == null) {
                this.accounts[i] = account;
                break;
            }
        }
    }

    // @todo removeAccount()...
}