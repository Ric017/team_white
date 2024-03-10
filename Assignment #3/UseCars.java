/*
 * Create a test program named UseCars that should make use of the above classes and displays some results.
 * In this test application do the following:
 *   a. Create an ArrayList that stores references of any type of cars
 *   b. Create a method that request information about a new car owner. The method will collect this information
 *      and returns a reference of a newly instantiated owner.
 *   c. Create another method that requests information about a sport car. The method will instantiate a sports
 *      car and adds it to the array list. Create another method that does exactly the same but for sedan cars.
 *   d. Create a method that would find and display the information about a given car based on a provided VIN number.
 *   e. In your main method or any method that acts as a main method. Call the methods that you just created.
 *      In other words, create a few car owners, create a few cars of each kind. Search for a particular car and
 *      display its information, and finally display all the cars that are currently stored in the list
 */

import java.util.ArrayList;
import java.util.Scanner;
public class UseCars {

    /*
     * Runs the program
     * 
     * @param String[] any arguments
     * 
     * @return void
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Car> cars = new ArrayList<Car>();

        CarOwner owner1 = createCarOwner();

        SportsCar sportsCar1 = createSportsCar(owner1);
        cars.add(sportsCar1);

        CarOwner owner2 = createCarOwner();
        
        SedanCar sedanCar1 = createSedanCar(owner2);
        cars.add(sedanCar1);
        
        SportsCar sportsCar2 = createSportsCar(owner2);
        cars.add(sportsCar2);

        CarOwner owner3 = createCarOwner();

        SedanCar sedanCar2 = createSedanCar(owner3);
        cars.add(sedanCar2);

        System.out.println("\nEnter a VIN to search for:\n");
        String searchVin = input.nextLine();

        displayCarInfo(cars, searchVin);

        System.out.println("\nDisplay information for all cars.\n");
        System.out.println(cars);

        input.close();
    }

    /*
     * Finds a car in a list of cars, based on vin, and displays that car's details
     * 
     * @return void
     */
    public static void displayCarInfo(ArrayList<Car> cars, String vin) {
        boolean found = false;
        for (Car car : cars) {
            if (car.getVin().equals(vin)) {
                found = true;
                System.out.println(car);
            }
        }

        if(!found) {
            System.out.println("Car not found");
        }
    }

    /*
     * Creates a car owner interactively
     * 
     * @return CarOwner
     */
    public static CarOwner createCarOwner() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the car owner: ");
        String name = input.nextLine();

        System.out.println("Enter the address of the car owner: ");
        String address = input.nextLine();

        return new CarOwner(name, address);
    }

    /*
     * Creates a sports car interactively
     * 
     * @param CarOwner The owner of the sports car being created
     * 
     * @return SportsCar
     */
    public static SportsCar createSportsCar(CarOwner owner) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the make of the car: ");
        String make = input.nextLine();

        System.out.println("Enter the model of the car: ");
        String model = input.nextLine();

        System.out.println("Enter the year of the car: ");
        int year = input.nextInt();

        input.nextLine();

        System.out.println("Enter the VIN of the car: ");
        String vin = input.nextLine();

        System.out.println("Enter the race stats of the car: ");
        int raceStats = input.nextInt();

        return new SportsCar(make, model, year, vin, owner, raceStats);
    }

    /*
     * Creates a sedan interactively
     * 
     * @param CarOwner The owner of the sedan being created
     * 
     * @return SedanCar
     */
    public static SedanCar createSedanCar(CarOwner owner) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the make of the car: ");
        String make = input.nextLine();

        System.out.println("Enter the model of the car: ");
        String model = input.nextLine();

        System.out.println("Enter the year of the car: ");
        int year = input.nextInt();

        input.nextLine();

        System.out.println("Enter the VIN of the car: ");
        String vin = input.nextLine();

        System.out.println("Enter the number of doors of the car: ");
        int numDoors = input.nextInt();

        System.out.println("Enter the trunk size of the car: ");
        int trunkSize = input.nextInt();

        return new SedanCar(make, model, year, vin, owner, numDoors, trunkSize);
    }
}