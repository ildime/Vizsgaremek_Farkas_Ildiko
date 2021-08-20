package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;
import java.util.List;

public class ExpertAdvicePage {

    static WebDriver driver = Utils.getDriver();

    private static final By NEXT_BUTTON = By.xpath("//*[@class='next']");
    private static final By TITEL = By.xpath("//*[@class='postTitle']");

    public static void pagination() {
        HomePage.navigateToExpertAdvicePage();

        do {
            List<WebElement> blogtitels = driver.findElements(TITEL);
            for (WebElement blogtitel : blogtitels) {
                String data = blogtitel.getText();
                Utils.writeToFileAppend("Blogtitel.txt", data);
            }
            try {
                if (driver.findElement(NEXT_BUTTON).isDisplayed())
                    driver.findElement(NEXT_BUTTON).click();
            } catch (org.openqa.selenium.NoSuchElementException ex) {
                break;
            }
        } while (true);
    }
}