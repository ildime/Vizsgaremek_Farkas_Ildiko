package expertadvice;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.ExpertAdvicePage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ExpertAdvicePageTest extends BaseTest {

    @DisplayName("Több oldalas lista bejárás teszt")
    @Test
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
