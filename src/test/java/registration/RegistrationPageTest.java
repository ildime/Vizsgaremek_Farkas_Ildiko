package registration;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.CustomerAccountPage;
import pages.LogoutPage;
import pages.RegistrationPage;
import utils.Utils;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest extends BaseTest {

    @DisplayName("TC-1  Sikeres regisztráció teszt - generált adatokkal")
    @Disabled    //@Test
    @Order(1)
    public void RegistrationTest(){
        String surname = RegistrationPage.autoGeneratedSurname();
        String name = RegistrationPage.autoGeneratedName();
        String email = RegistrationPage.autoGeneratedEmail();
        String password1 = RegistrationPage.autoGeneratedPassword1();
        RegistrationPage.registration(surname, name, email, password1, password1);
        assertEquals("Köszönjük, hogy regisztráltál! :)", Utils.waitVisibility(CustomerAccountPage.SUCCESS_MSG).getText());
        LogoutPage.logoutSuccessful();
    }

    @DisplayName("TC-2  Sikertelen regisztráció teszt - generált adatokkal, jelszómegerősítés különbözik")
    @Test
    @Order(2)
    public void RegistrationInvalidPasswordTest(){
        String surname = RegistrationPage.autoGeneratedSurname();
        String name = RegistrationPage.autoGeneratedName();
        String email = RegistrationPage.autoGeneratedEmail();
        String password1 = RegistrationPage.autoGeneratedPassword1();
        String password2 = RegistrationPage.autoGeneratedPassword2();
        RegistrationPage.registration(surname, name, email, password1, password2);
        String vPWConfMsg = RegistrationPage.validationPWConfMsg();
        assertEquals("Ellenőrizze hogy egyezik e a megadott jelszó.", vPWConfMsg);
    }

    @DisplayName("TC-3  Sikertelen regisztráció teszt - üres adatmezőkkel")
    @Test
    @Order(3)
    public void RegistrationEmptyFieldTest(){
        RegistrationPage.registration("","", "", "", "");
        String vSurnameMsg = RegistrationPage.validationSurnameMsg();
        assertEquals("Ez egy kötelező mező.", vSurnameMsg);
        String vNameMsg = RegistrationPage.validationNameMsg();
        assertEquals("Ez egy kötelező mező.", vNameMsg);
        String vEmailMsg = RegistrationPage.validationEmailMsg();
        assertEquals("Ez egy kötelező mező.", vEmailMsg);
        String vPWMsg = RegistrationPage.validationPWMsg();
        assertEquals("Ez egy kötelező mező.", vPWMsg);
        String vPW2Msg = RegistrationPage.validationPW2Msg();
        assertEquals("Ez egy kötelező mező.", vPW2Msg);
    }
}