package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExpertAdvicePage {

    static WebDriver driver = Utils.getDriver();

    private static final By NEXT_BUTTON = By.xpath("//*[@class='next']");
    private static final By TITEL = By.xpath("//*[@class='postTitle']");  //*[@id="page-columns"]/div[1]/div[3]/div[1]/div

//    public static void pagination()throws IOException{   //while-true if button active, ha aktív klikk, ha nem break, vagy do-while
//        HomePage.navigateToExpertAdvicePage();
//
//        String ButtonIsActive = driver.findElement(NEXT_BUTTON).getAttribute("class");
//        FileWriter file = new FileWriter("Blogtitel.txt", true);
//        while (!ButtonIsActive.contains("5")) {
//            ButtonIsActive = driver.findElement(NEXT_BUTTON).getAttribute("class");
//            List<WebElement> blogtitels = driver.findElements(TITEL);
//            for (WebElement blogtitel : blogtitels) {
//                System.out.println(blogtitel.getText());
//                String data = blogtitel.getText();
//                file.write(data + "\n");
//            }
//            driver.findElement(NEXT_BUTTON).click();
//        }
//        file.close();
//    }


    public static void pagination(){
        HomePage.navigateToExpertAdvicePage();

        String ButtonIsActive = driver.findElement(NEXT_BUTTON).getAttribute("class");

        ButtonIsActive = driver.findElement(NEXT_BUTTON).getAttribute("class");
        driver.findElement(NEXT_BUTTON).click();
        do{
            List<WebElement> blogtitels = driver.findElements(TITEL);
            for (WebElement blogtitel : blogtitels) {
                System.out.println(blogtitel.getText());
                String data = blogtitel.getText();
                Utils.writeToFile("Blogtitel.txt", data);

            }
        }while (!ButtonIsActive.contains("5"));
    }


}