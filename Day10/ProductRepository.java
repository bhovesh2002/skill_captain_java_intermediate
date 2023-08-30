package Day10;

//This class will create a map to store the different products and implement functionalities like add/remove/find directly on the map.

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Map<String, Product> productMap;
    private static int count;

    //initializes the map whenever an instance gets created
    public ProductRepository(){
        this.productMap = new HashMap<>();
    }

    //to add product the map
    public void addProductToMenu(Product product){
        productMap.put(product.getProductId(), product);
        count += 1;
    }

    //to remove product from the map
    public void removeProductFromMenu(String productId){
            productMap.remove(productId);
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public static int getCount() {
        return count;
    }


}
