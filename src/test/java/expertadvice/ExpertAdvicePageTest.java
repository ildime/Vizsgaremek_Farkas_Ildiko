package expertadvice;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.ExpertAdvicePage;
import java.io.BufferedReader;
import java.io.FileReader;

public class ExpertAdvicePageTest extends BaseTest {

    @DisplayName("TC-11  Több oldalas lista bejárás teszt")
    @Test
    @Order(11)
    public void paginationTest() {
        ExpertAdvicePage.pagination();

        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Blogtitel.txt"));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Assertions.assertEquals(47, lines);
    }
}