package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.enums.Url;

public class Hooks {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void initWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Url.ORANGE_DEMO.getUrl());
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit(); // -> Closes the chrome window.
        // this.driver.close(); -> Finishes the WebDriver instance.
    }

}
