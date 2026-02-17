package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[title = 'Continue']")
    private WebElement continueButton;

    @FindBy (id = "loginFrm_loginname")
    private WebElement loginField;

    @FindBy (id = "loginFrm_password")
    private WebElement passwordField;

    @FindBy (css = "button[title='Login']")
    private WebElement loginButton;

    @FindBy (css = "div.alert-danger")
    private WebElement alert;


    public CreateAccountPage clickContinueToFillRegisterForm(){
        continueButton.click();
        return new CreateAccountPage(driver);
    }

    public AccountPage loginToAccount(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        return new AccountPage(driver);

    }

    public OrderConfirmationPage loginToAccountToConfirmOrder(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        return new OrderConfirmationPage(driver);

    }

    public LoginPage loginToAccountWithWrongPassword(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        return this;

    }

    public String getAlertText(){
        return alert.getText();
    }

}
