package login;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.CustomerAccountPage;
import pages.LoginPage;
import pages.LogoutPage;
import utils.Utils;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends BaseTest {

    @DisplayName("TC-4  Sikeres bejelentkezés teszt")
    @Test
    @Order(4)
    public void LoginTest(){
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        assertEquals("Szia, illusionless beauty!", Utils.waitVisibility(CustomerAccountPage.WELCOME).getText());
        LogoutPage.logoutSuccessful();
    }

    @DisplayName("TC-5  Sikertelen bejelentkezés teszt -helytelen jelszó")
    @Test
    @Order(5)
    public void LoginInvalidPasswordTest(){
        LoginPage.loginInvalidPassword("illusionlessbeauty@gmail.com", "onster");
        String eMsg = LoginPage.loginErrorMsg();
        assertEquals("Érvénytelen felhasználói név vagy jelszó.", eMsg);
    }

    @DisplayName("TC-6  Sikertelen bejelentkezés teszt -helytelen mail")
    @Test
    @Order(6)
    public void LoginInvalidEmailTest(){
        LoginPage.loginInvalidEmail("llusionlessbeauty@gmail.com", "Monster");
        String eMsg = LoginPage.loginErrorMsg();
        assertEquals("Érvénytelen felhasználói név vagy jelszó.", eMsg);
    }

    @DisplayName("TC-7  Sikertelen bejelentkezés teszt -üres mail mező")
    @Test
    @Order(7)
    public void LoginInvalidEmptyETest(){
        LoginPage.loginInvalidEmptyE("", "Monster");
        String vEMsg = LoginPage.loginValidationEMsg();
        assertEquals("Ez egy kötelező mező.", vEMsg);
    }

    @DisplayName("TC-8  Sikertelen bejelentkezés teszt -üres jelszó mező")
    @Test
    @Order(8)
    public void LoginInvalidEmptyPWTest(){
        LoginPage.loginInvalidEmptyPW("illusionlessbeauty@gmail.com", "");
        String vPWMsg = LoginPage.loginValidationPWMsg();
        assertEquals("Ez egy kötelező mező.", vPWMsg);
    }
}