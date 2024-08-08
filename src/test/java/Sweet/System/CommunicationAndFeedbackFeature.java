package Sweet.System;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommunicationAndFeedbackFeature {

    SweetSystem myApp;
    public CommunicationAndFeedbackFeature(SweetSystem myApp) {
        this.myApp = myApp;
    }

    @When("I have an inquiry or need assistance")
    public void iHaveAnInquiryOrNeedAssistance() {

    }

    @Then("I should be able to directly communicate with store owners and suppliers")
    public void iShouldBeAbleToDirectlyCommunicateWithStoreOwnersAndSuppliers() {

    }

    @Then("I should be able to send a message describing my problem")
    public void iShouldBeAbleToSendAMessageDescribingMyProblem() {

    }

    @When("I want to share my experience")
    public void iWantToShareMyExperience() {

    }

    @Then("I should be able to provide feedback on the purchased product")
    public void iShouldBeAbleToProvideFeedbackOnThePurchasedProduct() {

    }

    @When("I want to share my thoughts or suggestions to recipe i followed")
    public void iWantToShareMyThoughtsOrSuggestionsToRecipeIFollowed() {

    }

    @Then("I should be able to leave feedback on the shared recipe")
    public void iShouldBeAbleToLeaveFeedbackOnTheSharedRecipe() {

    }
}
