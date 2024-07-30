package Sweet.System;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContentManagementFeature {

    SweetSystem myApp;

    public ContentManagementFeature(SweetSystem myApp) {
        this.myApp = myApp;
    }

    @When("I request to see the content")
    public void iRequestToSeeTheContent() {

    }

    @Then("I should see a list of all recipes and posts")
    public void iShouldSeeAListOfAllRecipesAndPosts() {

    }

    @Then("I should be able to add a new recipe")
    public void iShouldBeAbleToAddANewRecipe() {

    }

    @Then("I should be able to edit an existing recipe")
    public void iShouldBeAbleToEditAnExistingRecipe() {

    }

    @Then("I should be able to delete an existing recipe")
    public void iShouldBeAbleToDeleteAnExistingRecipe() {

    }

    @Then("I should be able to add a new post")
    public void iShouldBeAbleToAddANewPost() {

    }

    @Then("I should be able to edit an existing post")
    public void iShouldBeAbleToEditAnExistingPost() {

    }

    @Then("I should be able to delete an existing post")
    public void iShouldBeAbleToDeleteAnExistingPost() {

    }

    @When("I request to see the users feedback")
    public void iRequestToSeeTheUsersFeedback() {

    }

    @Then("I should see a list of all users feedback")
    public void iShouldSeeAListOfAllUsersFeedback() {

    }

    @Then("I should be able to reply to feedback")
    public void iShouldBeAbleToReplyToFeedback() {

    }

}