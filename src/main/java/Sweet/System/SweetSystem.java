package Sweet.System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SweetSystem {
    private boolean registeredIn;
    private boolean UserValid;
    private String message;


    public ArrayList<User> Users = new ArrayList<User>();
    public ArrayList<Admin> Admins = new ArrayList<Admin>();
    public ArrayList<StoreOwner>storeOwners = new ArrayList<StoreOwner>();
    public ArrayList<RawSupplier>Suppliers = new ArrayList<RawSupplier>();

    public SweetSystem() {
        // here we will fill the ArrayList from a file with the valid users.
        User Zahi = new User ("User1","123","user1@example.com","Nablus"); // this is just for testing, and it should be reading from a file. for the inputs that are repeated, added/modified
        Users.add(Zahi);
        Admin Hadi = new Admin ("Admin","Admin");
        Admins.add(Hadi);
        StoreOwner Khaled = new StoreOwner("StoreOwner1","SO1","storeOwner1@example.com");
        storeOwners.add(Khaled);
        RawSupplier Ahmad = new RawSupplier("Supplier1","RMS1","supplier1@example.com");
        Suppliers.add(Ahmad);
        registeredIn = false;
        UserValid = false;
        Product product1 = new Product("Chocolate",10,5);
        product1.setSellingTimes(5);
        Khaled.products.add(product1);
    }


    public boolean isRegisteredIn() {
        return registeredIn;
    }

    public void setRegisteredIn(boolean registeredIn) {
        this.registeredIn = registeredIn;
    }

    public boolean isUserValid() {
        return UserValid;
    }

    public void setUserValid(boolean userValid) {
        UserValid = userValid;
    }

    public boolean isValidUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false; // username is null or empty
        }
        return !Character.isDigit(username.charAt(0));
        //to be contiued
    }
    public boolean isValidPassword(String password) {
        // Add your password validation logic here (e.g., minimum length)
        return password != null && password.length() >= 3;
    }
    public void registerUser(User user) {
        if (isUserValid()) {
            Users.add(user);
            setMessage("User registered successfully!");
        } else {
            setMessage("Invalid user details!");
        }
    }

    public boolean isUserRegistered(User user) {
        return Users.contains(user);
    }

    public boolean isAddedInSystem(userType type, String username){
        switch (type) {
            case USER:
                for (User user : Users) {
                    if (user.getUsername().equals(username)) {
                        return true;
                    }
                }
                break;
            case ADMIN:
                for (Admin admin : Admins) {
                    if (admin.getUsername().equals(username)) {
                        return true;
                    }
                }
                break;
            case STORE_OWNER:
                for (StoreOwner storeOwner : storeOwners) {
                    if (storeOwner.getUsername().equals(username)) {
                        return true;
                    }
                }
                break;
            case SUPPLIER:
                for (RawSupplier sp : Suppliers) {
                    if (sp.getUsername().equals(username)) {
                        return true;
                    }
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getAllUsers() {
        List<Object> allUsers = new ArrayList<>();
        allUsers.addAll(Users);
        allUsers.addAll(storeOwners);
        allUsers.addAll(Suppliers);
        return allUsers;
    }

    public HashMap<String,Integer> getUserStatisticsByCity() {
        HashMap<String,Integer> cityStatistics = new HashMap<>();
        String[] cities = {"Nablus", "Jenin", "Ramallah", "Jerusalem", "Jericho", "Tulkarem", "Hebron", "Qalqiliah", "Bethlehem", "Tubas"};
        for (String city : cities) {
            cityStatistics.put(city, 0);
        }
        for (User user : Users) {
            String userCity = user.getCity();
            if (cityStatistics.containsKey(userCity)) {
                cityStatistics.put(userCity, cityStatistics.get(userCity) + 1);
            } else {
                cityStatistics.put(userCity, 1);
            }
        }
        return cityStatistics;
    }


}
