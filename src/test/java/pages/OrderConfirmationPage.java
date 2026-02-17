package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage
{
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout_btn")
    private WebElement confirmButton;

    public OrderIsConfirmedPage confirmOrder(){
        confirmButton.click();
        return new OrderIsConfirmedPage(driver);
    }
}
