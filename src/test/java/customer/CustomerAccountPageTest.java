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
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CustomerAccountPageTest extends BaseTest {

    static WebDriver driver = Utils.getDriver();

    @Step("TakeScreenshot")
    public void TakeScreenshot(WebDriver driver){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @DisplayName("Ismételt és sorozatos adatbevitel adatforrásból - profil kitöltés")
    @Test
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

    @DisplayName("Meglévő adat módosítása - jelszó módosítása")
    @Test
    public void changePasswordTest(){
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        CustomerAccountPage.changePassword("Monster", "Beauty", "Beauty");
        TakeScreenshot(driver);
        String vPWMsg = CustomerAccountPage.changePasswordValidationPWMsg();
        assertEquals("Sikeres mentés.", vPWMsg);
        LogoutPage.logoutSuccessful();
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Beauty");
        CustomerAccountPage.changePassword("Beauty", "Monster", "Monster");
        TakeScreenshot(driver);
        LogoutPage.logoutSuccessful();
    }

    @DisplayName("Meglévő adat módosítása - sikertelen jelszó módosítás")
    @Test
    public void changePasswordInvalidTest(){
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        CustomerAccountPage.changePasswordInvalid("Monster", "Beauty", "beauty");
        String invalidPWMsg = CustomerAccountPage.changePasswordInvalidPWMsg();
        assertEquals("Ellenőrizze hogy egyezik e a megadott jelszó.", invalidPWMsg);
        LogoutPage.logoutSuccessful();
    }
}