package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy (css = "a[href*='rt=checkout/cart']")
    private WebElement checkoutCartLink;

    @FindBy (id = "block_frame_featured_1769")
    private WebElement featuredProductsBlockFrame;

    @FindBy (css = ".prdocutname")
    private List<WebElement> productNamesLinks;


    public List<String> getProductNames(){
        List<String> productNames = new ArrayList<>();
        for(WebElement nameLink : productNamesLinks){
            scrollToElement(nameLink);
            String linkText = nameLink.getText();
            productNames.add(linkText);
        }
        return productNames;
    }

    public ProductDetailsPage clickFirstProduct() {
        for(WebElement nameLink : productNamesLinks) {
            scrollToElement(nameLink);
        }
        productNamesLinks.get(0).click();
        return new ProductDetailsPage(driver);
    }

}
