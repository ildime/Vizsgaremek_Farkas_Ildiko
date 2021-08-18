package logout;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutPageTest extends BaseTest {

    @DisplayName("Sikeres kijeletkezés teszt")
    @Test
    public void LogoutTest(){
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        LogoutPage.logoutSuccessful();
        LogoutPage.refreshToLogoutPage();
        assertEquals("Bejelentkezés", Utils.waitVisibility(HomePage.LOGIN_BUTTON).getText());
    }
}