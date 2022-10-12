package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.enums.TimeForWaiting;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void sendKeys(CharSequence charSequences, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(charSequences);
    }

    public boolean waitForWebElementVisibility(TimeForWaiting seconds, WebElement webElement) {
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds.getValue()));
        return this.wait.until(ExpectedConditions.visibilityOf(webElement)) != null;
    }

    public boolean waitForWebElementToBeClickable(TimeForWaiting seconds, WebElement webElement) {
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds.getValue()));
        return this.wait.until(ExpectedConditions.elementToBeClickable(webElement)) != null;
    }

    public boolean waitForMultipleWebElementsToBeVisible(TimeForWaiting seconds, List<WebElement> elements) {
        for (WebElement element : elements) {
            if (!waitForWebElementVisibility(seconds, element))
                return false;
        }
        return true;
    }

}
