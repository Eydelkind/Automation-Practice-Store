package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[normalize-space()='Your Account Has Been Created!']")
    private WebElement accountCreatedMessage;

    public String getMessageText(){
        String text = accountCreatedMessage.getText();
        return text;
    }
}
