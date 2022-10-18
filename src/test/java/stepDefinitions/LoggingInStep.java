package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.exceptions.FrameworkException;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@CucumberOptions(features = "src/test/resources/features/LoggingIn.feature", glue = {"stepDefinitions"}, plugin = {"pretty", "html:target/cucumber"})
public class LoggingInStep extends AbstractTestNGCucumberTests {

    protected WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private FrameworkException frameworkException;

    /**
     * Opens browser with specific url.
     *
     * @throws IOException {@link IOException} thrown if something goes wrong trying to take screenshot.
     */
    @Test
    @Given("The client is on the login page.")
    public void the_client_is_in_the_login_page() throws IOException {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        this.loginPage = new LoginPage(this.driver);
        this.driver.manage().window().maximize();
        assertThat(this.loginPage.validateElementsAreVisible());
        Reporter.log("The client is now on the Login Page.");
    }

    /**
     * Types username and password given via params in their respective fields and then clicks on 'login' button.
     *
     * @param username {@code String} used for communicating with web element.
     * @param password {@code String} used for communicating with web element.
     * @throws FrameworkException {@link FrameworkException} thrown if the web element is not found.
     * @throws IOException        {@link IOException} thrown if something goes wrong trying to take screenshot.
     */
    @Test
    @Parameters({"username", "password"})
    @When("Types {string} as username, {string} as password and clicks on log in button.")
    public void types_as_username_as_password_and_clicks_on_log_in_button(String username, String password) throws FrameworkException, IOException {
        this.loginPage.fillUsername(username);
        this.loginPage.fillPassword(password);
        try {
            this.homePage = this.loginPage.clickLoginButton();
            assertThat(this.homePage).isNotNull().withFailMessage("The 'Home Page' is null.");
            Reporter.log("The client could sign into the application.");
        } catch (FrameworkException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates {@link HomePage} is available.
     *
     * @throws IOException {@link IOException} thrown if something goes wrong trying to take screenshot.
     */
    @Test
    @Then("The Home Page is going to be displayed.")
    public void the_home_page_is_going_to_be_displayed() throws IOException {
        assertThat(this.homePage.validateElementsAreVisible());
        Reporter.log("The Home Page has loaded.");
    }

    /**
     * Types username given via params and clicks on 'login' button.
     *
     * @param username {@code String} used for communicating with web element.
     * @throws FrameworkException {@link FrameworkException} thrown if the web element is not found.
     * @throws IOException        {@link IOException} thrown if something goes wrong trying to take screenshot.
     */
    @Test
    @Parameters({"username"})
    @When("Types {string} as username and clicks on login button.")
    public void types_as_username_and_press_enter_key(String username) throws FrameworkException, IOException {
        this.loginPage.fillUsername(username);
        try {
            this.homePage = this.loginPage.clickLoginButton();
            Reporter.log("The client could sign into the application.");
        } catch (FrameworkException e) {
            this.frameworkException = e;
            Reporter.log("The client couldn't login into the application as it should happen in this scenario.");
        }
    }

    /**
     * Validates an error message has appeared in the login page.
     */
    @Test
    @Then("The Login page show an error message.")
    public void the_login_page_show_an_error_message() {
        assertThat(this.homePage).isNull();
        assertThat(this.frameworkException.getMessage())
                .contains("The client couldn't log in into the application.")
                .withFailMessage("Something else went wrong validating logging in - failed scenario.");
        Reporter.log("The 'Required' text appeared under the password field.");
    }

    /**
     * Closes browser after test.
     */
    @After
    @AfterTest
    public void tearDown() {
        this.driver.quit(); // -> Closes the chrome window.
        // this.driver.close(); -> Finishes the WebDriver instance.
    }

}
