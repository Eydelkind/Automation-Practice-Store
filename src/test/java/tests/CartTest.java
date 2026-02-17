package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;


public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        boolean isCartHeaderDisplayed = new HomePage(driver)
                .clickFirstProduct()
                .enterProductQuantity()
                .addToCart()
                .headerIsDisplayed();


        Assert.assertTrue(isCartHeaderDisplayed);
    }


    @Test
    public void removeProductFromCartTest() {
        int itemsBeforeRemoving = new HomePage(driver)
                .clickFirstProduct()
                .addToCart()
                .getCartItemsCount();

        int itemsAfterRemoving = new HomePage(driver)
                .clickCartLink()
                .removeFirstProduct()
                .getCartItemsCount();

        Assert.assertTrue(itemsBeforeRemoving - itemsAfterRemoving == 1);

    }
}
