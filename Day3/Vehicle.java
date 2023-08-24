package Day3;

public class Vehicle {
    private String brandName;
    private String model;
    private int year;
    private double rentalPrice;

    public Vehicle(String brandName, String model, int year, double rentalPrice){
        this.rentalPrice = rentalPrice;
        this.brandName = brandName;
        this.model = model;
        this.year = year;
    }

    public void showVehicleInfo(){
        System.out.println("Brand Name: "+brandName);
        System.out.println("Model Number: "+model);
        System.out.println("Year: "+year);
        System.out.println("Rental Price: "+rentalPrice);

    }



}
