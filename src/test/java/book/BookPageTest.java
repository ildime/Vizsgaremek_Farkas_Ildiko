package book;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.BookPage;
import utils.Utils;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookPageTest extends BaseTest {

    @DisplayName("TC-17  Adatok lementése felületről teszt - könyv bemutató")
    @Test
    @Order(17)
    public void dataBookSaveToFileTest(){
        BookPage.dataBookSaveToFile();
        String data = Utils.readFromFile("Book.txt");
        String expected = BookPage.bookRecommendationText()+ ("\n");
        assertEquals(expected, data);
    }
}