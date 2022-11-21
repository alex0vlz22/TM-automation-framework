package actions;

import org.openqa.selenium.WebDriver;
import pages.CreateUserPage;
import pages.PersonalDetailsPage;

public class UserCreationActions {

    private WebDriver driver;

    public UserCreationActions(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalDetailsPage createUser(String firstName, CreateUserPage createUserPage) {
        createUserPage.fillNameField(firstName);
        return createUserPage.clickSaveButton();
    }

}
