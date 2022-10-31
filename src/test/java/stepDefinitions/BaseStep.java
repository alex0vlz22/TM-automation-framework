package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pages.*;
import utils.exceptions.FrameworkException;

import static stepDefinitions.Hooks.getDriver;

public class BaseStep {

    protected HomePage homePage;
    protected CreateUserPage createUserPage;
    protected LoginPage loginPage;

    protected MaintenancePage maintenancePage;

    protected PersonalDetailsPage personalDetailsPage;

    protected FrameworkException frameworkException;
    protected WebDriver driver = getDriver();

}
