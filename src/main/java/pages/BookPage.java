package pages;

import org.openqa.selenium.By;
import utils.Utils;

public class BookPage {

    public static final By BOOK_RECOMMENDATION = By.xpath("//*[@id='product-tabs']/div/div[2]/div");

    public static void dataBookSaveToFile(){
        HomePage.navigateToBookPage();
        String text = BookPage.bookRecommendationText();
        Utils.writeToFile("Book.txt", text);
    }

    public static String bookRecommendationText(){
        String text = Utils.getText(BOOK_RECOMMENDATION);
        return text;
    }
}