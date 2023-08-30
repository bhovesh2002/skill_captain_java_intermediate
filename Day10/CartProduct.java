package Day10;
//Products that gets added to the cart. It extends the Product class and adds the quantity variable to it.

public class CartProduct extends Product{


    private int quantity;

    public CartProduct(String productId, String productName, double price, int quantity){
        super(productId, productName, price);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
