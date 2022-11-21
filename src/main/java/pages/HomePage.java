package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.enums.HomePageOptions;

import java.io.IOException;

public class HomePage extends BasePage {

    private static final String RECORDS_FOUND_XPATH_LOCATOR = "//span[text()[contains(., 'Found')]]";

    @FindBy(css = "a[href*='viewMyDetails']")
    private WebElement viewMyDetailsButton;

    @FindBy(css = "li[class*='oxd-userdropdown']")
    private WebElement userDropdownMenu;

    @FindBy(xpath = "//*[text()=' Add ']")
    private WebElement addButton;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[last()]")
    private WebElement employeeIdField;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(css = "h4[class*='oxd-text oxd-text--h4']")
    private WebElement sectionTitleH4;

    @FindBy(css = "h5[class*='oxd-text']")
    private WebElement sectionTitleH5;

    @FindBy(css = "h6[class*='oxd-text']")
    private WebElement sectionTitleH6;

    @FindBy(css = "a[href*='logout']")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToAdminOption(){
        super.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='Admin']")));
        super.driver.findElement(By.cssSelector("a[href*='Admin']")).click();
    }

    public CreateUserPage clickOnAddButton() {
        goToAdminOption();
        super.wait.until(ExpectedConditions.elementToBeClickable(this.addButton));
        this.addButton.click();
        return new CreateUserPage(super.driver);
    }

    public void fillEmployeeIdField(String employeeId) {
        super.wait.until(ExpectedConditions.visibilityOf(this.employeeIdField));
        this.employeeIdField.sendKeys(employeeId);
    }

    public void clickSearchButton() {
        super.wait.until(ExpectedConditions.visibilityOf(this.searchButton));
        super.wait.until(ExpectedConditions.elementToBeClickable(this.searchButton));
        this.searchButton.click();
    }

    public String getRecordFoundText() {
        //super.wait.until(ExpectedConditions.visibilityOf(super.driver.findElement(By.xpath(RECORDS_FOUND_XPATH_LOCATOR))));
        super.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RECORDS_FOUND_XPATH_LOCATOR)));
        return super.driver.findElement(By.xpath(RECORDS_FOUND_XPATH_LOCATOR)).getText();
    }

    public void clickOnOption(HomePageOptions option) {
        super.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='" + option.getLocator() + "']")));
        WebElement optionButton = super.driver.findElement(By.cssSelector("a[href*='" + option.getLocator() + "']"));
        super.wait.until(ExpectedConditions.elementToBeClickable(optionButton));
        optionButton.click();
    }

    public String getSectionTitleH5() {
        super.wait.until(ExpectedConditions.visibilityOf(this.sectionTitleH5));
        return this.sectionTitleH5.getText();
    }

    public String getSectionTitleH6() {
        super.wait.until(ExpectedConditions.visibilityOf(this.sectionTitleH6));
        return this.sectionTitleH6.getText();
    }

    public LoginPage logout() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.userDropdownMenu));
        this.userDropdownMenu.click();
        super.wait.until(ExpectedConditions.elementToBeClickable(this.logoutButton));
        this.logoutButton.click();
        return new LoginPage(super.driver);
    }

}
