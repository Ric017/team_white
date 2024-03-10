public class SportsCar extends Car {
    private Integer raceStats;

    /*
     * Default constructor
     * 
     * @return void
     */
    public SportsCar() {
        this("", "", 0, "", new CarOwner(), 0);
    }

    /*
     * Constructor with parameters
     * @param String make
     * @param String model
     * @param int year
     * @param String vin
     * @param CarOwner owner
     * @param int raceStats
     * 
     * @return void
     */
    public SportsCar(String make, String model, int year, String vin, CarOwner owner, int raceStats) {
        super(make, model, year, vin, owner);
        this.raceStats = raceStats;
    }

    /*
     * Get race stats of the car
     * 
     * @return int
     */
    public Integer getRaceStats() {
        return this.raceStats;
    }

    /*
     * Set race stats of the car
     * 
     * @param int raceStats
     * 
     * @return void
     */
    public void setRaceStats(int raceStats) {
        this.raceStats = raceStats;
    }

    /*
     * Format the car's information
     * 
     * @return String
     */
    public String toString() {
        return super.toString() + "\nRace Stats: " + this.raceStats;
    }
}