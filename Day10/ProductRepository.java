package Day10;

//This class will create a map to store the different products and implement functionalities like add/remove/find.

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Map<String, Product> productMap;
    private static int count;

    public ProductRepository(){
        this.productMap = new HashMap<>();
    }

    public void addProductToMenu(Product product){
        productMap.put(product.getProductId(), product);
        count += 1;
    }

    public void removeProductFromMenu(String productId){
            productMap.remove(productId);
    }

    public Product findProductInMenu(String productId){
        Product product = productMap.get(productId);
        return product;
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public static int getCount() {
        return count;
    }


}
