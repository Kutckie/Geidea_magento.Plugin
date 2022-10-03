package page.Obj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "email")
    private static WebElement emailField;

    @FindBy(id = "pass")
    private static WebElement passwordField;

    @FindBy(id = "send2")
    private static WebElement singInButton;

    @FindBy(xpath = "/html/body/div[3]/div/div/a")
    private static WebElement closePopUpButton;

    public static void inputLogin(String login) {
        emailField.sendKeys(login);
    }

    public static void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public static void clickSingInButton() {
        singInButton.click();
    }

    public static void closePopUp() {
        closePopUpButton.click();
    }
}
