class PersonalCustomer extends Customer {
    private String homePhone;
    private String workPhone;

    /*
     * Create a new personal customer
     * 
     * @param int id the customer's id
     * @param String name the customer's name
     * @param String address the customer's address
     * @param String phoneNumber the customer's phone number
     * @param String homePhone the customer's home phone number
     * @param String workPhone the customer's work phone number
     * 
     * @return void
     */
    public PersonalCustomer(String name, String address, String phoneNumber, String homePhone, String workPhone) {
        super(name, address, phoneNumber);
        this.homePhone = homePhone;
        this.workPhone = workPhone;
    }

    /*
     * Get the home phone number
     * 
     * @return String the home phone number
     */
    public String getHomePhone() {
        return this.homePhone;
    }

    /*
     * Get the work phone number
     * 
     * @return String the work phone number
     */
    public String getWorkPhone() {
        return this.workPhone;
    }

    /*
     * Set the home phone number
     * 
     * @param homePhone the home phone number
     * 
     * @return void
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /*
     * Set the work phone number
     * 
     * @param workPhone the work phone number
     * 
     * @return void
     */
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
}