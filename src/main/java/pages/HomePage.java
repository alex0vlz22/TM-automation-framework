package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import utils.enums.TimeForWaiting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public boolean validateElementsAreVisible() throws IOException {

        List<WebElement> elements = new ArrayList<>();
        elements.add(this.viewMyDetailsButton);
        elements.add(this.userDropdownMenu);
        elements.add(this.addButton);
        return super.waitForMultipleWebElementsToBeVisible(TimeForWaiting.FIVE_SECONDS, elements);
    }


}
