package pages;

import org.openqa.selenium.By;
import utils.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerAccountPage {

    public static final By WELCOME = By.xpath("//*[@class='hello']");
    public static final By SUCCESS_MSG = By.xpath("//*[@class='success-msg']");
    public static final By ADDRESS_MODIFY = By.xpath("//*[@class='col-1']//address/a");
    public static final By COMPANY = By.id("company");
    public static final By TELEPHONE = By.id("telephone");
    public static final By FAX = By.id("fax");
    public static final By STREET_1 = By.id("street_1");
    public static final By STREET_2 = By.id("street_2");
    public static final By CITY = By.id("city");
    public static final By ZIP = By.id("zip");
    public static final By REGION = By.id("region");
    public static final By SAVE_ADDRESS_BUTTON = By.xpath("//*[@class='buttons-set']/button");
    public static final By ADDRESS_SAVED_MESSAGE= By.xpath("//*[@class='success-msg']");
    public static final By CHANGE_PASSWORD = By.xpath("//*[@class='box']/div[2]/p/a");
    public static final By CURRENT_PASSWORD = By.id("current_password");
    public static final By CHANGE_PW_CHECKBOX = By.xpath("//*[@class='control']");
    public static final By NEW_PASSWORD = By.id("password");
    public static final By NEW_PASSWORD_CONFIRMATION = By.id("confirmation");
    public static final By PASSWORD_SAVE_BUTTON = By.xpath("//*[@class='buttons-set']/button");
    public static final By SUCCESSFUL_MESSAGE = By.xpath("//*[@class='success-msg']");
    public static final By VALIDATION_ADVICE = By.id("advice-validate-cpassword-confirmation");


    public static void addressData() {
        Utils.click(ADDRESS_MODIFY);
        Utils.clear(COMPANY);
        Utils.clear(TELEPHONE);
        Utils.clear(FAX);
        Utils.clear(STREET_1);
        Utils.clear(STREET_2);
        Utils.clear(CITY);
        Utils.clear(ZIP);
        Utils.clear(REGION);
    }

    public static String[] readAddress() {
        String[] result = new String[8];
        try {
            File myData = new File("Address.txt");
            Scanner scanner = new Scanner(myData);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] temp = new String[8];
                temp = data.split(" = ");
                if (temp[0].equals("company")) {
                    result[0] = temp[1];
                } else if (temp[0].equals("telephone")) {
                    result[1] = temp[1];
                } else if (temp[0].equals("fax")) {
                    result[2] = temp[1];
                } else if (temp[0].equals("street_1")) {
                    result[3] = temp[1];
                } else if (temp[0].equals("street_2")) {
                    result[4] = temp[1];
                } else if (temp[0].equals("city")) {
                    result[5] = temp[1];
                } else if (temp[0].equals("zip")) {
                    result[6] = temp[1];
                } else if (temp[0].equals("region")) {
                    result[7] = temp[1];
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void fillData() {
        String[] data = readAddress();
        Utils.writeText(COMPANY, data[0]);
        Utils.writeText(TELEPHONE, data[1]);
        Utils.writeText(FAX, data[2]);
        Utils.writeText(STREET_1, data[3]);
        Utils.writeText(STREET_2, data[4]);
        Utils.writeText(CITY, data[5]);
        Utils.writeText(ZIP, data[6]);
        Utils.writeText(REGION, data[7]);
        Utils.click(SAVE_ADDRESS_BUTTON);
    }

    public static String addressSavedMsg(){
        String addressSavedMsg = Utils.getText(ADDRESS_SAVED_MESSAGE);
        return addressSavedMsg;
    }

    public static void changePassword(String password, String newpassword1, String newpassword2) {
        Utils.click(CHANGE_PASSWORD);
        Utils.writeText(CURRENT_PASSWORD, password);
        Utils.click(CHANGE_PW_CHECKBOX);
        Utils.writeText(NEW_PASSWORD, newpassword1);
        Utils.writeText(NEW_PASSWORD_CONFIRMATION, newpassword2);
        Utils.click(PASSWORD_SAVE_BUTTON);
    }

    public static String changePasswordValidationPWMsg() {
        String validationPWMsg = Utils.getText(SUCCESSFUL_MESSAGE);
        return validationPWMsg;
    }

    public static void changePasswordInvalid(String password, String newpassword1, String newpassword2) {
        Utils.click(CHANGE_PASSWORD);
        Utils.writeText(CURRENT_PASSWORD, password);
        Utils.click(CHANGE_PW_CHECKBOX);
        Utils.writeText(NEW_PASSWORD, newpassword1);
        Utils.writeText(NEW_PASSWORD_CONFIRMATION, newpassword2);
        Utils.click(PASSWORD_SAVE_BUTTON);
    }

    public static String changePasswordInvalidPWMsg() {
        String invalidPWMsg = Utils.getText(VALIDATION_ADVICE);
        return invalidPWMsg;
    }
}