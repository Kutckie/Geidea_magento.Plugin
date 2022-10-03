package page.Obj;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Emulator {

    public WebDriver driver;

    public Emulator(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div/div/div[3]/center/form/table/tbody/tr[13]/td/input")
    private static WebElement submitButton;

    public static void emulatorSubmit(){
        submitButton.click();
    }
}
