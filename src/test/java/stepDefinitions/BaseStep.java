package stepDefinitions;

import org.openqa.selenium.WebDriver;

import static stepDefinitions.Hooks.getDriver;

public class BaseStep {
    protected WebDriver driver = getDriver();

    protected String userId = "";

}
