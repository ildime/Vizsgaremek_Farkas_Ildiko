package customer;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.CustomerAccountPage;
import pages.LoginPage;
import pages.LogoutPage;
import utils.Utils;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerAccountPageTest extends BaseTest {

    static WebDriver driver = Utils.getDriver();

    @Step("TakeScreenshot")
    public void TakeScreenshot(WebDriver driver){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @DisplayName("TC-13  Ismételt és sorozatos adatbevitel adatforrásból - számlázási cím módosítása")
    @Test
    @Order(13)
    public void addressDataTest() {
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        CustomerAccountPage.addressData();
        TakeScreenshot(driver);
        CustomerAccountPage.fillData();
        TakeScreenshot(driver);
        String addressSavedMsgMsg = CustomerAccountPage.addressSavedMsg();
        assertEquals("The address has been saved.", addressSavedMsgMsg);
        LogoutPage.logoutSuccessful();
    }

    @DisplayName("TC-14  Meglévő adat módosítása - jelszó módosítása")
    @Test
    @Order(14)
    public void changePasswordTest(){
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        CustomerAccountPage.changePassword("Monster", "Beauty", "Beauty");
        String vPWMsg = CustomerAccountPage.changePasswordValidationPWMsg();
        assertEquals("Sikeres mentés.", vPWMsg);
        LogoutPage.logoutSuccessful();
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Beauty");
        CustomerAccountPage.changePassword("Beauty", "Monster", "Monster");
        LogoutPage.logoutSuccessful();
    }

    @DisplayName("TC-15  Meglévő adat módosítása - sikertelen jelszó módosítás")
    @Test
    @Order(15)
    public void changePasswordInvalidTest(){
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        CustomerAccountPage.changePasswordInvalid("Monster", "Beauty", "beauty");
        String invalidPWMsg = CustomerAccountPage.changePasswordInvalidPWMsg();
        assertEquals("Ellenőrizze hogy egyezik e a megadott jelszó.", invalidPWMsg);
        LogoutPage.logoutSuccessful();
    }
}