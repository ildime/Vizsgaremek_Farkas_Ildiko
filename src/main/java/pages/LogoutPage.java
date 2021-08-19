package pages;

import org.openqa.selenium.By;
import utils.Utils;

public class LogoutPage {

    private static final By LOGOUT_BUTTON = By.xpath("//*[@class=' last']");

    public static void logoutSuccessful(){
        Utils.click(LOGOUT_BUTTON);
    }
}