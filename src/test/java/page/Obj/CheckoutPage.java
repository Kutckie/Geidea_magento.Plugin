package page.Obj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/div/button")
    private static WebElement checkoutNextButton;

    @FindBy(xpath = "/html/body/div[3]/div/div/a")
    private static WebElement closePopUpButton;

    public static void checkoutNext() {
        checkoutNextButton.click();
    }

    public static void closePopUp() {
        closePopUpButton.click();
    }
}