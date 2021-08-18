package book;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.BookPage;
import utils.Utils;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookPageTest extends BaseTest {

    @DisplayName("Adatok lementése felületről teszt - Könyv bemutató")
    @Test
    public void dataBookSaveToFileTest(){
        BookPage.dataBookSaveToFile();
        String data = Utils.readFromFile("Book.txt");
        String expected = BookPage.bookRecommendationText()+ ("\n");
        assertEquals(expected, data);
    }
}