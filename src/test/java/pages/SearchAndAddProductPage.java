package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchAndAddProductPage {
    public SearchAndAddProductPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "input[type=text]")
    public WebElement searchBox;
    @FindBy(css = "input[value='Search']")
    public WebElement searchButton;
    @FindBy(xpath = "//span[text()='Messi Jersey #10 Argentina Soccer Jersey 22/23 World Cup - Mens Large - NWT']")
    public WebElement messiJersey;
    @FindBy(xpath = "//span[text()='New Cristiano Ronaldo Al Nassr FC Soccer Uniform Jersey and Short Kids & Adults']")
    public WebElement ronaldoJersey;
    @FindBy(xpath = "//span[text()='NIKE Atlético Madrid 2014/15 Home Soccer Football Jersey SIZE: XS ARDA #10']")
    public WebElement ardaJersey;
    @FindBy(xpath = "//span[text()='Add to cart']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//select[@aria-label='Please select a Size and Age']")
    public WebElement sizeSelectRonaldoJersey;
    @FindBy(xpath = "(//div[@class='gh-menu']/a/descendant::*)[2]")
    public WebElement cart;
    @FindBy(xpath = "(//button[@data-test-id='cart-remove-item'])[1]")
    public WebElement removeFirstProduct;
    @FindBy(xpath = "//span[text()='BESIKTAS TURKEY 2002/2003 HOME #26 ILHAN MANSIZ FOOTBALL SHIRT JERSEY PUMA Sz L ']")
    public WebElement ilhanMansizJersey;
    @FindBy(xpath = "//a[@title='Watchlist']")
    public WebElement watchList;
    @FindBy(xpath = "//span[text()='View all items you are watching']")
    public WebElement viewAllItemsYouAreWatching;
    @FindBy(xpath = "(//span[text()='Add to Watchlist'])[2]")
    public WebElement addToWatchListButton;
    @FindBy(xpath = "(//span[text()='ARZUM Okka OK0012 K Rich Spin M Turkish Coffee Makers Machine 5 Cup 220 Volt'])[2]")
    public WebElement theCoffeeMachineButton;
    @FindBy(xpath = "//span[text()='Watchlist']")
    public WebElement watchlistButtonInTheProductPAge;
    @FindBy(xpath = "(//span[text()='BESIKTAS TURKEY 2002/2003 HOME #26 ILHAN MANSIZ FOOTBALL SHIRT JERSEY PUMA Sz L ']/ancestor::*)[9]/descendant::span[contains(@class,'watchheart-icon')]")
    public WebElement likeButtonılhanMansizJersey;
    @FindBy(xpath = "((//span[text()='Huawei MatePad 10.4 Inch Wi-Fi Model RAM3GB / ROM32GB Midnight Gray'])[2]/ancestor::*)[9]/descendant::span[contains(@class,'watchheart-icon')]")
    public WebElement likeButtonHuaweiMatePad;
}
