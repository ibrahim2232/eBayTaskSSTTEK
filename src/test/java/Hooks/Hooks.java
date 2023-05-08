package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {
    @Before
    public void setUp(){
//        RUNS BEFORE EACH SCENARIO

            Driver.getDriver().get(ConfigurationReader.getProperty("ebay_url"));

        }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            Is a scenario fails, then take the screenshot!!!!!
            scenario.attach(screenshot, "image/png","screenshots");
        }
      // Driver.closeDriver();
    }
    }