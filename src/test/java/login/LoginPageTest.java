package login;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.CustomerAccountPage;
import pages.LoginPage;
import pages.LogoutPage;
import utils.Utils;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends BaseTest {

    @DisplayName("Sikeres bejelentkezés teszt")
    @Test
    public void LoginTest(){
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        Utils.TakeScreenshot(Utils.getDriver());
        assertEquals("Szia, illusionless beauty!", Utils.waitVisibility(CustomerAccountPage.WELCOME).getText());
        LogoutPage.logoutSuccessful();
    }

    @DisplayName("Sikertelen bejelentkezés teszt -helytelen jelszó")
    @Test
    public void LoginInvalidPasswordTest(){
        LoginPage.loginInvalidPassword("illusionlessbeauty@gmail.com", "onster");
        String eMsg = LoginPage.loginErrorMsg();
        assertEquals("Érvénytelen felhasználói név vagy jelszó.", eMsg);
    }

    @DisplayName("Sikertelen bejelentkezés teszt -helytelen mail")
    @Test
    public void LoginInvalidEmailTest(){
        LoginPage.loginInvalidEmail("llusionlessbeauty@gmail.com", "Monster");
        String eMsg = LoginPage.loginErrorMsg();
        assertEquals("Érvénytelen felhasználói név vagy jelszó.", eMsg);
    }

    @DisplayName("Sikertelen bejelentkezés teszt -üres mail")
    @Test
    public void LoginInvalidEmptyETest(){
        LoginPage.loginInvalidEmptyE("", "Monster");
        String vEMsg = LoginPage.loginValidationEMsg();
        assertEquals("Ez egy kötelező mező.", vEMsg);
    }

    @DisplayName("Sikertelen bejelentkezés teszt -üres jelszó")
    @Test
    public void LoginInvalidEmptyPWTest(){
        LoginPage.loginInvalidEmptyPW("illusionlessbeauty@gmail.com", "");
        String vPWMsg = LoginPage.loginValidationPWMsg();
        assertEquals("Ez egy kötelező mező.", vPWMsg);
    }
}