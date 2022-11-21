package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateUserPage extends BasePage {

    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement name;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveButton;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[last()]")
    private WebElement employeeIdField;

    @FindBy(css = "a[href*='viewPimModule']")
    private WebElement pimOption;

    public CreateUserPage(WebDriver driver) {
        super(driver);
    }

    public void fillNameField(CharSequence name) {
        super.wait.until(ExpectedConditions.visibilityOf(this.name));
        this.name.sendKeys(name);
    }

    public PersonalDetailsPage clickSaveButton() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.saveButton));
        this.saveButton.click();
        return new PersonalDetailsPage(super.driver);
    }

    public String getEmployeeId() {
        super.wait.until(ExpectedConditions.visibilityOf(this.employeeIdField));
        return this.employeeIdField.getAttribute("value");
    }

    public HomePage clickOnPimOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.pimOption));
        this.pimOption.click();
        return new HomePage(super.driver);
    }

}
