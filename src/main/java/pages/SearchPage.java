package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class SearchPage {

    static WebDriver driver = Utils.getDriver();

    public static final By SEARCH_FIELD = By.id("search");
    public static final By SEARCH_RESULT_ITEM_DESCRIPTION = By.xpath("//*[@class='short-description']");

    public static void searchKeyword(String keyword) {
        Utils.clear(SEARCH_FIELD);
        Utils.writeText(SEARCH_FIELD, keyword);
        Utils.enter(SEARCH_FIELD);
    }

    public static void searchResultText() {
        List<WebElement> itemDescriptionNames = driver.findElements(SEARCH_RESULT_ITEM_DESCRIPTION);
            for (WebElement itemDescription : itemDescriptionNames) {
                String data = itemDescription.getText();
                Utils.writeToFileAppend("Search_result.txt", data);
            }
        }

    public static void refreshAndSearch(String keyword) {
        driver.navigate().refresh();
        Utils.clear(SEARCH_FIELD);
        Utils.writeText(SEARCH_FIELD, keyword);
        Utils.enter(SEARCH_FIELD);
    }

    public static List<String> searchExpectedText() {
        List <String> expectedList = new ArrayList<>();
        List<WebElement> itemDescriptionNames = driver.findElements(SEARCH_RESULT_ITEM_DESCRIPTION);
        for (WebElement itemDescription : itemDescriptionNames) {
            String data = itemDescription.getText();
            expectedList.add(data);
        }return expectedList;
    }

    public static String listToString() {
        String listString = "";
        for (String s : SearchPage.searchExpectedText()) {
            listString += s + "\n";
        }
        return listString;
    }
}