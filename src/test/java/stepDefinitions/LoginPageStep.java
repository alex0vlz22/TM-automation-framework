package stepDefinitions;

import actions.UserCreationActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.exceptions.FrameworkException;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageStep extends BaseStep {

    private String userId = "";

    // --------------------------------- LOGIN --------------------------------------------- #1

    @Given("^The client is on the login page.$")
    public void openPage() {
        super.loginPage = new LoginPage(driver);
        Reporter.log("The client is now on the Login Page.");
    }

    @When("^Types (.*) as username, (.*) as password and clicks on log in button.$")
    public void signIn(String username, String password) throws FrameworkException, IOException {
        super.loginPage.fillUsername(username);
        super.loginPage.fillPassword(password);
        try {
            super.homePage = super.loginPage.clickLoginButton();
        } catch (FrameworkException e) {
            e.printStackTrace();
        }
    }

    @Then("^The Home Page is displayed.$")
    public void validateHomePage() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        Reporter.log("The Home Page has loaded.");
    }

    // --------------------------------- Failed Login --------------------------------------------- #2

    @When("^Types (.*) as username and clicks on login button.$")
    public void signInWithoutPassword(String username) throws FrameworkException, IOException {
        super.loginPage.fillUsername(username);
        super.homePage = super.loginPage.clickLoginButton();
        assertThat(super.loginPage.pageHasLoaded()).isTrue();
    }

    @Then("^The Login page show an error message.$")
    public void validateErrorMessage() {
        assertThat(super.loginPage.requiredErrorMessage()).contains("Required").withFailMessage("Required message didn't appear.");
        Reporter.log("The 'Required' text appeared under the password field.");
        if (super.loginPage.requiredErrorMessage().equals("Required")) {
            super.homePage = null;
            Reporter.log("The client could sign into the application.");
        }
    }

    // --------------------------------- Create USER --------------------------------------------- #3

    @When("^The client goes to add a new user section.$")
    public void goingToAddUser() {
        super.createUserPage = super.homePage.clickOnAddButton();
    }

    @And("^The client creates a new user with (.*) as first name and (.*) as last name required fields.$")
    public void userCreation(String firstName, String lastName) throws IOException {
        UserCreationActions userCreationActions = new UserCreationActions(super.driver);
        super.personalDetailsPage = userCreationActions.createUser(firstName, lastName, super.createUserPage);
        assertThat(super.createUserPage.pageHasLoaded()).isTrue();
    }

    @Then("^Personal details is displayed.$")
    public void personalDetailsAreDisplayed() throws IOException {
        assertThat(super.personalDetailsPage.pageHasLoaded()).isTrue();
    }

    // ----------------------------------- FIND USER BY ID ---------------------------------------------- #4

    @Given("^An ID is available for the user creation.$")
    public void idIsVisible() {
        this.userId = super.createUserPage.getEmployeeId();
        assertThat(super.createUserPage.getEmployeeId()).isNotEmpty();
    }

    @When("^The client is back to home page.$")
    public void driverIsOnHomePage() throws IOException {
        super.personalDetailsPage.clickPimOption();
        assertThat(super.homePage.pageHasLoaded());
    }

    @When("^The client search by employee id.$")
    public void searchByEmployeeId() {
        super.homePage.fillEmployeeIdField(this.userId);
        super.homePage.clickSearchButton();
    }

    @Then("^The just created user is going to be found.$")
    public void userIsFound() {
        assertThat(super.homePage.getRecordFoundText()).isEqualTo("(1) Record Found");
    }

    // ----------------------------------- ADMIN OPTION WORKING ---------------------------------------------- #5

    @When("^The client clicks on Admin option.$")
    public void clickOnAdminOption() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        super.homePage.clickOnAdminOption();
    }

    @Then("^System users is displayed.$")
    public void systemUsersIsDisplayed() {
        assertThat(super.homePage.getSectionTitleH5()).isEqualTo("System Users");
    }

    // ----------------------------------- PIM OPTION WORKING ---------------------------------------------- #6

    @Given("^The client clicks on Add button for leaving the home page.$")
    public void clickOnAddUser() {
        super.createUserPage = super.homePage.clickOnAddButton();
    }

    @When("^The client clicks on PIM option.$")
    public void clickOnPimOption() throws IOException {
        assertThat(super.createUserPage.pageHasLoaded()).isTrue();
        super.homePage = super.createUserPage.clickOnPimOption();
        assertThat(super.homePage.pageHasLoaded()).isTrue();
    }

    @Then("^Employee information is displayed.$")
    public void employeeInformationDisplayed() {
        assertThat(super.homePage.getSectionTitleH5()).isEqualTo("Employee Information");
    }

    // ----------------------------------- LEAVE OPTION WORKING ---------------------------------------------- #7

    @When("^The client clicks on Leave option.$")
    public void clickOnLeaveOption() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        super.homePage.clickOnLeaveOption();
    }

    @Then("^Leave list is displayed.$")
    public void leaveListDisplayed() {
        assertThat(super.homePage.getSectionTitleH5()).isEqualTo("Leave List");
    }

    // ----------------------------------- LEAVE OPTION WORKING ---------------------------------------------- #8

    @When("^The client clicks on Time option.$")
    public void clickOnTimeOption() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        super.homePage.clickOnTimeOption();
    }

    @Then("^Select Employee is displayed.$")
    public void selectEmployeeDisplayed() {
        assertThat(super.homePage.getSectionTitleH6()).isEqualTo("Select Employee");
    }

    // ----------------------------------- RECRUITMENT OPTION WORKING ---------------------------------------------- #9

    @When("The client clicks on Recruitment option.")
    public void clickOnRecruitmentOption() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        super.homePage.clickOnRecruitmentOption();
    }

    @Then("Candidates is displayed.")
    public void candidatesDisplayed() {
        assertThat(super.homePage.getSectionTitleH5()).isEqualTo("Candidates");
    }

    // ----------------------------------- MY INFO OPTION WORKING ---------------------------------------------- #10

    @When("The client clicks on My Info option.")
    public void clickOnMyInfoOption() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        super.personalDetailsPage = super.homePage.clickOnMyDetailsOption();
    }

    // ----------------------------------- PERFORMANCE OPTION WORKING ---------------------------------------------- #11

    @When("The client clicks on Performance option.")
    public void clickOnPerformanceOption() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        super.homePage.clickOnPerformanceOption();
    }

    @Then("Employee Reviews is displayed.")
    public void employeeReviewsDisplayed() {
        assertThat(super.homePage.getSectionTitleH5()).isEqualTo("Employee Reviews");
    }

    // ----------------------------------- DASHBOARD OPTION WORKING ---------------------------------------------- #12

    @When("The client clicks on Dashboard option.")
    public void clickOnDashboardOption() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        super.homePage.clickOnDashboardOption();
    }

    @Then("Launching Soon is displayed.")
    public void launchingSoonDisplayed() {
        assertThat(super.homePage.getSectionTitleH4()).isEqualTo("Launching Soon");
    }

    // ----------------------------------- DIRECTORY OPTION WORKING ---------------------------------------------- #13

    @When("The client clicks on Directory option.")
    public void clickOnDirectoryOption() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        super.homePage.clickOnDirectoryOption();
    }

    @Then("Directory is displayed.")
    public void directoryDisplayed() {
        assertThat(super.homePage.getSectionTitleH5()).isEqualTo("Directory");
    }

    // ----------------------------------- MAINTENANCE OPTION WORKING ---------------------------------------------- #14

    @When("The client clicks on Maintenance option.")
    public void clickOnMaintenanceOption() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        super.maintenancePage = super.homePage.clickOnMaintenanceOption();
    }

    @Then("Administrator Access is displayed.")
    public void administratorAccessIsDisplayed() {
        assertThat(super.maintenancePage.getSectionTitleH6()).isEqualTo("Administrator Access");
    }

    // ----------------------------------- MAINTENANCE / CANCEL BUTTON WORKING ---------------------------------------------- #15

    @When("The client clicks on Cancel button.")
    public void clickOnCancelMaintenance() throws IOException {
        assertThat(super.maintenancePage.pageHasLoaded()).isTrue();
        super.homePage = super.maintenancePage.clickOnCancelButton();
    }

    // ----------------------------------- MAINTENANCE / CONFIRM BUTTON WORKING ---------------------------------------------- #16

    @When("The client clicks on Confirm button.")
    public void clickOnConfirmMaintenance() throws IOException {
        assertThat(super.maintenancePage.pageHasLoaded()).isTrue();
        super.homePage = super.maintenancePage.clickOnConfirmButton();
    }

    @Then("Required text is displayed.")
    public void requiredTextDisplayed() {
        assertThat(super.homePage).isNull();
        assertThat(super.maintenancePage.getRequiredText()).contains("Required");
    }

    // ----------------------------------- MAINTENANCE / CONFIRM BUTTON WORKING ---------------------------------------------- #17

    @When("^The client fills (.*) as password.$")
    public void fillingPassword(String password) throws IOException {
        assertThat(super.maintenancePage.pageHasLoaded()).isTrue();
        super.maintenancePage.fillPassword(password);
    }

    @Then("Invalid credentials is displayed.")
    public void invalidCredentialsDisplayed() {
        assertThat(super.maintenancePage.getInvalidCredentialsText()).contains("Invalid credentials");
    }

    // ----------------------------------- MAINTENANCE / CONFIRM BUTTON WORKING ---------------------------------------------- #18

    @Then("Purge Employee Records is displayed.")
    public void purgeEmployeeRecordsDisplayed() throws IOException {
        assertThat(super.maintenancePage.getPurgeEmployeeRecordsText()).contains("Purge Employee Records");
        assertThat(super.homePage.pageHasLoaded()).isTrue();
    }

    // ----------------------------------- BUZZ OPTION WORKING ---------------------------------------------- #19

    @When("The client clicks on Buzz option.")
    public void clickOnBuzzOption() {
        super.homePage.clickOnBuzzOption();
    }

    // ----------------------------------- LOGOUT WORKING ---------------------------------------------- #20

    @When("The client logs outta the application.")
    public void logoutOfTheApplication() throws IOException {
        assertThat(super.homePage.pageHasLoaded()).isTrue();
        super.loginPage = super.homePage.logout();
        assertThat(super.loginPage.pageHasLoaded()).isTrue();
    }

}
