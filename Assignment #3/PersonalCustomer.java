class PersonalCustomer extends Customer {
    private String homePhone;
    private String workPhone;

    public PersonalCustomer(String name, String address, String phoneNumber, String homePhone, String workPhone) {
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        super(name, address, phoneNumber);
    }
}