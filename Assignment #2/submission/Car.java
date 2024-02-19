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
    private double price;

    /*
     * Default constructor
     * 
     * @return void
     */
    public Car() {
        this ("", "", 0, 0.0);
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
    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
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
     * Get the price of the car
     * @return double
     */
    public double getPrice() {
        return this.price;
    }

    /*
     * Set the make of the car
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /*
     * Format the car's information as a string
     * 
     * @return String
     */
    public String toString() {
        return "Year: " + this.year + "\nMake: " + this.make + "\nModel: " + this.model + "\nPrice: $" + this.price;
    }
}
