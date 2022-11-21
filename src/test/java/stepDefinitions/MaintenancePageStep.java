package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class MaintenancePageStep extends BaseStep{
    private HomePage homePage = new HomePage(super.driver);
    private MaintenancePage maintenancePage = new MaintenancePage(super.driver);

    // ----------------------------------- MAINTENANCE / CANCEL BUTTON WORKING ---------------------------------------------- #15

    @When("The client clicks on Cancel button.")
    public void clickOnCancelMaintenance() throws IOException {
        assertThat(this.maintenancePage.pageHasLoaded()).isTrue();
        this.homePage = this.maintenancePage.clickOnCancelButton();
    }

    // ----------------------------------- MAINTENANCE / CONFIRM BUTTON WORKING ---------------------------------------------- #16

    @When("The client clicks on Confirm button.")
    public void clickOnConfirmMaintenance() throws IOException {
        assertThat(this.maintenancePage.pageHasLoaded()).isTrue();
        this.homePage = this.maintenancePage.clickOnConfirmButton();
    }

    @Then("Required text is displayed.")
    public void requiredTextDisplayed() {
        assertThat(this.homePage).isNull();
        assertThat(this.maintenancePage.getRequiredText()).contains("Required");
    }

    // ----------------------------------- MAINTENANCE / CONFIRM BUTTON WORKING ---------------------------------------------- #17

    @When("^The client fills (.*) as password.$")
    public void fillingPassword(String password) throws IOException {
        assertThat(this.maintenancePage.pageHasLoaded()).isTrue();
        this.maintenancePage.fillPassword(password);
    }

    @Then("Invalid credentials is displayed.")
    public void invalidCredentialsDisplayed() {
        assertThat(this.maintenancePage.getInvalidCredentialsText()).contains("Invalid credentials");
    }

    // ----------------------------------- MAINTENANCE / CONFIRM BUTTON WORKING ---------------------------------------------- #18

    @Then("Purge Employee Records is displayed.")
    public void purgeEmployeeRecordsDisplayed() throws IOException {
        assertThat(this.maintenancePage.getPurgeEmployeeRecordsText()).contains("Purge Employee Records");
        assertThat(this.homePage.pageHasLoaded()).isTrue();
    }



}
