package pages;

import org.openqa.selenium.*;
import utils.Utils;

public class PrivacyPolicyPage {

    private static final By PRIVACY_POLICY_TEXT = By.xpath("//*[@id='at14']");

    public static void dataPPSaveToFile(){
        HomePage.navigateToPrivacyPolicyPage();
        String text = PrivacyPolicyPage.PrivacyPolicyText();
        Utils.writeToFile("PrivacyPolicyText.txt", text);
    }

    public static String PrivacyPolicyText(){
        String text = Utils.getText(PRIVACY_POLICY_TEXT);
        return text;
    }
}