package Day4;

public class Car extends Vehicle{
    private int numDoors;
    private String fuelType;

    public Car(String maker, String model, int year, int price, int numDoors, String fuelType) {
        super(maker, model, year, price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    public double calMileage(){
        return 0.0;
    }

    @Override
    public void displayDetails(){
        System.out.println("Maker: " + maker);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
        System.out.println("Number of Doors: " + numDoors);
        System.out.println("Fuel Type: " + fuelType);
    }

    public int getNumDoors() {
        return numDoors;
    }

    public String getFuelType() {
        return fuelType;
    }
}
