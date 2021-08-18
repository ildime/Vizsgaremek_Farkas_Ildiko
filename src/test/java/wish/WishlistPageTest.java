package wish;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SearchPage;
import pages.WishlistPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WishlistPageTest extends BaseTest{

    @DisplayName("Új adat bevitel")
    @Test
    public void wishlistDataTest() {
        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
        SearchPage.dataListSearchToFile("gorgeous");
        WishlistPage.wishlistData();
        String wishlistSendMsg = WishlistPage.wishlistSendMsg();
        assertEquals("Your Wishlist has been shared.", wishlistSendMsg);
        LogoutPage.logoutSuccessful();
    }

//    @DisplayName("Adat vagy adadtok törlése")
//    @Test
//    public void wishlistDataDeleteTest() {
//        LoginPage.loginSuccessful("illusionlessbeauty@gmail.com", "Monster");
//        SearchPage.dataListSearchToFile("gorgeous");
//        WishlistPage.wishlistDataDelet();
//
//
//
//
//        String wishlistSendMsg = WishlistPage.wishlistSendMsg();
//        assertEquals("Your Wishlist has been shared.", wishlistSendMsg);
//        LogoutPage.logoutSuccessful();
//    }

}
