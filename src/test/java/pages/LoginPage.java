package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[text()='Sign in'])[1]")
    public WebElement signInButtonHomePage;

    @FindBy(id = "userid")
    public WebElement username;

    @FindBy(name = "signin-continue-btn")
    public WebElement continueButton;
    @FindBy(css = "input[type='password']")
    public WebElement password;

    @FindBy(id= "sgnBt")
    public WebElement signInButton;
    }

