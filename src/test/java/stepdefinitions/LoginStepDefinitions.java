package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.Driver;

import static utilities.Driver.waitAndClick;

public class LoginStepDefinitions{
    LoginPage loginPage = new LoginPage();

    @Given("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        loginPage.signInButtonHomePage.click();
    }

    @When("user sends username {string} and click on continue button")
    public void user_sends_username_and_click_on_continue_button(String string) {
        loginPage.username.sendKeys(string);
        waitAndClick( loginPage.continueButton,3);
        Driver.wait(3);
    }

    @When("user sends password {string}")
    public void user_sends_password(String string) {
     loginPage.password.sendKeys(string);
    }

    @Then("user clicks on the Sign in button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.signInButton.click();
    }
}
