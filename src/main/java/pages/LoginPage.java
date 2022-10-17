package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import utils.enums.TimeForWaiting;
import utils.exceptions.FrameworkException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Waits for {@link #usernameField} visibility and send keys to it.
     *
     * @param username {@link #usernameField} used for communicating with web element.
     * @throws FrameworkException {@link FrameworkException} thrown if the web element is not found.
     * @throws IOException {@link IOException} thrown if something goes wrong trying to take screenshot.
     */
    public void fillUsername(CharSequence username) throws FrameworkException, IOException {
        if (super.waitForWebElementVisibility(TimeForWaiting.FIVE_SECONDS, this.usernameField)) {
            super.sendKeys(username, this.usernameField);
            throw new FrameworkException("The username field couldn't be found.");
        }
    }

    /**
     *
     *
     * @param password
     * @throws FrameworkException
     * @throws IOException
     */
    public void fillPassword(CharSequence password) throws FrameworkException, IOException {
        if (super.waitForWebElementVisibility(TimeForWaiting.FIVE_SECONDS, this.passwordField)) {
            super.sendKeys(password, this.passwordField);
        } else {
            throw new FrameworkException("The password field couldn't be found.");
        }
    }

    /**
     *
     * @return
     * @throws IOException
     * @throws FrameworkException
     */
    public HomePage clickLoginButton() throws IOException, FrameworkException {
        super.waitForWebElementToBeClickable(TimeForWaiting.FIVE_SECONDS, this.loginButton);
        this.loginButton.click();
        if (super.waitForByVisibility(TimeForWaiting.FIVE_SECONDS, By.cssSelector(PASSWORD_REQUIRED_TEXT_CSS_LOCATOR))) {
            throw new FrameworkException("The client couldn't log in into the application.");
        } else {
            return new HomePage(this.driver);
        }
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public boolean validateElementsAreVisible() throws IOException {
        List<WebElement> elements = new ArrayList<>();
        elements.add(this.usernameField);
        elements.add(this.passwordField);
        elements.add(this.loginButton);
        return super.waitForMultipleWebElementsToBeVisible(TimeForWaiting.FIVE_SECONDS, elements);
    }

}
