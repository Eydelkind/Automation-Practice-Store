package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;

public class CatalogTests extends BaseTest {

    @Test
    public void ProductsArePresentOnHomePage(){
        List<String> productNames = new HomePage(driver)
                .getProductNames();

        Assert.assertTrue(productNames.size() > 0);

    }

    @Test
    public void productDetailsPageOpensCorrectlyTest() {

        String nameInCatalog = new HomePage(driver)
                .getProductNames().get(0);

        String productName = new HomePage(driver)
                .clickFirstProduct()
                .getHeaderText();

        Assert.assertEquals(productName.toUpperCase(), nameInCatalog.toUpperCase());
    }

    @Test
    public void ProductDescriptionIsDisplayedTest(){
        boolean descriptionIsDisplayed = new HomePage(driver)
                .clickFirstProduct()
                .ProductDescriptionIsDisplayed();

        Assert.assertTrue(descriptionIsDisplayed);
    }


}
