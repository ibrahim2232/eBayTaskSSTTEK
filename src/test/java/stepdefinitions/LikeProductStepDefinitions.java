package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchAndAddProductPage;
import utilities.Driver;

import javax.swing.*;

import static utilities.Driver.*;

public class LikeProductStepDefinitions {
    SearchAndAddProductPage product = new SearchAndAddProductPage();

    @When("user clicks on like button of desired product")
    public void user_clicks_on_like_button_of_desired_product() {
        product.likeButtonılhanMansizJersey.click();
        Driver.wait(1);
    }

    @When("user clicks on like button of desired second product")
    public void userClicksOnLikeButtonOfDesiredSecondProduct() {
        product.likeButtonHuaweiMatePad.click();
        Driver.wait(1);
    }

    @Then("user verify that number of liked items is correct after third like")
    public void userVerifyThatNumberOfLikedItemsIsCorrectAfterThirdLike() {
        productNumberInTheWatchList(3);
    }

    @When("user clicks on Add to watchlist button")
    public void userClicksOnAddToWatchlistButton() {
        product.addToWatchListButton.click();
        Driver.wait(1);
    }

    @And("user clicks on Watchlist on the product page")
    public void userClicksOnWatchlistOnTheProductPage() {
        product.watchlistButtonInTheProductPAge.click();
    }

    @When("user clicks on desired third product")
    public void userClicksOnDesiredThirdProduct() {
        product.theCoffeeMachineButton.click();
        switchToNewTab();
        Driver.wait(1);
    }
}
