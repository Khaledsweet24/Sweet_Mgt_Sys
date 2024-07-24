package Sweet.System;

import java.util.ArrayList;

public class SweetSystem {
    private boolean registeredIn;
    private boolean loggedIn;
    private boolean UserValid;
    public ArrayList<User> Users = new ArrayList<User>();

    public SweetSystem() {
        // here we will fill the ArrayList from a file with the valid users.
        User Zahi = new User ("Admin","123"); // this is just for testing
        Users.add(Zahi);
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }


    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
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
            user.setMessage("User registered successfully!");
        }
    }

    public boolean isUserRegistered(User user) {
        return Users.contains(user);
    }
}
