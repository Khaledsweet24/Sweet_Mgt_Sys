package Sweet.System;

import java.util.ArrayList;

public class User {
    private String  username;
    private String password;
    private boolean userLoggedIn;
    private String city;
    private String email;
    private Feedback userFeedback;
    private ArrayList<String> messagesList = new ArrayList<String>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email, String city) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.city = city;
        userLoggedIn = false;
    }
 // we need another constructor to set the email and the city among with the username and the password.

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

    public boolean isUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Feedback getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(Feedback userFeedback) {
        this.userFeedback = userFeedback;
    }

    public ArrayList<String> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(ArrayList<String> messageList) {
        this.messagesList = messageList;
    }

    public void addMessage(String message) {
        messagesList.add(message);
    }

    public String getMessage(int index){
        return messagesList.get(index);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
