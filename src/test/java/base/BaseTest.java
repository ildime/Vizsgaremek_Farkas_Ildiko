package base;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.Utils;


public class BaseTest {   //implement TestWatcher?

    static WebDriver driver;

    @BeforeAll
    public static void init() {
        driver = Utils.getDriver();
    }

    @BeforeEach
    public void Setup() {
        driver.get("https://skinsmart.hu/");
        HomePage.clickAcceptCookies();
    }

//    @AfterEach
//    public void Close(){driver.close();}

//    @AfterAll  //kilép az összes teszt után
//    public static void quitDriver(){driver.quit();}
}
