package page.Obj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public static WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[3]/div/div/a")
    private static WebElement closePopUpButton;

    @FindBy(xpath = "//*[@id=\"filterproducts_0\"]/div/div[1]/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[1]/form/button")
    private static WebElement addToCartWhiteButton;

    @FindBy(xpath = "//*[@id=\"filterproducts_0\"]/div/div[1]/div[1]/div/div[2]/div/div/div[2]/div[2]/div/div[1]/form/button")
    private static WebElement addToCartBlackButton;

    @FindBy(id = "top-cart-btn-checkout")
    private static WebElement proceedToCheckoutButton;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div[2]/div/div/div[2]/div/div[4]/div/a")
    private static WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]")
    private static WebElement checkoutButton;

    public static void closePopUp() {
        closePopUpButton.click();
    }

    public static void addToCartWhite() {
        addToCartWhiteButton.click();
    }

    public static void addToCartBlack() {
        addToCartBlackButton.click();
    }

    public static void checkoutButton() {
        proceedToCheckoutButton.click();
    }

    public static void hoverCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(cartButton).perform();
        hover.moveToElement(checkoutButton).click().perform();
    }

}
