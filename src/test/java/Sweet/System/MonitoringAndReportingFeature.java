package Sweet.System;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MonitoringAndReportingFeature {

    SweetSystem myApp;
    StoreOwner storeOwner1 = new StoreOwner("StoreOwner1","SO1","storeOwner1@example.com");
    public MonitoringAndReportingFeature(SweetSystem myApp) {
        this.myApp = myApp;
    }

    @When("I generate a financial report")
        public void iGenerateAFinancialReport() {
            double profits;
            for (StoreOwner st : myApp.storeOwners) {
                profits =0.0;
                profits = st.calculateTotalProfit();
                st.setTotalProfit(profits);
                assertEquals(profits,5.0,0.001);
            }
        }
        @Then("I should see the total profits")
        public void iShouldSeeTheTotalProfits() {
        String expectedMessage ="The total profit is 5.0";
        String actualMessage="";
            for (StoreOwner st : myApp.storeOwners) {
                actualMessage = "The total profit is " + st.getTotalProfit();
//                System.out.println(expectedMessage);
            }
            assertEquals("A problem occured",expectedMessage,actualMessage);
        }

        @When("I request a report of best-selling products")
        public void iRequestAReportOfBestSellingProducts() {
        storeOwner1.setAdminRequest(true);
            assertTrue(storeOwner1.isAdminRequest());
        }
        @Then("I should see the list of best-selling products in each store")
        public void iShouldSeeTheListOfBestSellingProductsInEachStore() {
            String actualMessage= "";
            String expectedMessage="for Store StoreOwner1 The max selling item is Chocolate";
            for (StoreOwner st : myApp.storeOwners) {
                actualMessage = st.getMostSellingItem();
                assertEquals("Something Went wrong here",expectedMessage,actualMessage);
            }
        }
        @Then("the quantity sold for each product should be displayed")
        public void theQuantitySoldForEachProductShouldBeDisplayed() {
            ArrayList<String> actualMessage= new ArrayList<>();
            String expectedMessage="Chocolate product has been sold for 5 times";
            for (StoreOwner st : myApp.storeOwners) {
                actualMessage = st.getQuantitySoldTimes();
                assertEquals("Something Went wrong here",expectedMessage,actualMessage.get(0));
            }
        }

        @When("I request statistics on registered users by city")
        public void iRequestStatisticsOnRegisteredUsersByCity() {

        }
        @Then("I should see the number of registered users in each city")
        public void iShouldSeeTheNumberOfRegisteredUsersInEachCity() {

        }





}
