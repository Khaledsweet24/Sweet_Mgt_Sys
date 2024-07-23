package Sweet.System;

import java.util.ArrayList;

public class SweetSystem {
    private boolean loggedIn;
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

}
