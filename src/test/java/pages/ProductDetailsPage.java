package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.smartcardio.CardTerminal;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1.productname")
    private WebElement header;

    @FindBy (id = "description")
    WebElement productDescription;

    @FindBy (id = "product_quantity")
    private WebElement productQuanityField;

    @FindBy (xpath = "//a[normalize-space()='Add to Cart']")
    private WebElement addToCartButton;


    public String getHeaderText(){
        return header.getText();
    }

    public boolean ProductDescriptionIsDisplayed(){
        return productDescription.isDisplayed();
    }

    public ProductDetailsPage enterProductQuantity(){
        productQuanityField.clear();
        productQuanityField.sendKeys("2");
        return this;
    }

    public CartPage addToCart(){
        addToCartButton.click();
        return new CartPage(driver);
    }
}
