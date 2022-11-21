package stepDefinitions;

import actions.UserCreationActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.*;
import utils.exceptions.FrameworkException;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageStep extends BaseStep {
    private LoginPage loginPage = new LoginPage(super.driver);
    private HomePage homePage = new HomePage(super.driver);

    // --------------------------------- LOGIN --------------------------------------------- #1

    @Given("^The client is on the login page.$")
    public void openPage() {
        this.loginPage = new LoginPage(driver);
        Reporter.log("The client is now on the Login Page.");
    }

    @When("^Types (.*) as username, (.*) as password and clicks on log in button.$")
    public void signIn(String username, String password) {
        this.loginPage.fillUsername(username);
        this.loginPage.fillPassword(password);
        this.homePage = this.loginPage.clickLoginButton();
        System.out.println("xd");
    }

    // --------------------------------- Failed Login --------------------------------------------- #2

    @When("^Types (.*) as username and clicks on login button.$")
    public void signInWithoutPassword(String username) throws IOException {
        this.loginPage.fillUsername(username);
        this.homePage = this.loginPage.clickLoginButton();
        assertThat(this.loginPage.pageHasLoaded()).isTrue();
    }

    @Then("^The Login page show an error message.$")
    public void validateErrorMessage() {
        assertThat(this.loginPage.requiredErrorMessage()).contains("Required").withFailMessage("Required message didn't appear.");
        Reporter.log("The 'Required' text appeared under the password field.");
        if (this.loginPage.requiredErrorMessage().equals("Required")) {
            this.homePage = null;
            Reporter.log("The client could sign into the application.");
        }
    }

    // ----------------------------------- LOGOUT WORKING ---------------------------------------------- #20

    @When("The client logs outta the application.")
    public void logoutOfTheApplication() throws IOException {
        assertThat(this.homePage.pageHasLoaded()).isTrue();
        this.loginPage = this.homePage.logout();
        assertThat(this.loginPage.pageHasLoaded()).isTrue();
    }

}
