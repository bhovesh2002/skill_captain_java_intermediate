package Day10;

// General Overview:
// Product/CartProduct classes to create respective objects

// ProductRepository/CartProductRepository classes to store products in the datastructures and implement different functionalities directly on them.

//CartService/ProductService classes are to validate input that gets passed and make sure main function doesn't deal with data directly

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final int ADD_CATALOGUE = 1;
    public static final int REMOVE_CATALOGUE = 2;
    public static final int DISPLAY_ALL = 3;
    public static final int ADD_ITEM_CART = 4;
    public static final int REMOVE_ITEM_CART = 5;
    public static final int UPDATE_QUANTITY = 6;
    public static final int DISPLAY_CART = 7;
    public static final int CHECKOUT = 8;
    public static final int EXIT = 9;


    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        ProductService productService = new ProductService();
        CartService cartService = new CartService();

        System.out.println("----Welcome to Cart System----");
        System.out.println();
        System.out.println("----Catalogue----");
        System.out.println("Enter 1 to add product to the catalogue");
        System.out.println("Enter 2 to remove product from the catalogue");
        System.out.println("Enter 3 to display all products in the catalogue");
        System.out.println("----Cart System----");
        System.out.println("Enter 4 to add item to cart");
        System.out.println("Enter 5 to remove item from cart");
        System.out.println("Enter 6 to update quantity of an item");
        System.out.println("Enter 7 to display all cart items");
        System.out.println("Enter 8 to checkout");
        System.out.println("Enter 9 to exit");

        int i = 0;

        while (i != EXIT){
            try{
                System.out.println("Enter a choice: ");
                i = Sc.nextInt();
                Sc.nextLine();

                switch (i) {
                    case ADD_CATALOGUE -> {
                        productService.addProduct(Sc);
                    }

                    case REMOVE_CATALOGUE -> {
                        productService.removeProduct(Sc);
                    }

                    case DISPLAY_ALL -> {
                        productService.displayAllProducts();
                    }

                    //I was suggested to make sure that main function doesn't deal with data. While I did try my best to nto do that, this
                    // is the only instance where the data enters the main function.
                    //I think it ended up like this because I created 2 separate product(Product and CartProduct) classes.
                    // Is there any way I can change this functionality without changing the structure of this whole project?
                    // Or is changing the structure only way?
                    case ADD_ITEM_CART -> {
                        Product product = productService.getProduct(Sc);
                        cartService.addToCart(Sc, product);
                    }

                    case REMOVE_ITEM_CART -> {
                        cartService.removeProductFromCart(Sc);
                    }

                    case UPDATE_QUANTITY -> {
                        cartService.updateQuantity(Sc);
                    }

                    case DISPLAY_CART -> {
                        cartService.displayCart();
                    }

                    case CHECKOUT -> {
                        cartService.checkout(Sc);
                    }

                    default -> {
                        System.out.println("Wrong choice entered");
                    }

                }

            }catch (InputMismatchException ime){
                System.out.println("Wrong input type entered");
            }
        }

        Sc.close();

    }

}
