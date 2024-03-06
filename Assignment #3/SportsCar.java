public class SportsCar extends Car {
    private Integer raceStats;

    public SportsCar() {
        this("", "", 0, "", new CarOwner(), 0);
    }

    public SportsCar(String make, String model, int year, String vin, CarOwner owner, int raceStats) {
        super(make, model, year, vin, owner);
        this.raceStats = raceStats;
    }

    public Integer getRaceStats() {
        return this.raceStats;
    }

    public void setRaceStats(Integer raceStats) {
        this.raceStats = raceStats;
    }

    public String toString() {
        return super.toString() + "\nRace Stats: " + this.raceStats;
    }
}