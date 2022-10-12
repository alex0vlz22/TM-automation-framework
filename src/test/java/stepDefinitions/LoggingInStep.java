package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.exceptions.FrameworkException;

public class LoggingInStep{

    protected WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("The client is on the login page.")
    public void the_client_is_in_the_login_page() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        this.loginPage = new LoginPage(this.driver);
        this.driver.manage().window().maximize();
        assertThat(this.loginPage.validateElementsAreVisible());
    }

    @When("Types {string} as username, {string} as password and clicks on log in button.")
    public void types_as_username_as_password_and_clicks_on_log_in_button(String username, String password) throws FrameworkException {
        this.loginPage.fillUsername(username);
        this.loginPage.fillPassword(password);
        this.homePage = this.loginPage.clickLoginButton();
    }

    @Then("The Home Page is going to be displayed.")
    public void the_home_page_is_going_to_be_displayed() {
        assertThat(this.homePage.validateElementsAreVisible());
    }

}
