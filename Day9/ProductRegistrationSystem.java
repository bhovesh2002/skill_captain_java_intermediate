package Day9;

import java.util.*;

public class ProductRegistrationSystem {

    public static Product addProduct(){
        Scanner Sc = new Scanner(System.in);

        System.out.println("Enter product Id: ");
        String productId = Sc.nextLine();

        System.out.println("Enter product name: ");
        String productName = Sc.nextLine();

        System.out.println("Enter product description: ");
        String description = Sc.nextLine();

        System.out.println("Enter manufacturer: ");
        String manufacturer = Sc.nextLine();

        System.out.println("Enter warranty from now on in months: ");
        int months = Sc.nextInt();

        if(productId.isEmpty() || productName.isEmpty() || description.isEmpty() || manufacturer.isEmpty() || months == 0){
            System.out.println("Every field is required. Please try again!");
            Sc.close();
            return null;
        }else {
            Product product = new Product(productId, productName, description, manufacturer, months);
            Sc.close();
            return product;
        }

    }

    public static void displayAllProducts(Map<String, Product> productMap){
        Iterator<Map.Entry<String, Product>> mapIterator = productMap.entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry<String, Product> entry = mapIterator.next();
            Product product = entry.getValue();

            System.out.println("Product Id: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Manufacturer: " + product.getManufacturer());
            System.out.println("Warranty till: " + product.getWarrantyDate());
        }

    }

    public static void displayProduct(String productId, Map<String, Product> userMap){
        Product foundProduct = userMap.get(productId);
        if(foundProduct == null){
            System.out.println("No product found with id " + productId);
            return;
        }
        System.out.println("Product Id: " + foundProduct.getProductId());
        System.out.println("Product Name: " + foundProduct.getProductName());
        System.out.println("Description: " + foundProduct.getDescription());
        System.out.println("Manufacturer: " + foundProduct.getManufacturer());
        System.out.println("Warranty till: "+ foundProduct.getWarrantyDate());

    }

    public static void report(ProductRepository productRepository){
        System.out.println("Total Count of products: " + productRepository.getCount());
        Iterator<Map.Entry<String, Product>> mapIterator = productRepository.getProductMap().entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry<String, Product> entry = mapIterator.next();
            Product product = entry.getValue();

            String warrantyStatus = checkWarrantyStatus(product.getWarrantyDate());

            System.out.println("Product: " + product.getProductName());
            System.out.println("Warranty Status: " + warrantyStatus);
        }
    }

    public static void removeProduct(String productId, ProductRepository productRepository){
        productRepository.deleteProduct(productId);
    }

    public static String checkWarrantyStatus(Date warrantyDate){
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();

        if(warrantyDate.compareTo(currentDate) == 1){
            return "active";
        }else {
            return "expired";
        }
    }

}
