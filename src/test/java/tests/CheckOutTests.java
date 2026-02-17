package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class CheckOutTests extends BaseTest {

    private final String login = "LevEydelkind";
    private final String password = "29061983";

    @Test
    public void checkOutTest(){
        String confirmation = new HomePage(driver)
                .clickFirstProduct()
                .addToCart()
                .clickCheckOutLink()
                .loginToAccountToConfirmOrder(login, password)
                .confirmOrder()
                .getConfirmationMessageText();


        Assert.assertEquals(confirmation, "YOUR ORDER HAS BEEN PROCESSED!");

    }
}
