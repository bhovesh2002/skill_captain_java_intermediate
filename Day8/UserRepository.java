package Day8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserRepository {
    private HashMap<Integer, User> userList;

    public UserRepository() {
        this.userList = new HashMap<>();
    }

    public void addUser(String name, String email, String password, String address){
        User user = new User(name, email, password, address);

        userList.put(user.getUid(), user);
    }

    public User getUser(String email){
        Iterator userListIterator = userList.entrySet().iterator();
        User foundUser;

        while (userListIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)userListIterator.next();
            User user = ((User)mapElement.getValue());

            if(user.getEmail().equals(email)){
                foundUser = user;
                return foundUser;
            }

        }
        return null;
    }

    public HashMap<Integer, User> getAllUsers(){
        System.out.println("Getting all users");
        return userList;
    }

    public boolean isEmailTaken(String email){
        Iterator userListIterator = userList.entrySet().iterator();
        while (userListIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)userListIterator.next();
            User user = ((User)mapElement.getValue());
            if(user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public void removeUser(String email){
        Iterator userListIterator = userList.entrySet().iterator();
        while (userListIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)userListIterator.next();
            User user = ((User)mapElement.getValue());
            if(user.getEmail().equals(email)){
                userList.remove(mapElement.getKey());
                System.out.println("User removed!");
                return;
            }
        }
        System.out.println("No user with that email exists!");
    }

}
