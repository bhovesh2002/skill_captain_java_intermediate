package Day9;

import java.util.Scanner;

import static Day9.ProductRegistrationSystem.*;

public class Main {

    public static final int ADD_PRODUCT = 1;
    public static final int DISPLAY_ALL_PRODUCTS = 2;
    public static final int DISPLAY_PRODUCT = 3;
    public static final int GENERATE_REPORT = 4;
    public static final int REMOVE_PRODUCT = 5;
    public static final int EXIT = 6;

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();

        System.out.println("---Welcome to Product Registration System---");
        System.out.println("Press 1 to add a product");
        System.out.println("Press 2 to display all products");
        System.out.println("Press 3 to display a specific product");
        System.out.println("Press 4 to generate a report");
        System.out.println("Press 5 to remove a product");
        System.out.println("Press 6 to exit");

        Product product1 = new Product("Phone1", "Phone", "Smart Phone", "Samsung", 12);
        productRepository.saveProduct(product1);
        Product product2 = new Product("Mixer1", "Mixer", "Mixes everything", "Bajaj", 18);
        productRepository.saveProduct(product2);
        Product product3 = new Product("Fan1", "Fan", "Fans everywhere", "Havells", -8);
        productRepository.saveProduct(product3);
        Product product4 = new Product("Tubelight1", "Tube-light", "Lights everything", "Philips", 6);
        productRepository.saveProduct(product4);
        Product product5 = new Product("TV1", "TV", "watch things on it", "Sony", 20);
        productRepository.saveProduct(product5);

        int i = 0;
        while (i != EXIT){
            System.out.println("Please enter a choice");
            i = Sc.nextInt();
            Sc.nextLine();

            switch (i){
                case ADD_PRODUCT -> {
                    Product product = addProduct();
                    if(product == null){
                        break;
                    }else {
                        productRepository.saveProduct(product);
                    }
                }

                case DISPLAY_ALL_PRODUCTS -> {
                    displayAllProducts(productRepository.getProductMap());
                }

                case DISPLAY_PRODUCT -> {
                    System.out.println("Enter product Id of the product you want to display: ");
                    String productId = Sc.nextLine();
                    if(!productId.isEmpty()){
                        displayProduct(productId, productRepository.getProductMap());
                    }else {
                        System.out.println("Product Id cannot be left empty. PLease try again!");
                        break;
                    }
                }

                case GENERATE_REPORT -> {
                    report(productRepository);
                }

                case REMOVE_PRODUCT -> {
                    System.out.println("Enter id of the product you want to remove: ");
                    String productId = Sc.nextLine();
                    removeProduct(productId, productRepository);
                }

                default -> {
                    System.out.println("Wrong number entered!");
                }
            }
        }

    }
}
