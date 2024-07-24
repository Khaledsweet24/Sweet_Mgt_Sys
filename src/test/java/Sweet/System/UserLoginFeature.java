package Sweet.System;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class UserLoginFeature {

    SweetSystem myApp;
    User user;
        //dependency Injection
    public UserLoginFeature(SweetSystem myApp) {
        this.myApp = myApp;
    }

    @Given("user is not in the Sweet system")
    public void userIsNotInTheSweetSystem() {
        assertFalse(myApp.isLoggedIn());
    }


    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        user = new User(username,password);
        for(User u : myApp.Users) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                myApp.setLoggedIn(true);
                user.setMessage("Welcome " + username + "!");
                break;
            }
            else if(u.getUsername().equals(username)){
                user.setMessage("Wrong Password!");
                myApp.setLoggedIn(false);
            }
            else {
                user.setMessage("Invalid Credentials!");
                myApp.setLoggedIn(false);
            }
        }
    }

    @Then("user is now in the system")
    public void userIsNowInTheSystem() {
         assertTrue(myApp.isLoggedIn());
    }

    @Then("a welcome message will appear")
    public void aWelcomeMessageWillAppear() {
    String expectedMessage = "Welcome Admin!";
        assertEquals("Welcome message not displayed correctly", expectedMessage, user.getMessage());
    }

    @Then("user is not logged in to the system")
    public void userIsNotLoggedInToTheSystem() {
        assertFalse(myApp.isLoggedIn());
    }

    @Then("a wrong password message will appear")
    public void aWrongPasswordMessageWillAppear() {
        String expectedMessage = "Wrong Password!";
        assertEquals("Wrong password message not displayed correctly", expectedMessage, user.getMessage());
    }


    @Then("a wrong credential message will appear")
    public void aWrongCredentialMessageWillAppear() {
        String expectedMessage = "Invalid Credentials!";
        assertEquals("Invalid credentials message not displayed correctly", expectedMessage, user.getMessage());
    }

}
