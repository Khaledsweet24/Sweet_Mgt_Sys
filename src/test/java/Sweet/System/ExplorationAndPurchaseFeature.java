package Sweet.System;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExplorationAndPurchaseFeature {

    SweetSystem myApp;
    String expected="Chocolate Cake" + ": " + "a cake flavored with melted chocolate, cocoa powder" + "\n";
    String searchForDessert="Chocolate Cake";
    public ExplorationAndPurchaseFeature(SweetSystem myApp) {
        this.myApp = myApp;
    }

    @When("I want to explore dessert options")
    public void iWantToExploreDessertOptions() {

    }

    @Then("I should be able to browse and search for dessert recipes")
    public void iShouldBeAbleToBrowseAndSearchForDessertRecipes() {

        assertEquals("the Recipes search went not as expected",expected,myApp.SearchingList(searchForDessert));
    }

    @Then("List of dessert recipes I'm looking for should appear.")
    public void listOfDessertRecipesIMLookingForShouldAppear() {
        myApp.printSearchingList(searchForDessert);
        assertEquals("the Recipes search went not as expected",expected,myApp.SearchingList(searchForDessert));

    }

    @When("I have specific dietary needs or food allergies")
    public void iHaveSpecificDietaryNeedsOrFoodAllergies() {


    }

    @Then("I should be able to filter recipes based on those requirements")
    public void iShouldBeAbleToFilterRecipesBasedOnThoseRequirements() {

    }

    @When("I want to buy dessert")
    public void iWantToBuyDessert() {

    }

    @Then("I should be able to purchase dessert directly from store owners")
    public void iShouldBeAbleToPurchaseDessertDirectlyFromStoreOwners() {

    }

}
