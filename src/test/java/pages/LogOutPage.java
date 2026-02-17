package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage {
    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Account Logout']")
    private WebElement accountLogoutMessage;

    public String getLogoutMessageText(){
        String text = accountLogoutMessage.getText();
        return text;
    }
}
