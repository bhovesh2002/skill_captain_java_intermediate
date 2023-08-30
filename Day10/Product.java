package Day10;
//I created sepearte class for the products that gets added to cart because in general a product doesn't have any need to have a quantity variable
//until it gets added to the cart

public class Product {

    private String productId;
    private String productName;
    private double price;

//    public Product(){}

    public Product(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

}
