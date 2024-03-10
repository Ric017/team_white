public class SedanCar extends Car {
    private int numDoors;
    private int trunkSize;

    /*
     * Default constructor
     * 
     * @return void
     */
    public SedanCar() {
        this("", "", 0, "", new CarOwner(), 0, 0);
    }

    /*
     * Constructor with parameters
     * @param String make
     * @param String model
     * @param int year
     * @param String vin
     * @param CarOwner owner
     * @param int numDoors
     * @param int trunkSize
     * 
     * @return void
     */
    public SedanCar(String make, String model, int year, String vin, CarOwner owner, int numDoors, int trunkSize) {
        super(make, model, year, vin, owner);
        this.numDoors = numDoors;
        this.trunkSize = trunkSize;
    }

    /*
     * Get the number of doors of the car
     * 
     * @return int
     */
    public int getNumDoors() {
        return this.numDoors;
    }

    /*
     * Set the number of doors of the car
     * 
     * @param int numDoors
     * 
     * @return void
     */
    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    /*
     * Get the trunk size of the car
     * 
     * @return int
     */
    public int getTrunkSize() {
        return this.trunkSize;
    }

    /*
     * Set the trunk size of the car
     * 
     * @param int trunkSize
     * 
     * @return void
     */
    public void setTrunkSize(int trunkSize) {
        this.trunkSize = trunkSize;
    }

    /*
     * Format the car's information
     * 
     * @return String
     */
    public String toString() {
        return super.toString() + "\nNumber of doors: " + this.numDoors + "\nTrunk size: " + this.trunkSize;
    }
}