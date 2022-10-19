package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class HomePage extends BasePage {

    @FindBy(css = "a[href*='viewMyDetails']")
    private WebElement viewMyDetailsButton;

    @FindBy(css = "li[class*='oxd-userdropdown']")
    private WebElement userDropdownMenu;

    @FindBy(xpath = "//*[contains(text(), 'Add')]")
    private WebElement addButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Waits for {@link #addButton} to be clickable and clicks on it.
     *
     * @return new instance for {@link CreateUserPage}.
     * @throws IOException {@link IOException} thrown if something goes wrong trying to take screenshot.
     */
    public CreateUserPage clickOnAddButton() throws IOException {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.addButton));
        this.addButton.click();
        return new CreateUserPage(super.driver);
    }


}
