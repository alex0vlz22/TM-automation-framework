package stepDefinitions;

import actions.UserCreationActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.*;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserPageStep extends BaseStep {
    private CreateUserPage createUserPage = new CreateUserPage(super.driver);
    private PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(super.driver);

    // --------------------------------- Create USER --------------------------------------------- #3

    @And("^The client creates a new user with (.*) as name in required field.$")
    public void userCreation(String firstName) throws IOException {
        UserCreationActions userCreationActions = new UserCreationActions(this.driver);
        this.personalDetailsPage = userCreationActions.createUser(firstName, this.createUserPage);
        assertThat(this.createUserPage.pageHasLoaded()).isTrue();
    }

    // ----------------------------------- FIND USER BY ID ---------------------------------------------- #4

    @Given("^An ID is available for the user creation.$")
    public void idIsVisible() {
        super.userId = this.createUserPage.getEmployeeId();
        assertThat(this.createUserPage.getEmployeeId()).isNotEmpty();
    }

}
