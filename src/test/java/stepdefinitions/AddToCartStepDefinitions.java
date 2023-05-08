package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchAndAddProductPage;
import utilities.Driver;

import static utilities.Driver.*;

public class AddToCartStepDefinitions {
    SearchAndAddProductPage product = new SearchAndAddProductPage();
    public static String window1Handle = driver.getWindowHandle();

    @Given("user writes the {string} to the search box and click search button")
    public void userWritesTheToTheSearchBoxAndClickSearchButton(String productName) {
        product.searchBox.sendKeys(productName);
        product.searchButton.click();

    }

    @When("user clicks on the {string}")
    public void userClicksOnThe(String desired_item) {
        product.messiJersey.click();
       switchToNewTab();

    }

    @When("user clicks on Add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        product.addToCartButton.click();

    }

    @Then("verify that selected  product is in the cart")
    public void verify_that_selected_product_is_in_the_cart() {
        productNumberInTheCart(1);
        driver.close();
        switchToMainTab();

    }

    @Then("verify that selected  product is in the cart after second product")
    public void verifyThatSelectedProductIsInTheCartAfterSecondProduct() {
        productNumberInTheCart(2);
        driver.close();
        switchToMainTab();

    }

    @Then("verify that selected  product is in the cart after third product")
    public void verifyThatSelectedProductIsInTheCartAfterThirdProduct() {
        productNumberInTheCart(3);
        driver.close();
        switchToMainTab();
        Driver.wait(1);
    }

    @When("user clicks on the second {string}")
    public void userClicksOnTheSecond(String string) {
        product.ronaldoJersey.click();
        switchToNewTab();
    }

    @When("user clicks on the third {string}")
    public void userClicksOnTheThird(String string) {
        product.ardaJersey.click();
        switchToNewTab();
    }

    @When("user selects the size of the Jersey")
    public void userSelectsTheSizeOfTheJersey() {
        selectAnItemFromDropdown(product.sizeSelectRonaldoJersey,"4 to 5 Years");
    }
}
