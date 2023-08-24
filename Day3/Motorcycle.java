package Day3;

public class Motorcycle extends Vehicle{
    private int engineCap;

    public Motorcycle(String brand, String model, int year, double rentalPrice, int engineCap) {
        super(brand, model, year, rentalPrice);
        this.engineCap = engineCap;
    }

    public int getEngineCap(){
        return engineCap;
    }

    public static void main(String[] args) {
        Car car1 = new Car("Honda", "City", 2019, 2300, 4);
        Motorcycle bike = new Motorcycle("TVS", "Apache", 2020, 1000, 4500);

        car1.showVehicleInfo();
        System.out.println("Number of Seats: " + car1.getNumOfSeats());

        bike.showVehicleInfo();
        System.out.println("Engine Capacity: " + bike.engineCap);
    }

}
