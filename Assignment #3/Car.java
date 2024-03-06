/*
 * Assignment 2, Exercise 2
 * 
 * Grading notes:
 * It didn't feel appropriate to create setters for the make, model and year
 * as those attributes should be immutable and defined only at the time of creation.
 * 
 * @author Team White
 * @date 2024-02-03
 */
public class Car {
    private String make;
    private String model;
    private int year;
    private String vin;
    private CarOwner owner;

    /*
     * Default constructor
     * 
     * @return void
     */
    public Car() {
        this ("", "", 0, "", new CarOwner());
    }

    /*
     * Constructor with parameters
     * @param String make
     * @param String model
     * @param int year
     * @param double price
     * 
     * @return void
     */
    public Car(String make, String model, int year, String vin, CarOwner owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.owner = owner;
    }

    /*
     * Get the make of the car
     * @return String
     */
    public String getMake() {
        return this.make;
    }

    /*
     * Get the model of the car
     * @return String
     */
    public String getModel() {
        return this.model;
    }

    /*
     * Get the year of the car
     * @return int
     */
    public int getYear() {
        return this.year;
    }

    /*
     * Get the VIN of the car
     * @return String
     */
    public String getVin() {
        return this.vin;
    }

    /*
     * Get the owner of the car
     * @return CarOwner
     */
    public CarOwner getOwner() {
        return this.owner;
    }

    /*
     * Set the make of the car
     */
    public void setVIN(String vin) {
        this.vin = vin;
    }

    /*
     * Set the owner of the car
     * 
     * @param CarOwner owner
     * 
     * @return void
     */
    public void setOwner(CarOwner owner) {
        this.owner = owner;
    }

    /*
     * Format the car's information as a string
     * 
     * @return String
     */
    public String toString() {
        return "Year: " + this.year + "\nMake: " + this.make + "\nModel: " + this.model + "\nVIN: " + this.vin;
    }
}
