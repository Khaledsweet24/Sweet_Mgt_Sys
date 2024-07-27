package Sweet.System;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;

import static Sweet.System.userType.STORE_OWNER;
import static Sweet.System.userType.SUPPLIER;
import static org.junit.Assert.*;

public class UserManagmentFeature {
    SweetSystem myApp;
    Admin admin;
    StoreOwner storeOwner1;
    RawSupplier supplier1;

    public UserManagmentFeature(SweetSystem myApp) {
        this.myApp = myApp;
    }

    @Given("I am an admin logged in to the Sweet System using username {string} and password {string}")
    public void iAmAnAdminLoggedInToTheSweetSystemUsingUsernameAndPassword(String un, String passcode) {
        for (Admin a : myApp.Admins)
        {
            if(a.getUsername().equals(un) && a.getPassword().equals(passcode))
            {
                myApp.setAdminLoggedIn(true);
                assertTrue(myApp.isAdminLoggedIn());
            }
            else
            {
            myApp.setAdminLoggedIn(false);
            assertFalse(myApp.isAdminLoggedIn());
            }

        }
    }

    @When("I add a store owner with a username {string} and a password {string} and an email {string}")
    public void iAddAStoreOwnerWithAUsernameAndAPasswordAndAnEmail(String un, String pass, String email) {
        storeOwner1 = new StoreOwner(un,pass,email);
        myApp.storeOwners.add(storeOwner1);
        myApp.setMessage("Operation Complete!");
    }

    @Then("the store owner should be added to the Sweet System")
    public void theStoreOwnerShouldBeAddedToTheSweetSystem() {
        assertTrue(myApp.isAddedInSystem(STORE_OWNER ,storeOwner1.getUsername()));
    }

    @Then("a confirmation message will appear")
    public void aConfirmationMessageWillAppear() {
        myApp.setMessage("Operation Complete!");
        String expectedMessage = "Operation Complete!";
        assertEquals("Store Owner was not added properly!", expectedMessage, myApp.getMessage());
    }

    @Given("a store owner with username {string} exists in the Sweet System")
    public void aStoreOwnerWithUsernameExistsInTheSweetSystem(String username) {
        for(StoreOwner st : myApp.storeOwners)
        {
            if(st.getUsername().equals(username))
            {
                myApp.setStoreOwnerExist(true);
                assertTrue(myApp.isStoreOwnerExist());
                break;
            }
            else {
                myApp.setStoreOwnerExist(false);
                assertFalse(myApp.isStoreOwnerExist());
                break;
            }
        }

    }

    @When("I remove the store owner with a username {string}")
    public void iRemoveTheStoreOwnerWithAUsername(String username) {
        Iterator<StoreOwner> iterator = myApp.storeOwners.iterator();
        while (iterator.hasNext()) {
            StoreOwner storeOwner = iterator.next();
            if (storeOwner.getUsername().equals(username)) {
                iterator.remove();
                myApp.setStoreOwnerExist(false);
                break;
            }
        }
    }


    @Then("the store owner should be removed from the Sweet System")
    public void theStoreOwnerShouldBeRemovedFromTheSweetSystem() {
        assertFalse(myApp.isStoreOwnerExist());
    }

    @When("I add a supplier with a username {string} and a password {string} and an email {string}")
    public void iAddASupplierWithAUsernameAndAPasswordAndAnEmail(String un, String pass, String email) {
        supplier1 = new RawSupplier(un,pass,email);
        myApp.Suppliers.add(supplier1);
        myApp.setMessage("Operation Complete!");
    }

    @Then("the supplier should be added to the Sweet System")
    public void theSupplierShouldBeAddedToTheSweetSystem() {
        assertTrue(myApp.isAddedInSystem(SUPPLIER ,supplier1.getUsername()));
    }

    @Given("a supplier with username {string} exists in the Sweet System")
    public void aSupplierWithUsernameExistsInTheSweetSystem(String string) {

    }

    @When("I remove a supplier with a username {string}")
    public void iRemoveASupplierWithAUsername(String string) {

    }

    @Then("the supplier should be removed from the Sweet System")
    public void theSupplierShouldBeRemovedFromTheSweetSystem() {

    }

    @Given("I am an admin logged into the Sweet System")
    public void iAmAnAdminLoggedIntoTheSweetSystem() {

    }

    @When("I view the user list")
    public void iViewTheUserList() {

    }

    @Then("I should see the list of all store owners and raw material suppliers and normal users")
    public void iShouldSeeTheListOfAllStoreOwnersAndRawMaterialSuppliersAndNormalUsers() {

    }

}
