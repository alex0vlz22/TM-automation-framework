package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import utils.enums.TimeForWaiting;
import utils.exceptions.FrameworkException;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsername(CharSequence username) throws FrameworkException {
        if(super.waitForWebElementVisibility(TimeForWaiting.FIVE_SECONDS, this.usernameField)){
            super.sendKeys(username, this.usernameField);
        }else{
            throw new FrameworkException("The username field couldn't be found.");
        }
    }

    public void fillPassword(CharSequence password) throws FrameworkException {
        if(super.waitForWebElementVisibility(TimeForWaiting.FIVE_SECONDS, this.passwordField)){
            super.sendKeys(password, this.passwordField);
        }else{
            throw new FrameworkException("The password field couldn't be found.");
        }
    }

    public HomePage clickLoginButton(){
        super.waitForWebElementToBeClickable(TimeForWaiting.FIVE_SECONDS, this.loginButton);
        this.loginButton.click();
        return new HomePage(this.driver);
    }

    public boolean validateElementsAreVisible(){
        List<WebElement> elements = new ArrayList<>();
        elements.add(this.usernameField);
        elements.add(this.passwordField);
        elements.add(this.loginButton);
        return super.waitForMultipleWebElementsToBeVisible(TimeForWaiting.FIVE_SECONDS, elements);
    }

}
