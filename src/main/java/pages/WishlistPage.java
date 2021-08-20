package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class WishlistPage {

    static WebDriver driver = Utils.getDriver();

    public static final By ITEMS = By.xpath("//*[@class='product-name']");
    public static final By STRESSLESS_TO_WISHLIST = By.xpath("//*[contains(@href,'form_key')]");
    public static final By DESCIPTRION_BOX = By.xpath("//*[@onfocus='focusComment(this)']");
    public static final By TO_SHARE_BUTTON = By.xpath("//*[@class='button btn-share']");
    public static final By EMAIL_TO_SHARE = By.id("email_address");
    public static final By MESSAGE_TO_SHARE = By.id("message");
    public static final By WISHLIST_SUBMIT_BUTTON = By.xpath("//*[@class='buttons-set form-buttons']/button");
    public static final By WISHLIST_SEND_MESSAGE = By.xpath("//*[@class='success-msg']");
    public static final By WISHLIST_UPDATE = By.xpath("//*[@class='button btn-update']");
    public static final By ITEM_REMOVE = By.xpath("//*[@class='btn-remove']");
    public static final By WISHLIST_EMPTY = By.xpath("//*[@class='wishlist-empty']");

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
        Utils.clear(DESCIPTRION_BOX);
        Utils.writeText(DESCIPTRION_BOX, "Nem egy szerep vagy amit magadra veszel\n" +
                "Nem te vagy a gyerek se, és nem te öregszel\n" +
                "Nem az vagy ami gyűlöl, ami irigy, ami öl\n" +
                "Az se ami elhagy, letilt és kitöröl\n" +
                "Nem egy szám vagy, nem a bőr szín, se a jó és se a rossz\n" +
                "Ami vagy az nem a jövő, nem a múlt, az csak a most\n" +
                "Nem az vagy amit tettél, bár azért te felelsz\n" +
                "Amit nem engedsz el itt, az téged temet el....");
        Utils.click(WISHLIST_UPDATE);
    }

    public static void wishlistDataDelete(){
        Utils.clear(DESCIPTRION_BOX);
    }

    public static void itemRemove(){
        Utils.click(ITEM_REMOVE);
        driver.switchTo().alert().accept();
    }

    public static String wishlistEmpty(){
        String wishlistEmptyMsg = Utils.getText(WISHLIST_EMPTY);
        return wishlistEmptyMsg;
    }
}