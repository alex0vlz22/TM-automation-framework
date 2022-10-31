package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class HomePage extends BasePage {

    private static final String RECORDS_FOUND_XPATH_LOCATOR = "//span[text()[contains(., 'Found')]]";

    @FindBy(css = "a[href*='viewMyDetails']")
    private WebElement viewMyDetailsButton;

    @FindBy(css = "li[class*='oxd-userdropdown']")
    private WebElement userDropdownMenu;

    @FindBy(xpath = "//*[contains(text(), 'Add')]")
    private WebElement addButton;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[last()]")
    private WebElement employeeIdField;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(css = "a[href*='viewAdminModule']")
    private WebElement adminOption;

    @FindBy(css = "a[href*='viewLeaveModule']")
    private WebElement leaveOption;

    @FindBy(css = "a[href*='viewTimeModule']")
    private WebElement timeOption;

    @FindBy(css = "a[href*='viewRecruitmentModule']")
    private WebElement recruitmentOption;

    @FindBy(css = "a[href*='viewMyDetails']")
    private WebElement myDetailsOption;

    @FindBy(css = "a[href*='viewPerformanceModule']")
    private WebElement performanceOption;

    @FindBy(css = "a[href*='dashboard']")
    private WebElement dashboardOption;

    @FindBy(css = "a[href*='viewDirectory']")
    private WebElement directoryOption;

    @FindBy(css = "a[href*='viewMaintenanceModule']")
    private WebElement maintenanceOption;

    @FindBy(css = "a[href*='viewBuzz']")
    private WebElement buzzOption;

    @FindBy(css = "h4[class*='oxd-text oxd-text--h4']")
    private WebElement sectionTitleH4;

    @FindBy(css = "h5[class*='oxd-text']")
    private WebElement sectionTitleH5;

    @FindBy(css = "h6[class*='oxd-text oxd-text--h6 orangehrm-main-title']")
    private WebElement sectionTitleH6;

    @FindBy(css = "a[href*='logout']")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CreateUserPage clickOnAddButton() {
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

    public void clickOnAdminOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.adminOption));
        this.adminOption.click();
    }

    public void clickOnLeaveOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.leaveOption));
        this.leaveOption.click();
    }

    public void clickOnTimeOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.timeOption));
        this.timeOption.click();
    }

    public void clickOnRecruitmentOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.recruitmentOption));
        this.recruitmentOption.click();
    }

    public PersonalDetailsPage clickOnMyDetailsOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.myDetailsOption));
        this.myDetailsOption.click();
        return new PersonalDetailsPage(super.driver);
    }

    public void clickOnPerformanceOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.performanceOption));
        this.performanceOption.click();
    }

    public void clickOnDashboardOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.dashboardOption));
        this.dashboardOption.click();
    }

    public void clickOnDirectoryOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.directoryOption));
        this.directoryOption.click();
    }

    public MaintenancePage clickOnMaintenanceOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.maintenanceOption));
        this.maintenanceOption.click();
        return new MaintenancePage(super.driver);
    }

    public void clickOnBuzzOption() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.buzzOption));
        this.buzzOption.click();
    }

    public String getSectionTitleH4() {
        super.wait.until(ExpectedConditions.visibilityOf(this.sectionTitleH4));
        return this.sectionTitleH4.getText();
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
