package Day9;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    Map<String, Product> productMap;
    public static int count = 0;

    public ProductRepository(){
        productMap = new HashMap<>();
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public static int getCount() {
        return count;
    }

    public void saveProduct(Product product){
        productMap.put(product.getProductId(), product);
        System.out.println("Product saved!");
        count += 1;
    }

    public void deleteProduct(String productId){
        if (productMap.get(productId).equals(null)){
            System.out.println("Product doesn't exists!");
            return;
        }else {
            productMap.remove(productId);
            count -=1;
        }
    }

    public Product findProduct(String productId){
        return productMap.get(productId);
    }


}
