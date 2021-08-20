package search;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.SearchPage;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.*;


public class SearchPageTest extends BaseTest {

    @DisplayName("TC-10  Adatok listázása - szűrés")
    @Test
    @Order(10)
    public void dataListTest() {
        SearchPage.searchKeyword("szérum");
        SearchPage.searchResultText();
        String data = Utils.readFromFile("Search_result.txt");
        refresh();
        String expected = SearchPage.listToString();
        assertEquals(expected, data);
    }

    public static void refresh() {
        SearchPage.refreshAndSearch("szérum");
    }
}