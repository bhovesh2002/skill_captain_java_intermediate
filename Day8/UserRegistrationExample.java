package Day8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistrationExample {

    public static boolean isValidEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        return pattern.matcher(email).matches();
    }

    public static void printMapValue(HashMap<Integer, User> map){
        System.out.println("funcioncalled");
        Iterator mapIterator = map.entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)mapIterator.next();
            User user = (User)(mapElement.getValue());
            System.out.println("Name: "+user.getName());
            System.out.println("Email: "+ user.getEmail());
            System.out.println("Address: "+ user.getAddress());
        }
    }


    public static final int ADD_USER = 1;
    public static final int GET_USER = 2;
    public static final int GET_ALL_USERS = 3;
    public static final int REMOVE_USER = 4;
    public static final int EXIT = 5;

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("-----Welcome to user registration program-----");

        UserRepository userRepository = new UserRepository();

        userRepository.addUser("Aditya", "aditya200@gmail.com", "Aditya@200","Raj Nagar");
        userRepository.addUser("Cheshta", "chestha430@gmail.com", "cheshta430", "Vikaspuri");
        userRepository.addUser("Divyansh", "Divyansh2@gmail.com", "Divyansh@2", "Janakpuri");
        userRepository.addUser("Himanshi", "Himanshi450@gmail.com", "Himamhsi@450", "Pitampura");

        System.out.println("Press 1 to add a new user");
        System.out.println("Press 2 to get a user through email");
        System.out.println("Press 3 to get all users");
        System.out.println("Press 4 to remove user through email");
        System.out.println("Press 5 to exit");

        int i = 0;

        while (i != EXIT){
            System.out.println("Please enter a choice: ");
            i = Sc.nextInt();
            Sc.nextLine();

            switch (i){
                case ADD_USER -> {
                    System.out.println("Please enter name: ");
                    String name = Sc.nextLine();
                    while (name.isEmpty()){
                        System.out.println("Name is a required field! Please enter again!");
                        name = Sc.nextLine();
                    }

                    System.out.println("Please enter email: ");
                    String email = Sc.nextLine();
                    while (!isValidEmail(email) || userRepository.isEmailTaken(email) || email.isEmpty()){
                        if(!isValidEmail(email)){
                            System.out.println("Email is not valid! Please try again!");
                            email = Sc.nextLine();
                        } else if (userRepository.isEmailTaken(email)) {
                            System.out.println("Email is already taken! Please try again!");
                            email = Sc.nextLine();
                        } else if (email.isEmpty()) {
                            System.out.println("Cannot leave email empty! Please try again!");
                            email = Sc.nextLine();
                        }
                    }

                    System.out.println("Please enter password: ");
                    String password = Sc.nextLine();
                    while (password.isEmpty()){
                        System.out.println("Password is a required field! Please enter again!");
                    }

                    System.out.println("please enter address: ");
                    String address = Sc.nextLine();
                    while (address.isEmpty()){
                        System.out.println("Address is a required field! Please try again!");
                        address = Sc.nextLine();
                    }
                    userRepository.addUser(name,email, password, address);
                    System.out.println("User added!");

                }

                case GET_USER -> {
                    System.out.println("Please enter email of the user you want to find: ");
                    String email = Sc.nextLine();
                    if (isValidEmail(email)){
                        User user = userRepository.getUser(email);
                        if (user !=null){
                            System.out.println("Name: " + user.getName());
                            System.out.println("Email: " + user.getEmail());
                            System.out.println("Address: " + user.getAddress());
                        }else {
                            System.out.println("No user found!");
                        }
                    }else {
                        System.out.println("Invalid email entered!");
                    }
                }

                case GET_ALL_USERS -> {
                    HashMap<Integer, User> allUsers = userRepository.getAllUsers();
                    System.out.println("Got all users");
                    printMapValue(allUsers);
                }

                case REMOVE_USER -> {
                    System.out.println("Enter email of the user you want to remove: ");
                    String email = Sc.nextLine();
                    if(isValidEmail(email)){
                        userRepository.removeUser(email);
                    }else {
                        System.out.println("Please enter a valid email!");
                    }
                }

                default -> {
                    System.out.println("Wrong number entered! Please try again!");
                }
            }
        }
    Sc.close();

    }

}
