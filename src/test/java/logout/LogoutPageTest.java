package logout;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import utils.Utils;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutPageTest extends BaseTest {

    private WebDriver driver;

    public LogoutPageTest(WebDriver driver) {
        this.driver = driver;
    }

    @Step("TakeScreenshot")
    public void TakeScreenshot(WebDriver driver){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }

    @DisplayName("Sikeres kijeletkezés teszt")
    @Test
    public void LogoutTest(){
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        LogoutPage.logoutSuccessful();
        LogoutPage.refreshToLogoutPage();
        TakeScreenshot(driver);
        assertEquals("Bejelentkezés", Utils.waitVisibility(HomePage.LOGIN_BUTTON).getText());
    }
}