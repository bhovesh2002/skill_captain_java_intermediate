package Day10;

//This class makes sure that main class doesn't deal with the data regarding the products.

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ProductService {
    ProductRepository productRepository;

    //when an instance of the class is created in the main function, a few demo items get added.
    public ProductService(){
        productRepository = new ProductRepository();
        Product product1 = new Product("Phone1", "Smartphone", 15000.0);
        productRepository.addProductToMenu(product1);
        Product product2 = new Product("Mixer1", "Mixer", 6000.0);
        productRepository.addProductToMenu(product2);
        Product product3 = new Product("Fan1", "Fan", 1000.0);
        productRepository.addProductToMenu(product3);
        Product product4 = new Product("Chair1", "Chair", 1500.0);
        productRepository.addProductToMenu(product4);
        Product product5 = new Product("Door1", "Door", 17000.0);
        productRepository.addProductToMenu(product5);
    }

    //to add product to the menu/catalogue. try and catch to check if the user enters the correct datatype
    public void addProduct(Scanner Sc){
        try{
            System.out.println("Enter ProductId: ");
            String productId = Sc.nextLine();
            System.out.println("Enter product's name: ");
            String productName = Sc.nextLine();
            System.out.println("Enter product's price: ");
            double price = Sc.nextInt();

            Product product = new Product(productId, productName, price);
            productRepository.addProductToMenu(product);
            System.out.println("Product Added!");

        }catch (InputMismatchException ime){
            System.out.println("You have entered incorrect type of data. Please try again!");
        }
    }

    //to remove the product from menu/catalogue
    public void removeProduct(Scanner Sc){
        System.out.println("Please enter the id of the product you want to remove: ");
        String productId = Sc.nextLine();
        if(productRepository.getProductMap().containsKey(productId)){
            productRepository.removeProductFromMenu(productId);
            System.out.println("Product Removed!");
        }else {
            System.out.println("No product with id " + productId + " exists!");
        }
    }

    //display all products using Iterator
    public void displayAllProducts(){
        Iterator<Map.Entry<String, Product>> mapIterator = productRepository.getProductMap().entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry<String, Product> entry = mapIterator.next();
            Product product = entry.getValue();
            printDetails(product);
        }
    }

    //to get a specific product. Created so that a product can be added to the cart
    public Product getProduct(Scanner Sc){
        System.out.println("Enter product id: ");
        String productId = Sc.nextLine();
        if(productRepository.getProductMap().containsKey(productId)){
            Product product = productRepository.getProductMap().get(productId);
            return product;
        }else{
            return null;
        }
    }

//To print details of a product
    public void printDetails(Product product){
        System.out.println("Product Id: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Product Price: " + product.getPrice());
        System.out.println();
    }
}
