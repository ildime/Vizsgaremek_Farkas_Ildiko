package customer;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.CustomerAccountPage;
import pages.LoginPage;
import pages.LogoutPage;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerAccountPageTest extends BaseTest {

    @DisplayName("Ismételt és sorozatos adatbevitel adatforrásból - profil kitöltés")
    @Test
    public void addressDataTest() {
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        CustomerAccountPage.addressData();
        CustomerAccountPage.fillData();
        String addressSavedMsgMsg = CustomerAccountPage.addressSavedMsg();
        assertEquals("The address has been saved.", addressSavedMsgMsg);
        LogoutPage.logoutSuccessful();
    }

    @DisplayName("Meglévő adat módosítása - jelszó módosítása")
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
