package pages.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.enums.TimeForWaiting;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Sends keys to respective {@link WebElement}.
     *
     * @param charSequences {@link CharSequence} used for sending any keys to the element.
     * @param webElement {@link WebElement} used for accessing the UI element.
     */
    public void sendKeys(CharSequence charSequences, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(charSequences);
    }

    /**
     * Waits for a specific element visibility given respective seconds.
     *
     * @param seconds {@link TimeForWaiting} used for indicate how many seconds we're going to wait.
     * @param webElement {@link WebElement} used for accessing the UI element.
     * @return
     */
    public boolean waitForWebElementVisibility(TimeForWaiting seconds, WebElement webElement) throws IOException {
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds.getValue()));
        try {
            return this.wait.until(ExpectedConditions.visibilityOf(webElement)) != null;
        }catch (TimeoutException | NoSuchElementException exception){
            takeScreenshot("WaitingWebElementToBeVisible");
            return false;
        }
    }

    public boolean waitForByVisibility(TimeForWaiting seconds, By by) throws IOException {
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds.getValue()));
        try {
            return this.wait.until(ExpectedConditions.visibilityOfElementLocated(by)) != null;
        }catch (TimeoutException | NoSuchElementException exception){
            takeScreenshot("WaitingWebElementToBeVisible");
            return false;
        }
    }

    /**
     *
     *
     * @param seconds
     * @param webElement {@link WebElement} used for accessing the UI element.
     * @return
     */
    public boolean waitForWebElementToBeClickable(TimeForWaiting seconds, WebElement webElement) throws IOException {
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds.getValue()));
        try {
            return this.wait.until(ExpectedConditions.elementToBeClickable(webElement)) != null;
        }catch (TimeoutException | NoSuchElementException exception){
            takeScreenshot("WaitingWebElementToBeClickable");
            return false;
        }
    }

    /**
     *
     *
     * @param seconds
     * @param elements {@link WebElement} used for accessing the UI element.
     * @return
     */
    public boolean waitForMultipleWebElementsToBeVisible(TimeForWaiting seconds, List<WebElement> elements) throws IOException {
        for (WebElement element : elements) {
            if (!waitForWebElementVisibility(seconds, element))
                return false;
        }
        return true;
    }

    /**
     *
     * @param screenshotName
     * @throws IOException
     */
    public void takeScreenshot(String screenshotName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)this.driver;
        File screenshotSource = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotSource, new File("./Screenshots/" + screenshotName + System.currentTimeMillis() + ".png"));
    }

}
