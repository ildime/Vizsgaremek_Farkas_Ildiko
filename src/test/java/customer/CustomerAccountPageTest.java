package customer;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.CustomerAccountPage;
import pages.LoginPage;
import pages.LogoutPage;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerAccountPageTest extends BaseTest {

    @DisplayName("Ismételt és sorozatos adatbevitel adatforrásból - Profil kitöltés")
    @Test
    public void addressDataTest() {
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        CustomerAccountPage.addressData();
        CustomerAccountPage.fillData();
    }


    @DisplayName("Meglévő adat módosítása - Jelszó módosítása")
    @Test
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

    @DisplayName("Meglévő adat módosítása - Sikertelen jelszó módosítás")
    @Test
    public void changePasswordInvalidTest(){
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        CustomerAccountPage.changePasswordInvalid("Monster", "Beauty", "beauty");
        String invalidPWMsg = CustomerAccountPage.changePasswordInvaligPWMsg();
        assertEquals("Ellenőrizze hogy egyezik e a megadott jelszó.", invalidPWMsg);
        LogoutPage.logoutSuccessful();
    }


}
