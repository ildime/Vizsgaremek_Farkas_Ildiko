package utils;

import io.github.bonigarcia.wdm.WebDriverManager;;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Utils {

    static WebDriver driver;
    static WebDriverWait wait;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--no-sandbox");
            //options.addArguments("--disable-dev-shm-usage");
            //options.addArguments("--disable-notifications");
            options.addArguments("--incognito");
            options.addArguments("--headless");
            //options.setHeadless(true);
            //options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://skinsmart.hu/");
            // driver.manage().window().maximize();

        }
        return driver;
    }

    public static WebElement waitVisibility(By by) {
        if (driver != null) {
            wait = new WebDriverWait(driver, 5);
        }
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void click(By by) {
        waitVisibility(by).click();
    }

    public static void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    public static String getText(By by) {
        return waitVisibility(by).getText();
    }

    public static String writeToFile(String filename, String text) {
        try {
            FileWriter textFile = new FileWriter(filename);
            textFile.write(text);
            textFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }return null;
    }

    public static String writeToFileAppend(String filename, String text) {
        try {
            FileWriter textFile = new FileWriter(filename, true);
            textFile.append(text+"\n");
            textFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }return null;
    }

    public static String readFromFile(String filename){
        String data = "";
        try{
            File myFile = new File (filename);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                data += myReader.nextLine() + ("\n");
 //               System.out.println(data);
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return data;
    }

    public static void clear(By by){
        waitVisibility(by).clear();
    }

    public static void enter(By by){
        waitVisibility(by).sendKeys(Keys.ENTER);
    }

    public static boolean clickSelected(String select, By by){
        boolean result = false;
        List<WebElement> parentDiv = driver.findElements(by);
        for(WebElement div: parentDiv){
            if (div.getText().contains(select)){
                div.click();
                result = true;
            }
        } return result;
    }
}