package Sweet.System;

import java.util.ArrayList;

public class RawSupplier {
    private String username;
    private String password;
    private String email;
    private boolean supplierExist;
    private ArrayList<String> messagesList= new ArrayList<>();;

    public RawSupplier(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RawSupplier(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        supplierExist = false;
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

    public boolean isSupplierExist() {
        return supplierExist;
    }

    public void setSupplierExist(boolean supplierExist) {
        this.supplierExist = supplierExist;
    }

    public ArrayList<String> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(ArrayList<String> messagesList) {
        this.messagesList = messagesList;
    }

    public void addMessage(String message) {
        messagesList.add(message);
    }

    public String getMessage(int index) {
        return messagesList.get(index);
    }


}
