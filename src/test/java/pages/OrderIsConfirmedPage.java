package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderIsConfirmedPage extends BasePage {
    public OrderIsConfirmedPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.urlContains("checkout/success"));
    }

    @FindBy (css = "h1.heading1")
    private WebElement orderConfirmationMessage;

    public String getConfirmationMessageText(){
        wait.until(ExpectedConditions.visibilityOf(orderConfirmationMessage));
        return orderConfirmationMessage.getText();
    }
}
