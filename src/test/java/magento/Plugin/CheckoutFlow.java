package magento.Plugin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Obj.*;

import java.time.Duration;


public class CheckoutFlow {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static CheckoutPage checkoutPage;
    public static PaymentPage paymentPage;
    public static CardForm cardForm;
    public static Emulator emulator;

    /**
     * осуществление первоначальной настройки
     **/
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", Configs.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cardForm = new CardForm(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public static void LoginSequence() {
        driver.get(Configs.getProperty("LoginURL"));
        loginPage = new LoginPage(driver);
        LoginPage.inputLogin(Configs.getProperty("login"));
        LoginPage.inputPassword(Configs.getProperty("password"));
        LoginPage.closePopUp();
        LoginPage.clickSingInButton();
    }

    @Test(dependsOnMethods = {"LoginSequence"})
    public static void CartSequence() {
        mainPage = new MainPage(driver);
        MainPage.closePopUp();
        MainPage.addToCartWhite();
        MainPage.addToCartBlack();
    }

    @Test(dependsOnMethods = {"CartSequence"})
    public static void CheckoutSequence() {
        checkoutPage = new CheckoutPage(driver);
        driver.get(Configs.getProperty("CheckoutURL"));
        CheckoutPage.closePopUp();
        CheckoutPage.checkoutNext();
    }

    @Test(dependsOnMethods = {"CheckoutSequence"})
    public static void PaymentSequence() {
        paymentPage = new PaymentPage(driver);
        PaymentPage.selectGeideaPaymentMethod();
        PaymentPage.continuePayment();
    }

    @Test(dependsOnMethods = {"PaymentSequence"})
    public static void CardFormSequence() {
        cardForm = new CardForm(driver);
        CardForm.inputCardNumber(Configs.getProperty("cardNumber"));
        CardForm.inputCVVNumber(Configs.getProperty("CVV"));
        CardForm.inputExpirationDate(Configs.getProperty("expiryDate"));
        CardForm.inputOwnerName(Configs.getProperty("ownerName"));
        CardForm.clickSubmitPaymentButton();
    }

    @Test(dependsOnMethods = {"CardFormSequence"})
    public static void EmulatorSubmition() {
        emulator = new Emulator(driver);
        driver.switchTo().frame(driver.findElement(By.id("redirectTo3ds1Frame")));  //iframe switching
        Emulator.emulatorSubmit();
    }


   /* @AfterClass
    public void tearDown() {
    } **/
}