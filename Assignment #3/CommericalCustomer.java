class CommercialCustomer extends Customer {
    private Integer creditRating;
    private String contactPerson;
    private String contactPersonPhoneNumber;

    public CommercialCustomer(String name, String address, String phoneNumber, Integer creditRating, String contactPerson, String contactPersonPhoneNumber) {
        this.creditRating = creditRating;
        this.contactPerson = contactPerson;
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
        super(name, address, phoneNumber);
    }
}