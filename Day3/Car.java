package Day3;

public class Car extends Vehicle{
    private int numOfSeats;

    public Car(String brand, String model, int year, double rentalPrice, int numOfSeats) {
        super(brand, model, year, rentalPrice);
        this.numOfSeats = numOfSeats;
    }

    public int getNumOfSeats(){
        return numOfSeats;
    }
}
