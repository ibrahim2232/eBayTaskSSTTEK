package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchAndAddProductPage;
import utilities.Driver;

import static utilities.Driver.*;

public class DeleteProductFromCartStepDefinitions {
    SearchAndAddProductPage product = new SearchAndAddProductPage();

    @Given("user clicks on the cart")
    public void user_clicks_on_the_cart() {
        product.cart.click();
        Driver.wait(2);
    }

    @When("user clicks on the remove icon of the first product")
    public void user_clicks_on_the_remove_icon_of_the_first_product() {
    product.removeFirstProduct.click();
        Driver.wait(2);}

    @Then("user verify that number of total products decreased")
    public void user_verify_that_number_of_total_products_decreased() {
        productNumberInTheCart(2);}

    @Then("Then user verify that all items are deleted successfully")
    public void thenUserVerifyThatAllItemsAreDeletedSuccessfully() {
    isCartEmpty();}
}
