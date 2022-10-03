package page.Obj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardForm {

    public WebDriver driver;

    public CardForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"geideaModalForm\"]/div[5]/div[2]/form/div/div[1]/input")
    private static WebElement cardNumberField;

    @FindBy(xpath = "//*[@id=\"geideaModalForm\"]/div[5]/div[2]/form/div/div[2]/div[2]/input")
    private static WebElement cardCVVNumberField;

    @FindBy(xpath = "//*[@id=\"geideaModalForm\"]/div[5]/div[2]/form/div/div[2]/div[1]/input")
    private static WebElement cardExpirationDateField;

    @FindBy(xpath = "//*[@id=\"geideaModalForm\"]/div[5]/div[2]/form/div/div[3]/input")
    private static WebElement cardOwnerNameField;

    @FindBy(xpath = "//*[@id=\"geideaModalForm\"]/div[6]/button")
    private static WebElement submitPaymentButton;

    public static void inputCardNumber(String cardNumber) {
        cardNumberField.sendKeys(cardNumber);
    }

    public static void inputCVVNumber(String CVV) {
        cardCVVNumberField.sendKeys(CVV);
    }

    public static void inputExpirationDate(String expiryDate) {
        cardExpirationDateField.sendKeys(expiryDate);
    }

    public static void inputOwnerName(String ownerName) {
        cardOwnerNameField.sendKeys(ownerName);
    }

    public static void clickSubmitPaymentButton(){
        submitPaymentButton.click();
    }
}
