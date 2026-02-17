package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
    private WebElement shoppingCartHeader;

    @FindBy(css = "a[href*='remove=']")
    private List<WebElement> removeButtons;

    public boolean headerIsDisplayed(){
        return shoppingCartHeader.isDisplayed();
    }

    public CartPage removeFirstProduct() {
        removeButtons.get(0).click();
        return this;
    }

}
