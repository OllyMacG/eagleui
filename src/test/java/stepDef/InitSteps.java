package stepDef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.java.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Log
public class InitSteps extends BaseSteps {

    @Before
    public void testsConfig() {
        switch (browser) {
            case "Chrome":
                webDriver = new ChromeDriver();
                break;
            case "Explorer":
                webDriver = new InternetExplorerDriver();
                break;
            case "Firefox":
                webDriver = new FirefoxDriver();
                break;
            case "Safari":
                webDriver = new SafariDriver();
                break;
            default:
                log.info(browser + " is not recognised property please select either Chrome,Explorer,Firefox or Safari");
                webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
