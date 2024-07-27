package Sweet.System;

import java.util.ArrayList;

public class SweetSystem {
    private boolean registeredIn;
    private boolean userLoggedIn;
    private boolean adminLoggedIn;
    private boolean storeOwnerExist;
    private boolean supplierExist;
    private boolean UserValid;
    private String message;


    public ArrayList<User> Users = new ArrayList<User>();
    public ArrayList<Admin> Admins = new ArrayList<Admin>();
    public ArrayList<StoreOwner>storeOwners = new ArrayList<StoreOwner>();
    public ArrayList<RawSupplier>Suppliers = new ArrayList<RawSupplier>();

    public SweetSystem() {
        // here we will fill the ArrayList from a file with the valid users.
        User Zahi = new User ("User1","123"); // this is just for testing, and it should be reading from a file. for the inputs that are repeated, added/modified
        Users.add(Zahi);
        Admin Hadi = new Admin ("Admin","Admin");
        Admins.add(Hadi);
    }

    public boolean isUserLoggedIn() {
        return userLoggedIn;
    }


    public void setUserLoggedIn(boolean loggedIn) {
        this.userLoggedIn = loggedIn;
    }

    public boolean isAdminLoggedIn() {
        return adminLoggedIn;
    }

    public void setAdminLoggedIn(boolean adminLoggedIn) {
        this.adminLoggedIn = adminLoggedIn;
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
            case ADMIN:
                for (Admin admin : Admins) {
                    if (admin.getUsername().equals(username)) {
                        return true;
                    }
                }
            case STORE_OWNER:
                for (StoreOwner storeOwner : storeOwners) {
                    if (storeOwner.getUsername().equals(username)) {
                        return true;
                    }
                }
            case SUPPLIER:
                for (RawSupplier sp : Suppliers) {
                    if (sp.getUsername().equals(username)) {
                        return true;
                    }
                }
            default:
                return false;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStoreOwnerExist() {
        return storeOwnerExist;
    }

    public void setStoreOwnerExist(boolean storeOwnerExist) {
        this.storeOwnerExist = storeOwnerExist;
    }

    public boolean isSupplierExist() {
        return supplierExist;
    }

    public void setSupplierExist(boolean supplierExist) {
        this.supplierExist = supplierExist;
    }
}
