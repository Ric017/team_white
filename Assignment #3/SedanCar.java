public class SedanCar extends Car {
    private int numDoors;
    private int trunkSize;

    public SedanCar() {
        this("", "", 0, "", new CarOwner(), 0, 0);
    }

    public SedanCar(String make, String model, int year, String vin, CarOwner owner, int numDoors, int trunkSize) {
        super(make, model, year, vin, owner);
        this.numDoors = numDoors;
        this.trunkSize = trunkSize;
    }

    public int getNumDoors() {
        return this.numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public int getTrunkSize() {
        return this.trunkSize;
    }

    public void setTrunkSize(int trunkSize) {
        this.trunkSize = trunkSize;
    }

    public String toString() {
        return super.toString() + "\nNumber of doors: " + this.numDoors + "\nTrunk size: " + this.trunkSize;
    }
}