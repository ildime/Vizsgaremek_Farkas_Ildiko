package pages;

import org.openqa.selenium.By;
import utils.Utils;

public class HomePage {

    private static final By ACCEPT_COOKIES_BUTTON = By.xpath("//*[@class='v-button v-accept']");
    public static final By LOGIN_BUTTON = By.xpath("//*[@class=' last']");
    public static final By NAVIGATE_PRIVACYPOLICY_LINK = By.xpath("//*[@class='block-content']/ul/li[6]");
    public static final By NAVIGATE_EXPERTADVICE_LINK = By.xpath("//*[@id='mainmenu']/ul/li[5]/a");
    public static final By OTHER = By.xpath("//*[@id='mainmenu']/ul/li[4]");
    public static final By READ = By.xpath("//*[@class='category-products']/ul/li[5]/h2");
    public static final By NAVIGATE_BOOK_LINK = By.xpath("//*[@class='product-image-wrapper']");

    public static void clickAcceptCookies(){
        try {
            Utils.click(ACCEPT_COOKIES_BUTTON);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void navigateToLoginPage(){
        Utils.click(LOGIN_BUTTON);
    }

    public static void navigateToPrivacyPolicyPage(){
        Utils.click(NAVIGATE_PRIVACYPOLICY_LINK);
    }

    public static void navigateToExpertAdvicePage(){
        Utils.click(NAVIGATE_EXPERTADVICE_LINK);
    }

    public static void navigateToBookPage(){
        Utils.click(OTHER);
        Utils.click(READ);
        Utils.click(NAVIGATE_BOOK_LINK);
    }

}