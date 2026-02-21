package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends BaseTest {

    private final String login = "LevEydelkind";
    private final String password = "29061983";
    private final String wrongPassword = "wrong";
    private final String email = "murmur@miaou.com";
    String randomEmail = "test" + System.currentTimeMillis() + "@mail.com";
    String randomLogin = "Musa" + System.currentTimeMillis() / 10101;


    @Test
    public void RegisterNewUserTest(){
        String message = new HomePage(driver)
                .clickLoginOrRegister()
                .clickContinueToFillRegisterForm()
                .fillRegisterForm(randomEmail, randomLogin)
                .clickContinuetoRegister()
                .getMessageText();

        Assert.assertEquals(message, "YOUR ACCOUNT HAS BEEN CREATED!");
    }

    @Test
    public void RegisterWithAlreadyUsedEmailTest(){
        String messsage = new HomePage(driver)
                .clickLoginOrRegister()
                .clickContinueToFillRegisterForm()
                .fillRegisterForm(email, randomLogin)
                .clickContinue()
                .getAlertText();

        Assert.assertTrue(messsage.contains("Error: E-Mail Address is already registered!"));
    }

    @Test
    public void RegisterWithAlreadyUsedLoginTest(){
        String messsage = new HomePage(driver)
                .clickLoginOrRegister()
                .clickContinueToFillRegisterForm()
                .fillRegisterForm(randomEmail, login)
                .clickContinue()
                .getAlertText();

        Assert.assertTrue(messsage.contains("This login name is not available. Try different login name!"));
    }

    @Test
    public void LoginTest(){
        String header = new HomePage(driver)
                .clickLoginOrRegister()
                .loginToAccount(login, password)
                .getHeaderText();

        Assert.assertEquals(header, "MY ACCOUNT");

    }

    @Test
    public void LogoutTest(){
        String logoutMessage = new HomePage(driver)
                .clickLoginOrRegister()
                .loginToAccount(login, password)
                .logout()
                .getLogoutMessageText();

        Assert.assertEquals(logoutMessage, "ACCOUNT LOGOUT");

    }

    @Test
    public void LoginWithWrongPassword(){
        String message = new HomePage(driver)
                .clickLoginOrRegister()
                .loginToAccountWithWrongPassword(login, wrongPassword)
                .getAlertText();

        Assert.assertTrue(message.contains("Error: Incorrect login or password provided."));
    }

}