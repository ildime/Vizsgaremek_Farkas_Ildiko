package search;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.SearchPage;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SearchPageTest extends BaseTest {

    @DisplayName("Adatok listázása - szűrés")
    @Test
    public void dataListTest() {
        SearchPage.dataListSearchToFile("gorgeous");
        String data = Utils.readFromFile("Search_result.txt");
        SearchPageTest.refresh();
        String expected = SearchPage.searchExpectedText()+ ("\n");
        assertEquals(expected, data);
    }

    public static void refresh() {
        SearchPage.refreshAndSearch("gorgeous");
    }

//        PrivacyPolicyPage.dataPPSaveToFile();  + ("\n");
//        String result = Utils.readFromFile("PrivacyPolicyText.txt");
//        String expected = "automatizált adatkezelésen alapuló döntés";
//        assertTrue(result.contains(expected))
}