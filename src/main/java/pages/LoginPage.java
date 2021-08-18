package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

//  Mail illusionlessbeauty@gmail.com
//  PW   Monster

public class LoginPage {

    private static final By EMAIL = By.id("email");
    private static final By PASSWORD = By.id("pass");
    private static final By LOGIN_BUTTON = By.id("send2");
    private static final By ERROR_LOGIN_MESSAGE = By.xpath("//*[@class='error-msg']");
    private static final By VALIDATION_ADVICE_E = By.id("advice-required-entry-email");
    private static final By VALIDATION_ADVICE_PW = By.id("advice-required-entry-pass");
    public static final By REGISTRATION_BUTTON = By.xpath("//*[@class='new-users grid12-6']/div[2]/button");


    public static void loginSuccessful(String username, String password){
        HomePage.navigateToLoginPage();
        Utils.writeText(EMAIL, username);
        Utils.writeText(PASSWORD, password);
        Utils.click(LOGIN_BUTTON);
    }

    public static void loginInvalidPassword(String username, String password){
        HomePage.navigateToLoginPage();
        Utils.writeText(EMAIL, username);
        Utils.writeText(PASSWORD, password);
        Utils.click(LOGIN_BUTTON);
    }

    public static void loginInvalidEmail(String username, String password){
        HomePage.navigateToLoginPage();
        Utils.writeText(EMAIL, username);
        Utils.writeText(PASSWORD, password);
        Utils.click(LOGIN_BUTTON);
    }

    public static void loginInvalidEmptyE(String username, String password){
        HomePage.navigateToLoginPage();
        Utils.writeText(EMAIL, username);
        Utils.writeText(PASSWORD, password);
        Utils.click(LOGIN_BUTTON);
    }

    public static void loginInvalidEmptyPW(String username, String password){
        HomePage.navigateToLoginPage();
        Utils.writeText(EMAIL, username);
        Utils.writeText(PASSWORD, password);
        Utils.click(LOGIN_BUTTON);
    }

    public static String loginErrorMsg(){
        String errorMsg = Utils.getText(ERROR_LOGIN_MESSAGE);
        return errorMsg;
    }

    public static String loginValidationEMsg(){
        String validationEMsg = Utils.getText(VALIDATION_ADVICE_E);
        return validationEMsg;
    }

    public static String loginValidationPWMsg(){
        String validationPWMsg = Utils.getText(VALIDATION_ADVICE_PW);
        return validationPWMsg;
    }
}