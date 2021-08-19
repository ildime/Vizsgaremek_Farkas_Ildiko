package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import utils.Utils;


public class BaseTest {   //implement TestWatcher?

    WebDriver driver;

//    @BeforeAll
//    public static void init() {
//
//    }


    @BeforeEach
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        //options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--incognito");
        //options.setHeadless(true);
        //options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
        // driver.manage().window().maximize();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        //options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--proxy-server='direct://");
        //options.addArguments("--proxy-bypass-list=*");
        //options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.get("https://skinsmart.hu/");
        HomePage.clickAcceptCookies();
    }

    @AfterEach
    public void Close(){driver.close();}

//    @AfterAll  //kilép az összes teszt után
//    public static void quitDriver(){driver.quit();}
}
