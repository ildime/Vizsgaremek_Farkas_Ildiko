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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishlistPageTest extends BaseTest{

    @DisplayName("Új adat bevitel")
    @Test
    public void wishlistDataTest() {
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        SearchPage.searchKeyword("gorgeous");
        WishlistPage.wishlistData();
        String wishlistSendMsg = WishlistPage.wishlistSendMsg();
        assertEquals("Your Wishlist has been shared.", wishlistSendMsg);
        LogoutPage.logoutSuccessful();
    }

    static WebDriver driver = Utils.getDriver();

//    @Step("TakeScreenshot")
//    public void TakeScreenshot(WebDriver driver){
//        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//        System.out.println(driver.getCurrentUrl());
//    }

    @Step("TakeScreenshot")
    public void TakeScreenshot(WebDriver driver){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        assertTrue(true);
    }

    @DisplayName("Adat vagy adadtok törlése")
    @Test
    public void wishlistDataDeleteTest() {
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        SearchPage.searchKeyword("gorgeous");
        WishlistPage.wishlistFillData();
        TakeScreenshot(driver);
        WishlistPage.wishlistDataDelete();
        TakeScreenshot(driver);
        LogoutPage.logoutSuccessful();
    }
}