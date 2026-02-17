package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.LogOutPage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    @FindBy(css = "ul.nav span.label")
    private List<WebElement> headerLabels;

    @FindBy (css = "a[href*='rt=checkout/shipping']")
    private WebElement checkOutLink;

    @FindBy (css = "a[href*='rt=account/login']")
    private WebElement loginOrRegisterLink;

    @FindBy(xpath = "//span[normalize-space()='Cart']")
    private WebElement cartLink;

    @FindBy(xpath = "//span[normalize-space()='Account']")
    private WebElement accountMenu;

    @FindBy (css = "a[href*='rt=account/logout']")
    private WebElement logoutLink;



    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public LoginPage clickLoginOrRegister() {
        loginOrRegisterLink.click();
        return new LoginPage(driver);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    protected void type(WebElement element, String text) {
        scrollToElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public int getCartItemsCount() {
        for (WebElement label : headerLabels) {
            wait.until(ExpectedConditions.visibilityOf(label));
        }

        WebElement cartCounter = headerLabels.get(1);
        return Integer.parseInt(cartCounter.getText().trim());
    }

    public LoginPage clickCheckOutLink(){
        checkOutLink.click();
        return new LoginPage(driver);
    }

    public CartPage clickCartLink(){
        cartLink.click();
        return new CartPage(driver);
    }


    public LogOutPage logout(){

        Actions actions = new Actions(driver);
        actions.moveToElement(accountMenu).perform();
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", logoutLink);

        return new LogOutPage(driver);
    }

}
