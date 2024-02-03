import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarOwner {
    private String name;
    private String address;
    private ArrayList<Car> cars;

    /*
     * Default constructor
     * 
     * @return void
     */
    public CarOwner() {
        this("", "", new ArrayList<Car>());
    }

    /*
     * Constructor with parameters
     * @param String name
     * @param String address
     * @param ArrayList<Car> cars
     * 
     * @return void
     */
    public CarOwner(String name, String address, ArrayList<Car> cars) {
        this.name = name;
        this.address = address;
        this.cars = cars;
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
     * Get the list of cars owned by the owner
     * @return ArrayList<Car>
     */
    public ArrayList<Car> getCars() {
        return this.cars;
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
     * Add a car to the owner's list of cars
     * @param Car car
     */
    public void addCar(Car car) {
        this.cars.add(car);
    }

    /*
     * Remove a car from the owner's list of cars
     * @param Car car
     */
    public void removeCar(Car car) {
        this.cars.remove(car);
    }
}
