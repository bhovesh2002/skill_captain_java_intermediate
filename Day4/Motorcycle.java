package Day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Motorcycle extends Vehicle{
    private Boolean hasSideCar;
    private int engineCap;

    public Motorcycle(String maker, String model, int year, int price, Boolean hasSideCar, int engineCap) {
        super(maker, model, year, price);
        this.hasSideCar = hasSideCar;
        this.engineCap = engineCap;
    }

    public int calSpeed(){
        return 200;
    }

    @Override
    public void displayDetails(){
        System.out.println("Maker: " + maker);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
        System.out.println("Side Car: " + hasSideCar);
        System.out.println("Engine Capacity: " + engineCap);
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("---Welcome to the Vehicle Inventory System---");
        System.out.println("Press 1 to create add new car");
        System.out.println("Press 2 to add a new Motorcycle");
        System.out.println("Press 3 to check Vehicle's Details");
        System.out.println("Press 4 to search for a specific vehicle");
        System.out.println("Press 5 to exit");

        int i = 0;
        int exit = 4;
        List<Vehicle> inventory = new ArrayList<>();
//        inventory.add(new Motorcycle("TVS", "Apache", 2020, 5000, false, 1000));
//        inventory.add(new Car("Tata", "Nano", 2020, 15000, 4, "petrol"));

        while (i != exit){
            System.out.println("Please choose a number: ");
            i = Sc.nextInt();
            Sc.nextLine();

            switch (i) {
                case 1 -> {
                    System.out.println("Please enter Brand Name: ");
                    String brandName = Sc.nextLine();
                    System.out.println("Please enter Model Number: ");
                    String model = Sc.nextLine();
                    System.out.println("Please enter year of manufacturing: ");
                    int year = Sc.nextInt();
                    System.out.println("Enter Price: ");
                    int price = Sc.nextInt();
                    System.out.println("Enter no. of doors: ");
                    int numDoors = Sc.nextInt();
                    Sc.nextLine();

                    System.out.println("Enter fuel type(petrol/diesel/electric): ");
                    String fuelType = Sc.nextLine();
                    while (!fuelType.equalsIgnoreCase("petrol") &&
                            !fuelType.equalsIgnoreCase("diesel") &&
                            !fuelType.equalsIgnoreCase("electric")) {
                        System.out.println("Wrong fuel type. Please try again: ");
                        fuelType = Sc.nextLine();
                    }


                    inventory.add(new Car(brandName, model, year, price, numDoors, fuelType.toLowerCase()));
                    System.out.println("New car has been added!");
                }

                case 2 -> {
                    System.out.println("Please enter Brand Name: ");
                    String brandName = Sc.nextLine();
                    System.out.println("Please enter Model Number: ");
                    String model = Sc.nextLine();
                    System.out.println("Please enter year of manufacturing: ");
                    int year = Sc.nextInt();
                    System.out.println("Enter Price: ");
                    int price = Sc.nextInt();

                    System.out.println("Does it have side car?(y/n): ");
                    char choice = Sc.next().toLowerCase().charAt(0);
                    boolean hasSideCar;
                    while (choice != 'y' && choice != 'n'){
                        System.out.println("Wrong char entered. Please try again: ");
                        choice = Sc.next().toLowerCase().charAt(0);
                    }
                    if (choice=='y'){
                        hasSideCar = true;
                    }else {
                        hasSideCar = false;
                    }

                    System.out.println("Enter Engine Capacity: ");
                    int engineCap = Sc.nextInt();

                    inventory.add(new Motorcycle(brandName, model, year, price, hasSideCar, engineCap));
                    System.out.println("New motorcycle has been added!");
                }

                case 3 -> {
                    for (Vehicle vehicle : inventory){
                        vehicle.displayDetails();
                    }
                }

                case 4 -> {
                    System.out.println("Enter the brand name of the vehicle: ");
                    String brandName = Sc.nextLine();
                    //How can I implement a search functionality that searches by taking just as many parameters as given by user? like if the user provides only the brandName
                    // then it should show every vehicle with the same brand name and if the user also provides a model number, now it should use both brand name and
                    // model number to search all the vehicles with the same name and models.
                    // I am having trouble thinking of how to apply that functionality.
                    //I think a similar approach can also be used to apply update vehicle section?
                }

                case 5 -> {
                    System.out.println("Exiting");
                }

                default -> {
                    System.out.println("Wrong number entered. Please try again!");
                }
            }
        }
    }



}
