package pages;

import org.openqa.selenium.By;
import utils.Utils;

public class WishlistPage {

    public static final By ITEMS = By.xpath("//*[@class='product-name']");
    public static final By STRESSLESS_TO_WISHLIST = By.xpath("//*[contains(@href,'form_key')]");
    public static final By DESCIPTRION_BOX = By.xpath("//*[@onfocus='focusComment(this)']");
    public static final By TO_SHARE_BUTTON = By.xpath("//*[@class='button btn-share']");
    public static final By EMAIL_TO_SHARE = By.id("email_address");
    public static final By MESSAGE_TO_SHARE = By.id("message");
    public static final By WISHLIST_SUBMIT_BUTTON = By.xpath("//*[@class='buttons-set form-buttons']/button");
    public static final By WISHLIST_SEND_MESSAGE = By.xpath("//*[@class='success-msg']");

    public static void wishlistData(){
        Utils.click(ITEMS);
        Utils.click(STRESSLESS_TO_WISHLIST);
        Utils.clear(DESCIPTRION_BOX);
        Utils.writeText(DESCIPTRION_BOX, "Stress less, Wrinkle free");
        Utils.click(TO_SHARE_BUTTON);
        Utils.writeText(EMAIL_TO_SHARE, "geradegenug@gmail.com");
        Utils.writeText(MESSAGE_TO_SHARE, "Merry Christmas? Stress less for Christmas");
        Utils.click(WISHLIST_SUBMIT_BUTTON);
    }

    public static String wishlistSendMsg(){
        String wishlistSendMsg = Utils.getText(WISHLIST_SEND_MESSAGE);
        return wishlistSendMsg;
    }

    public static void wishlistFillData(){
        Utils.click(ITEMS);
        Utils.click(STRESSLESS_TO_WISHLIST);
        Utils.writeText(DESCIPTRION_BOX, "Stress less, Wrinkle free");
    }

    public static void wishlistDataDelete(){
        Utils.clear(DESCIPTRION_BOX);
    }
}
