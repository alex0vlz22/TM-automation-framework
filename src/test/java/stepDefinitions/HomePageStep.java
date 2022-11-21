package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.testng.Reporter;
import pages.*;
import utils.enums.HomePageOptions;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageStep extends BaseStep {

    private HomePage homePage = new HomePage(super.driver);
    private CreateUserPage createUserPage = new CreateUserPage(super.driver);
    private PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(super.driver);


    // --------------------------------- LOGIN --------------------------------------------- #1

    @Then("^The Home Page is displayed$")
    public void validateHomePage() throws IOException {
        assertThat(this.homePage.pageHasLoaded()).isTrue();
        Reporter.log("The Home Page has loaded.");
    }

    // --------------------------------- Create USER --------------------------------------------- #3

    @When("^The client goes to add a new user section.$")
    public void goingToAddUser() {
        this.createUserPage = this.homePage.clickOnAddButton();
    }

    // ----------------------------------- FIND USER BY ID ---------------------------------------------- #4

    @When("^The client is back to home page.$")
    public void driverIsOnHomePage() throws IOException {
        this.personalDetailsPage.clickPimOption();
        assertThat(this.homePage.pageHasLoaded());
    }

    @When("^The client search by employee id.$")
    public void searchByEmployeeId() {
        this.homePage.fillEmployeeIdField(this.userId);
        this.homePage.clickSearchButton();
    }

    @Then("^The just created user is going to be found.$")
    public void userIsFound() {
        assertThat(this.homePage.getRecordFoundText()).isEqualTo("(1) Record Found");
    }

    /*
     * Admin, Leave, Time, Recruitment, My Info, Performance, Dashboard, Directory, Maintenance and Buzz options working.
     */

    @When("^The client clicks on (.*) option.$")
    public void clickOnOption(String option) throws IOException {
        assertThat(this.homePage.pageHasLoaded()).isTrue();
        this.homePage.clickOnOption(HomePageOptions.ADMIN.getByName(option));
    }

    @Then("^(.*) is displayed.$")
    public void systemUsersIsDisplayed(String optionTitle) {
        try {
            assertThat(this.homePage.getSectionTitleH5()).isEqualTo(optionTitle);
        } catch (TimeoutException ex) {
            assertThat(this.homePage.getSectionTitleH6()).isEqualTo(optionTitle);
        }
    }

    // ----------------------------------- PIM OPTION WORKING ---------------------------------------------- #6

    @Given("^The client clicks on Add button for leaving the home page.$")
    public void clickOnAddUser() {
        this.createUserPage = this.homePage.clickOnAddButton();
    }

}
