package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {

    @FindBy(css = "a[href*='viewPimModule']")
    private WebElement pimOption;

    @FindBy(tagName = "body")
    private WebElement body;

    protected WebDriver driver;

    public Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        PageFactory.initElements(this.driver, this);
    }

    public void sendKeys(CharSequence charSequences, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(charSequences);
    }

    public void takeScreenshot(String screenshotName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) this.driver;
        File screenshotSource = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotSource, new File("./Screenshots/" + screenshotName + System.currentTimeMillis() + ".png"));
    }

    public boolean pageHasLoaded() throws IOException {
        try{
            this.wait.until(ExpectedConditions.visibilityOf(this.body));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            takeScreenshot("Exception");
            return false;
        }
    }

    public HomePage clickPimOption() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.pimOption));
        this.pimOption.click();
        return new HomePage(this.driver);
    }

}
