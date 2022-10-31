package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MaintenancePage extends BasePage {

    @FindBy(css = "h6[class*='oxd-text oxd-text--h6 orangehrm-admin-access-title']")
    private WebElement sectionTitleH6;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()=' Cancel ']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[text()=' Confirm ']")
    private WebElement confirmButton;

    @FindBy(css = "h6[class*='orangehrm-main-title']")
    private WebElement purgeEmployeeRecordsH6;

    public MaintenancePage(WebDriver driver) {
        super(driver);
    }

    public String getSectionTitleH6() {
        super.wait.until(ExpectedConditions.visibilityOf(this.sectionTitleH6));
        return this.sectionTitleH6.getText();
    }

    public String getPurgeEmployeeRecordsText() {
        super.wait.until(ExpectedConditions.visibilityOf(this.purgeEmployeeRecordsH6));
        return this.purgeEmployeeRecordsH6.getText();
    }

    public void fillPassword(CharSequence password) {
        super.wait.until(ExpectedConditions.visibilityOf(this.passwordField));
        super.sendKeys(password, this.passwordField);
    }

    public HomePage clickOnCancelButton() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));
        this.cancelButton.click();
        return new HomePage(super.driver);
    }

    public HomePage clickOnConfirmButton() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.confirmButton));
        String password = this.passwordField.getAttribute("value");
        switch (password) {
            case "admin123":
                this.confirmButton.click();
                return new HomePage(super.driver);
            default:
                this.confirmButton.click();
                return null;
        }
    }

    public String getRequiredText() {
        super.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class*='oxd-input-field-error-message']")));
        return super.driver.findElement(By.cssSelector("span[class*='oxd-input-field-error-message']")).getText();
    }

    public String getInvalidCredentialsText() {
        super.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class*='oxd-alert-content-text']")));
        return super.driver.findElement(By.cssSelector("p[class*='oxd-alert-content-text']")).getText();
    }

}

