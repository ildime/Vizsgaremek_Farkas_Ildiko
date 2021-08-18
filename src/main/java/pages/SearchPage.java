package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {

    static WebDriver driver = Utils.getDriver();

    public static final By SEARCH_FIELD = By.id("search");
    public static final By SEARCH_RESULT_BRAND = By.xpath("//*[@class='product-brand']");
    public static final By SEARCH_RESULT_NAME = By.xpath("//*[@class='product-name']");


    public static void dataListSearchToFile(String keyword) {
        Utils.writeText(SEARCH_FIELD, keyword);
        Utils.enter(SEARCH_FIELD);
 //       String text = SearchPage.listToString();    ezt a 2sort másik fg-be rakni, mert így már meg van wishben hívva
  //      Utils.writeToFile("Search_result.txt", text);
    }

    public static List<String> searchResultText() {
        List<String> result = new ArrayList<>();
        while (true) {
            String brandName = SearchPage.brandItemName();
            if (!result.contains(brandName)) {
                result.add(brandName);
            } else {
                break;
            }
        }
        return result;
    }


    public static String listToString() {
        String listString = "";
        for (String s : SearchPage.searchResultText()) {
            listString += s + "\t";
        }
        return listString;
    }


    public static String brandItemName() {
        String text = Utils.getText(SEARCH_RESULT_BRAND) + Utils.getText(SEARCH_RESULT_NAME);
        return text;
    }

    public static void refreshAndSearch(String keyword) {
        driver.navigate().refresh();
        Utils.writeText(SEARCH_FIELD, keyword);
        Utils.enter(SEARCH_FIELD);
    }

    public static String searchExpectedText() {
        String expected = Utils.getText(SEARCH_RESULT_BRAND) + Utils.getText(SEARCH_RESULT_NAME);
        return expected;
    }
}
