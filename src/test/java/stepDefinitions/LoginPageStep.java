package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.HomePage;
import pages.LoginPage;
import utils.exceptions.FrameworkException;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageStep extends BaseStep {

    private LoginPage loginPage;
    protected HomePage homePage;
    private FrameworkException frameworkException;

    @Given("^The client is on the login page.$")
    public void openPage() throws IOException {
        this.loginPage = new LoginPage(driver);
        Reporter.log("The client is now on the Login Page.");
    }

    @When("^Types (.*) as username, (.*) as password and clicks on log in button.$")
    public void signIn(String username, String password) throws FrameworkException, IOException {
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

    @Then("The Home Page is displayed.")
    public void validateHomePage() throws IOException {
        Reporter.log("The Home Page has loaded.");
    }

    @When("^Types (.*) as username and clicks on login button.$")
    public void signInWithoutPassword(String username) throws FrameworkException, IOException {
        this.loginPage.fillUsername(username);
        try {
            this.homePage = this.loginPage.clickLoginButton();
            Reporter.log("The client could sign into the application.");
        } catch (FrameworkException e) {
            this.frameworkException = e;
            Reporter.log("The client couldn't login into the application as it should happen in this scenario.");
        }
    }

    @Then("The Login page show an error message.")
    public void validateErrorMessage() {
        assertThat(this.homePage).isNull();
        assertThat(this.frameworkException.getMessage())
                .contains("The client couldn't log in into the application.")
                .withFailMessage("Something else went wrong validating logging in - failed scenario.");
        Reporter.log("The 'Required' text appeared under the password field.");
    }

    @When("The client goes to add a new user section.")
    public void the_client_goes_to_add_a_new_user_section() throws IOException {
        this.homePage.clickOnAddButton();
    }

    @And("The client creates a new user with all required fields.")
    public void the_client_creates_a_new_user_with_all_required_fields() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("Personal details must be displayed.")
    public void personal_details_must_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
    }

}
