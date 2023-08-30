package Day10;

//To make sure the main function doesnt deal with cart data. It also checks for validation and takes input from user to apply to the
//cart data.

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CartService {

    CartProductRepository cartProductRepository = new CartProductRepository();

    //The product is accepted by searching through productId given by the user in the getProduct method in the ProductService class.
    //This method makes the mission of whole class redundant(to make sure that main class doesn't deal with data, at least directly)
    public void addToCart(Scanner Sc, Product product){
        if(product == null){
            System.out.println("No product could be found to add it to cart.");
            return;
        }
        try{
            System.out.println("Enter the quantity of product: ");
            int quantity = Sc.nextInt();

            CartProduct cartProduct = new CartProduct(product.getProductId(), product.getProductName(), product.getPrice(), quantity);
            cartProductRepository.addProductToCart(cartProduct);
            System.out.println("Added product to the cart!");
        }catch (InputMismatchException ime){
            System.out.println("Wrong type of input entered!");
        }
    }

    //asks for the productid to remove, and then validates the productid and then takes an action.
    public void removeProductFromCart(Scanner Sc){
        System.out.println("Enter id of the product you want to remove from your cart: ");
        String productId = Sc.nextLine();
        Boolean validateId = idValidation(productId);

        if(validateId){
            cartProductRepository.removeProductFromCart(productId);
            System.out.println("Product removed from cart!");
        }
    }

    //asks for the productid and validates it later. Changes the quantity of the found product based on user's choice.
    public void updateQuantity(Scanner Sc){
        System.out.println("Enter the product id: ");
        String cartProductId = Sc.nextLine();
        Boolean validateId = idValidation(cartProductId);

        if(validateId){
            try {
                System.out.println("Enter the new quantity: ");
                int newQuantity = Sc.nextInt();
                cartProductRepository.changeQuantity(cartProductId, newQuantity);
                System.out.println("Quantity Updated!");
            }catch (InputMismatchException ime){
                System.out.println("Wrong type of input entered!");
            }
        }
    }

    //displays every item in cart using Iterator class
    public void displayCart(){
        Iterator<Map.Entry<String, CartProduct>> mapIterator = cartProductRepository.getCartProductMap().entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry<String, CartProduct> entry = mapIterator.next();
            CartProduct cartProduct = entry.getValue();
            printDetails(cartProduct);
        }
    }

    //just in case
    public void viewCartProduct(Scanner Sc){
        System.out.println("Enter id of product you want to find in your cart: ");
        String cartProductId = Sc.nextLine();
        Boolean validateId = idValidation(cartProductId);

        if(validateId){
            CartProduct cartProduct = cartProductRepository.findProductInCart(cartProductId);
            printDetails(cartProduct);
        }
    }

    //calculates the total amount, and then you can check out by entering the said amount(also clears the whole map).
    public void checkout(Scanner Sc){
        double totalAmount = 0;
        Iterator<Map.Entry<String, CartProduct>> mapIterator = cartProductRepository.getCartProductMap().entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry<String, CartProduct> entry = mapIterator.next();
            CartProduct cartProduct = entry.getValue();
            totalAmount = totalAmount + (cartProduct.getPrice()*cartProduct.getQuantity());
        }

        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Enter the total amount to checkout and remove all items from cart(-1 to go back): ");
        try{
            double confirm = Sc.nextDouble();
            while (confirm != totalAmount && confirm != -1){
                System.out.println("Wrong amount entered!");
                System.out.println("Try again: ");
                confirm = Sc.nextDouble();
            }
            if(confirm == totalAmount){
                cartProductRepository.getCartProductMap().clear();
            } else if (confirm == -1) {
                return;
            }
        }catch (InputMismatchException ime){
            System.out.println("Wrong input type entered!");
        }
    }


    //to print details of a product; used in above methods
    public void printDetails(CartProduct cartProduct){
        System.out.println("Product Id: " + cartProduct.getProductId());
        System.out.println("Name: " + cartProduct.getProductName());
        System.out.println("Price: " + cartProduct.getPrice());
        System.out.println("Quantity: " + cartProduct.getQuantity());
        System.out.println();
        System.out.println("Total Price: " + (cartProduct.getPrice() * cartProduct.getQuantity()) );
    }

    //checks if the string is empty and if a product exists with the specified id.
    public boolean idValidation(String cartProductId){
        if(!cartProductId.isEmpty()){
            if(cartProductRepository.getCartProductMap().containsKey(cartProductId)){
                return true;
            }else {
                System.out.println("No product with id " + cartProductId + " found!");
                return false;
            }
        }else{
            System.out.println("Id cannot be left empty!");
            return false;
        }

    }

}
