package privacypolicy;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.PrivacyPolicyPage;
import utils.Utils;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrivacyPolicyPageTest extends BaseTest {

    @DisplayName("TC-9  Adatkezelési nyilatkozat használata teszt - adatmentéssel")
    @Test
    public void PrivacyPolicySaveToFileTest(){
        PrivacyPolicyPage.dataPPSaveToFile();
        String result = Utils.readFromFile("PrivacyPolicyText.txt");
        String expected = "automatizált adatkezelésen alapuló döntés";
        assertTrue(result.contains(expected));
    }
}