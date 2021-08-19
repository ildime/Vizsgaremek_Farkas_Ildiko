package wish;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SearchPage;
import pages.WishlistPage;
import utils.Utils;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

public class WishlistPageTest extends BaseTest{

    static WebDriver driver = Utils.getDriver();

    @Step("TakeScreenshot")
    public void TakeScreenshot(WebDriver driver){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @DisplayName("Új adat bevitel")
    @Test
    public void wishlistDataTest() {
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        SearchPage.searchKeyword("gorgeous");
        WishlistPage.wishlistData();
        String wishlistSendMsg = WishlistPage.wishlistSendMsg();
        assertEquals("Your Wishlist has been shared.", wishlistSendMsg);
        WishlistPage.itemRemove();
        LogoutPage.logoutSuccessful();
    }

    @DisplayName("Adat vagy adatok törlése")
    @Test
    public void wishlistDataDeleteTest() {
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        SearchPage.searchKeyword("gorgeous");
        WishlistPage.wishlistFillData();
        TakeScreenshot(driver);
        WishlistPage.wishlistDataDelete();
        TakeScreenshot(driver);
        WishlistPage.itemRemove();
        TakeScreenshot(driver);
        String wishlistEmpty = WishlistPage.wishlistEmpty();
        assertEquals("Még nem raktál kívánságlistába egy terméket sem.", wishlistEmpty);
        LogoutPage.logoutSuccessful();
    }
}