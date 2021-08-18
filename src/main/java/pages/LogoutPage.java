package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class LogoutPage {

    static WebDriver driver = Utils.getDriver();

    private static final By LOGOUT_BUTTON = By.xpath("//*[@class=' last']");

    public static void logoutSuccessful(){
        Utils.click(LOGOUT_BUTTON);
    }

    public static void refreshToLogoutPage(){
        driver.navigate().refresh();
    }
}