class PersonalCustomer extends Customers {
    private String homePhone;
    private String workPhone;

    public PersonalCustomer(Integer id, String name, String address, String phoneNumber, String homePhone, String workPhone) {
        super(id, name, address, phoneNumber);
        this.homePhone = homePhone;
        this.workPhone = workPhone;
    }

    public String getHomePhone() {
        return this.homePhone;
    }

    public String getWorkPhone() {
        return this.workPhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
}