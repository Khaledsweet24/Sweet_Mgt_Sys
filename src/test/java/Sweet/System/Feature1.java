package Sweet.System;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Feature1 {

    SweetSystem myApp;

        //dependency Injection
    public Feature1(SweetSystem myApp) {
        this.myApp = myApp;
    }

    @Given("user is not in the Sweet system")
    public void userIsNotInTheSweetSystem() {
        assertFalse(myApp.isLoggedIn());
    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        User user = new User(username,password);
        for(User u : myApp.Users) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                myApp.setLoggedIn(true);
                break;
            }
        }
    }

    @Then("user is now in the system")
    public void userIsNowInTheSystem() {
         assertTrue(myApp.isLoggedIn());
    }

    @Then("a welcome message will appear")
    public void aWelcomeMessageWillAppear() {

    }

    @Then("user is not logged in to the system")
    public void userIsNotLoggedInToTheSystem() {
        assertFalse(myApp.isLoggedIn());
    }

    @Then("a wrong password message will appear")
    public void aWrongPasswordMessageWillAppear() {

    }


    @Then("a wrong credential message will appear")
    public void aWrongCredentialMessageWillAppear() {

    }

}
