package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.InputSource;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static stepdefinitions.AddToCartStepDefinitions.window1Handle;

public class Driver {

    public static WebDriver driver;
    private static int timeout = 5;
    public Driver() {
    }
    public static WebDriver getDriver() {
        //create the driver if and only if it is null
        if (driver == null) {

            String browser = ConfigurationReader.getProperty("browser");
            if ("chrome".equals(browser)) {

                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(co);
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("edge".equals(browser)) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(edgeOptions);
            } else if ("safari".equals(browser)) {
                WebDriverManager.getInstance(SafariDriver.class).setup();
                driver = new SafariDriver();
            } else if ("chrome-headless".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
            }
        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//if the driver is pointing chrome
            driver.quit();//quit the driver
            driver = null;//set it back to null to make sure driver is null
        }
    }

    public static void switchToNewTab() {

        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String eachWindowHandle : allWindowHandles) {
            if (!eachWindowHandle.equals(window1Handle)) {
                driver.switchTo().window(eachWindowHandle);
                break;
            }
        }
    }
    public static void switchToMainTab() {
        driver.switchTo().window(window1Handle);
    }
    public static void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public static void waitAndClick(WebElement element) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void productNumberInTheCart(int expectedNumber) {
        // Find the WebElement using the XPath expression
        WebElement cartElement = driver.findElement(By.xpath("//a[contains(@aria-label,'Your shopping cart contains')]"));

        // Get the attribute value containing the number
        String ariaLabel = cartElement.getAttribute("aria-label");

        // Extract the number from the attribute value
        String numberString = ariaLabel.replaceAll("[^0-9]+", "");
        int number = Integer.parseInt(numberString);

        // Verify the number
        Assert.assertEquals(expectedNumber, number);
    }
    public static void productNumberInTheWatchList(int expectedNumber) {
        // Find the WebElement using the XPath expression
        WebElement cartElement = driver.findElement(By.xpath("//a[contains(@aria-label,'All Categories')]"));

        // Get the attribute value containing the number
        String ariaLabel = cartElement.getAttribute("aria-label");

        // Extract the number from the attribute value
        String numberString = ariaLabel.replaceAll("[^0-9]+", "");
        int number = Integer.parseInt(numberString);

        // Verify the number
        Assert.assertEquals(expectedNumber, number);
    }
    public static void isCartEmpty() {
        // Find the WebElement using the XPath expression
        WebElement cartElement = driver.findElement(By.xpath("//div[@class='empty-cart']/div/span/span/span"));

        String ariaText = cartElement.getText();

        Assert.assertEquals("You don't have any items in your cart. Let's get shopping!", ariaText);
    }

    public static void wait(int secs) {

        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void selectAnItemFromDropdown(WebElement item, String selectableItem) {
        wait(5);
        Select select = new Select(item);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(selectableItem)) {
                select.getOptions().get(i).click();
                break;
            }
        }
    }
}
