package Day10;

//Implements functionalities like find/add/remove/change quantity and store the products that get added to the cart.

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CartProductRepository {

    private Map<String, CartProduct> cartProductMap;
    private static int cartProductCount = 0;

    public CartProductRepository(){
        cartProductMap = new HashMap<>();
    }

    public void addProductToCart(CartProduct cartProduct){
        cartProductMap.put(cartProduct.getProductId(), cartProduct);
    }

    public void removeProductFromCart(String cartProductId){
            cartProductMap.remove(cartProductId);
    }

    public void changeQuantity(String cartProductId, int newQuantity){
        CartProduct cartProduct = cartProductMap.get(cartProductId);
        cartProduct.setQuantity(newQuantity);
    }

    public CartProduct findProductInCart(String cartProductId){
        CartProduct cartProduct = cartProductMap.get(cartProductId);
        return cartProduct;
    }



    public Map<String, CartProduct> getCartProductMap() {
        return cartProductMap;
    }

    public static int getCartProductCount() {
        return cartProductCount;
    }
}
