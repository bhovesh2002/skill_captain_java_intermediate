package Day10;

//Implements functionalities like find/add/remove/change quantity and store the products that get added to the cart.

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CartProductRepository {

    private Map<String, CartProduct> cartProductMap;
    private static int cartProductCount = 0;

    //creates a map to store cart products
    public CartProductRepository(){
        cartProductMap = new HashMap<>();
    }

    //adds product to the map
    public void addProductToCart(CartProduct cartProduct){
        cartProductMap.put(cartProduct.getProductId(), cartProduct);
    }

    //removes product from the cart
    public void removeProductFromCart(String cartProductId){
            cartProductMap.remove(cartProductId);
    }

    //changes quantity and accepts product id and the new quantity
    public void changeQuantity(String cartProductId, int newQuantity){
        CartProduct cartProduct = cartProductMap.get(cartProductId);
        cartProduct.setQuantity(newQuantity);
    }

    //to find product
    public CartProduct findProductInCart(String cartProductId){
        CartProduct cartProduct = cartProductMap.get(cartProductId);
        return cartProduct;
    }


    //when the program needs to check if an item exists based on the id provided, this function comes handy
    public Map<String, CartProduct> getCartProductMap() {
        return cartProductMap;
    }

    //Just in case
    public static int getCartProductCount() {
        return cartProductCount;
    }
}
