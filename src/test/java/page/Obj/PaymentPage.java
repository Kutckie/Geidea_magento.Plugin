package page.Obj;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaymentPage {

    public static WebDriver driver;


    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[3]/main/div/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div[2]/div[2]/div[1]/input")
    private static WebElement GeideaPaymentMethodCheckBox;

    @FindBy(xpath = "/html/body/div[3]/main/div/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div[1]/div[3]/div[1]/input")
    private static WebElement VisaPaymentMethodCheckBox;

    @FindBy(xpath = "/html/body/div[3]/main/div/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div[2]/div[2]/div[2]/div[5]/div/button")
    private static WebElement ContinuePaymentButton;


    public static void selectGeideaPaymentMethod(){
        GeideaPaymentMethodCheckBox.click();
    }

    public static void selectVisaPaymentMethod(){
        VisaPaymentMethodCheckBox.sendKeys(Keys.SPACE);
    }

    public static void continuePayment(){
        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click()", ContinuePaymentButton); //wait for element load
    }
}
