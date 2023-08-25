package Day4;

public abstract class Vehicle {
    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    protected String maker;
    protected String model;
    protected int year;
    protected int price;

    public Vehicle(String maker, String model, int year, int price) {
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public abstract void displayDetails();
}
