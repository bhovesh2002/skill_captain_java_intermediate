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

    public static final  int ADD_CAR = 1;

    public static final int ADD_MOTORCYCLE = 2;
    public static final int CHECK_DETAILS = 3;
    public static final int SEARCH_VEHICLE = 4;
    public static final int EXIT = 5;

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("---Welcome to the Vehicle Inventory System---");
        System.out.println("Press 1 to create add new car");
        System.out.println("Press 2 to add a new Motorcycle");
        System.out.println("Press 3 to check Vehicle's Details");
        System.out.println("Press 4 to search for a specific vehicle");
        System.out.println("Press 5 to exit");

        int i = 0;
        List<Vehicle> inventory = new ArrayList<>();
        inventory.add(new Motorcycle("TVS", "Apache", 2020, 5000, false, 1000));
        inventory.add(new Car("Tata", "Nano", 2020, 15000, 4, "petrol"));
        inventory.add(new Car("Honda", "City", 2020, 16000, 4, "diesel"));
        inventory.add(new Car("Honda", "Amaze", 2019, 14000, 4, "electric"));
        inventory.add(new Motorcycle("TVS", "Apache", 2020, 5000, false, 1000));
        inventory.add(new Car("Tata", "Nano", 2020, 15000, 4, "petrol"));
        inventory.add(new Car("Honda", "City", 2020, 16000, 4, "diesel"));
        inventory.add(new Car("Honda", "Amaze", 2019, 14000, 4, "electric"));

        while (i != EXIT){
            System.out.println("Please choose a number: ");
            i = Sc.nextInt();
            Sc.nextLine();

            switch (i) {
                case ADD_CAR -> {
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

                case ADD_MOTORCYCLE -> {
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
                    hasSideCar = choice == 'y';

                    System.out.println("Enter Engine Capacity: ");
                    int engineCap = Sc.nextInt();

                    inventory.add(new Motorcycle(brandName, model, year, price, hasSideCar, engineCap));
                    System.out.println("New motorcycle has been added!");
                }

                case CHECK_DETAILS -> {
                    for (Vehicle vehicle : inventory){
                        vehicle.displayDetails();
                    }
                }


                case SEARCH_VEHICLE -> {
                    System.out.println("Enter the brand name of the vehicle(any if you don't know): ");
                    String brandName = Sc.nextLine();
                    System.out.println("Enter the model number of the vehicle(any if you don't know): ");
                    String model = Sc.nextLine();
                    System.out.println("Enter the lower price range of the vehicle(can't be negative): ");
                    int lowerPrice = Sc.nextInt();
                    if(lowerPrice < 0){
                        System.out.println("You've entered a negative number. Please enter again!");
                        lowerPrice = Sc.nextInt();
                    }
                    System.out.println("Enter the upper range(can't be negative): ");
                    int upperPrice = Sc.nextInt();
                    if(upperPrice < 0){
                        System.out.println("You've entered a negative number. Please enter again!");
                        upperPrice = Sc.nextInt();
                    }
                    System.out.println("Enter year of manufacturing(-1 if you don't know): ");
                    int year = Sc.nextInt();
                    if(year < 2000){
                        if(year != -1){
                            System.out.println("Wrong year entered. please try again!");
                            year = Sc.nextInt();
                        }
                    }

                    List<Vehicle> findVehicles = new ArrayList<>();

                    if(!brandName.equals("any")){
                        for (Vehicle vehicle : inventory){
                            if(vehicle.getMaker().equals(brandName)){
                                findVehicles.add(vehicle);
                            }
                        }
                        if(findVehicles.isEmpty()){
                            System.out.println("No vehicle with the brand name "+ brandName + " found!");
                            break;
                        }
                    }

                    if(!model.equals("any")){
                        if(brandName.equals("any")){
                            for (Vehicle vehicle : inventory){
                                if (vehicle.getModel().equals(model)){
                                    findVehicles.add(vehicle);
                                }
                            }
                            if(findVehicles.isEmpty()){
                                System.out.println("No vehicle with the model number "+ model +" found!");
                                break;
                            }
                        }else {
                            List<Integer> indexes = new ArrayList<>();
                            for (Vehicle vehicle : findVehicles){
                                if (!vehicle.getModel().equals(model)){
                                    indexes.add(vehicle.getUid());
                                }
                            }
                            if (!indexes.isEmpty()){
                                int j;
                                for (j=findVehicles.size()-1; j>=0; j--){
                                    Vehicle vehicle = findVehicles.get(j);
                                    for (int index : indexes){
                                        if (index== vehicle.getUid()){
                                            findVehicles.remove(vehicle);
                                        }
                                    }
                                }
                            }


                            if (findVehicles.isEmpty()){
                                System.out.println("No vehicle with the model number "+ model +" and brand name " + brandName + " exists!");
                                break;
                            }
                        }
                    }

                    if (brandName.equals("any") && model.equals("any")){
                        for (Vehicle vehicle : inventory){
                            if(vehicle.getPrice()>=lowerPrice && vehicle.getPrice()<=upperPrice){
                                findVehicles.add(vehicle);
                            }
                        }
                        if (findVehicles.isEmpty()){
                            System.out.println("No vehicle found in the specified price range!");
                            break;
                        }
                    }else {
                        List<Integer> indexes = new ArrayList<>();
                        for (Vehicle vehicle : findVehicles){
                            if(vehicle.getPrice() < lowerPrice || vehicle.getPrice() > upperPrice){
                                indexes.add(vehicle.getUid());
                            }
                        }

                        if (!indexes.isEmpty()){
                            int j;
                            for (j=findVehicles.size()-1; j>=0; j--){
                                Vehicle vehicle = findVehicles.get(j);
                                for (int index : indexes){
                                   if (index== vehicle.getUid()){
                                       findVehicles.remove(vehicle);
                                   }
                                }
                            }
                        }

                        if(findVehicles.isEmpty()){
                            System.out.println("No vehicle with the model number "+ model +" and brand name " + brandName + " and" +
                                    "within price range exists!");
                            break;
                        }
                    }

                    if (year != -1){
                        if (findVehicles.isEmpty()){
                            for (Vehicle vehicle : inventory){
                                if(vehicle.getYear() == year){
                                    findVehicles.add(vehicle);
                                }
                            }
                            if(findVehicles.isEmpty()){
                                System.out.println("No vehicle in the year " + year + " found!");
                                break;
                            }
                        }else {
                            List<Integer> indexes = new ArrayList<>();
                            for (Vehicle vehicle : findVehicles){
                                if (vehicle.getYear() != year){
                                    indexes.add(vehicle.getUid());
                                }
                            }
                            if (!indexes.isEmpty()){
                                int j;
                                for (j=findVehicles.size()-1; j>=0; j--){
                                    Vehicle vehicle = findVehicles.get(j);
                                    for (int index : indexes){
                                        if (index== vehicle.getUid()){
                                            findVehicles.remove(vehicle);
                                        }
                                    }
                                }
                            }
                            if ((findVehicles.isEmpty())){
                                System.out.println("No vehicle with the model number "+ model +" and brand name " + brandName + " and" +
                                        "within price range and of year " + year + " exists!");
                                break;
                            }
                        }
                    }


                    for (Vehicle vehicle : findVehicles){
                        vehicle.displayDetails();
                        System.out.println(vehicle.getUid());
                        System.out.println("---------");
                    }


                }

                case EXIT -> System.out.println("Exiting");

                default -> System.out.println("Wrong number entered. Please try again!");
            }
        }
    }





}
