/*
 * Assignment 2, Exercise 2
 * 
 * @author Team White
 * @date 2024-02-03
 */
public class CarOwner {
    private String name;
    private String address;

    /*
     * Default constructor
     * 
     * @return void
     */
    public CarOwner() {
        this("", "");
    }

    /*
     * Constructor with parameters
     * @param String name
     * @param String address
     * @param ArrayList<Car> cars
     * 
     * @return void
     */
    public CarOwner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /*
     * Get the name of the owner
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /*
     * Get the address of the owner
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    /*
     * Set the name of the owner
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Set the address of the owner
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /*
     * Format the owner's information and list of cars as a string
     * 
     * @return String
     */
    public String toString() {
        return "Name: " + this.name + "\nAddress: " + this.address;
    }
}
