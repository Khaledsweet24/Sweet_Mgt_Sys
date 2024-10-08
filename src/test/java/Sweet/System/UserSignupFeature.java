package Sweet.System;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class UserSignupFeature {
    SweetSystem myApp;
    User user;
    public UserSignupFeature(SweetSystem myApp) {
        this.myApp = myApp;
    }

    @Given("user is not registered in the Sweet System")
    public void userIsNotRegisteredInTheSweetSystem() {
        assertFalse(myApp.isRegisteredIn());
    }

    @When("user enters a username {string} and a password {string} and an email {string} and his city {string}")
    public void userEntersAUsernameAndAPasswordAndAnEmailAndHisCity(String username, String password,String email, String city) {
        user = new User(username, password, email, city);
        if (myApp.isValidUsername(username) && myApp.isValidPassword(password)) {
            myApp.setUserValid(true);
            assertTrue(myApp.isUserValid());
        } else {
            myApp.setUserValid(false);
            myApp.setMessage("Invalid Credentials!");
            assertFalse(myApp.isUserValid());
        }
    }

    @Then("user is registered into the Sweet System")
    public void userIsRegisteredIntoTheSweetSystem() {
        if (myApp.isUserValid()) {
            myApp.registerUser(user);
        }
        assertTrue(myApp.isUserRegistered(user));
    }

    @Then("a successful signup message will appear")
    public void aSuccessfulSignupMessageWillAppear() {
        String expectedMessage = "User registered successfully!";
        assertEquals(expectedMessage,myApp.getMessage());
    }


    @Then("wrong credential message will appear")
    public void wrongCredentialMessageWillAppear() {
        String expectedMessage = "Invalid Credentials!";
        assertEquals("Invalid credentials message not displayed correctly", expectedMessage, myApp.getMessage());
    }
}
