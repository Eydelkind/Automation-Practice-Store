package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "AccountFrm_firstname")
    private WebElement firstNameField;

    @FindBy (id = "AccountFrm_lastname")
    private WebElement lastNameField;

    @FindBy (id = "AccountFrm_email")
    private WebElement emailField;

    @FindBy (id = "AccountFrm_telephone")
    private WebElement telephoneField;

    @FindBy (id = "AccountFrm_fax")
    private WebElement faxField;

    @FindBy (id = "AccountFrm_company")
    private WebElement companyField;

    @FindBy (id = "AccountFrm_address_1")
    private WebElement address1Field;

    @FindBy (id = "AccountFrm_address_2")
    private WebElement address2Field;

    @FindBy (id = "AccountFrm_city")
    private WebElement cityField;

    @FindBy (id = "AccountFrm_zone_id")
    private WebElement regionField;

    @FindBy (id = "AccountFrm_postcode")
    private WebElement postcodeField;

    @FindBy (id = "AccountFrm_country_id")
    private WebElement countryField;

    @FindBy (id = "AccountFrm_loginname")
    private WebElement loginNameField;

    @FindBy (id = "AccountFrm_password")
    private WebElement passwordField;

    @FindBy (id = "AccountFrm_confirm")
    private WebElement passwordConfirmField;

    @FindBy (css = "button[title = 'Continue']")
    private WebElement continueButton;

    @FindBy (id = "AccountFrm_newsletter0")
    private WebElement subscribeNoCheckBox;

    @FindBy (id = "AccountFrm_agree")
    private WebElement haveReadAndAgreeCheckBox;

    @FindBy(css = "div.alert-danger")
    private WebElement alert;


    String randomEmail = "test" + System.currentTimeMillis() + "@mail.com";
    String randomLogin = "Musa" + System.currentTimeMillis() / 10101;



    public CreateAccountPage fillRegisterForm(String email, String login){
        type(firstNameField, "Musa");
        type(lastNameField, "Greycat");
        if (email == null){
            type(emailField, randomEmail);
        }
        else {
            type(emailField, email);
        }
        type(telephoneField, "0057");
        type(faxField, "0057");
        type(companyField, "Grey Cat");
        type(address1Field, "Tel Hay 2");
        type(address2Field, "Khaviva Reik 53");
        type(address2Field, "Khaviva Reik 53");
        type(cityField, "Haifa");
        Select country = new Select(countryField);
        country.selectByVisibleText("Israel");
        Select region = new Select(regionField);
        region.selectByVisibleText("Haifa");
        type(postcodeField, "324119");
        if (login == null){
            type(loginNameField, randomLogin);
        }
        else {
            type(loginNameField, login);
        }
        type(passwordField, "miaou");
        type(passwordConfirmField, "miaou");

        return this;
    }

    public AccountCreatedPage clickContinuetoRegister(){
        subscribeNoCheckBox.click();
        haveReadAndAgreeCheckBox.click();
        continueButton.click();
        return new AccountCreatedPage(driver);
    }

    public CreateAccountPage clickContinue(){
        subscribeNoCheckBox.click();
        haveReadAndAgreeCheckBox.click();
        continueButton.click();
        return this;
    }


    public String getAlertText(){
        return alert.getText();

    }
}
