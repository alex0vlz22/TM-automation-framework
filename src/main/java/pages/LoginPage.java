package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.exceptions.FrameworkException;

import java.io.IOException;

public class LoginPage extends BasePage {

    private static final String PASSWORD_REQUIRED_TEXT_CSS_LOCATOR = ".oxd-input-field-error-message";

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsername(CharSequence username) {
        this.wait.until(ExpectedConditions.visibilityOf(this.usernameField));
        this.sendKeys(username, this.usernameField);
    }

    public void fillPassword(CharSequence password) {
        this.wait.until(ExpectedConditions.visibilityOf(this.passwordField));
        this.sendKeys(password, this.passwordField);
    }

    public HomePage clickLoginButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.loginButton));
        this.loginButton.click();
        return new HomePage(this.driver);
    }

    public String requiredErrorMessage() {
        WebElement requiredText = this.driver.findElement(By.cssSelector(PASSWORD_REQUIRED_TEXT_CSS_LOCATOR));
        this.wait.until(ExpectedConditions.visibilityOf(requiredText));
        return requiredText.getText();
    }

}
