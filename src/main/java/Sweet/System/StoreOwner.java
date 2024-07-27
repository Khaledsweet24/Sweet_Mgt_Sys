package Sweet.System;

public class StoreOwner {
    private String username;
    private String password;
    private String email;
    private boolean storeOwnerExist;

    public StoreOwner(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        storeOwnerExist = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStoreOwnerExist() {
        return storeOwnerExist;
    }

    public void setStoreOwnerExist(boolean storeOwnerExist) {
        this.storeOwnerExist = storeOwnerExist;
    }
}

