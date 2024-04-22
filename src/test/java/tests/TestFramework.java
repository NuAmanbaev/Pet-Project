package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import utils.Config;
import utils.Driver;

public class TestFramework {

    SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
    SauceDemoProductPage sauceDemoProductPage = new SauceDemoProductPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    ContinuePage continuePage = new ContinuePage();
    OverviewPage overviewPage = new OverviewPage();


    @Before
    public void setUp(){
        Driver.getDriver().get(Config.getProperty("sauceDemo"));
        sauceDemoLoginPage.sauceDemoLoginInputField.sendKeys(Config.getProperty("userName"));
        sauceDemoLoginPage.sauceDemoPasswordInputField.sendKeys(Config.getProperty("password"));
        sauceDemoLoginPage.sauceDemoLoginButton.click();
    }



    @Test
    public void testNavigate(){
        Assert.assertEquals(Config.getProperty("sauceDemo"),Driver.getDriver().getCurrentUrl());



    }



    @Test
    public void loginTest(){
        Assert.assertEquals("https://www.saucedemo.com/inventory.html",Driver.getDriver().getCurrentUrl());

    }

    @Test
    public void  loginTestV2(){
        Assert.assertEquals(Config.getProperty("expectedUrl"),Driver.getDriver().getCurrentUrl());

    }

    @Test
    public void addToCart(){
        sauceDemoProductPage.backPack.click();
        Assert.assertTrue(sauceDemoProductPage.addedToCart.isDisplayed());


    }

    @Test
    public void testCart(){
        sauceDemoProductPage.backPack.click();
        Assert.assertTrue(sauceDemoProductPage.one.isDisplayed());
    }

    @Test
    public void  testCartTwo(){
        sauceDemoProductPage.backPack.click();
        sauceDemoProductPage.bikeLight.click();
       Assert.assertTrue( sauceDemoProductPage.two.isDisplayed());

    }

    @Test
    public void testCartPage(){
        sauceDemoProductPage.backPack.click();
        sauceDemoProductPage.cartButton.click();
        Assert.assertEquals(Config.getProperty("cartUrl"),Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void  testCheckoutPage(){
        sauceDemoProductPage.tShirt.click();
        Assert.assertTrue(sauceDemoProductPage.one.isDisplayed());
        sauceDemoProductPage.cartButton.click();
        Assert.assertEquals(Config.getProperty("cartUrl"),Driver.getDriver().getCurrentUrl());
        checkOutPage.checkoutButton.click();
        Assert.assertEquals(Config.getProperty("checkOutUrl"),Driver.getDriver().getCurrentUrl());


    }

    @Test
    public void E2E(){

        sauceDemoProductPage.onesie.click();
        Assert.assertTrue(sauceDemoProductPage.one.isDisplayed());
        sauceDemoProductPage.cartButton.click();
        Assert.assertEquals(Config.getProperty("cartUrl"),Driver.getDriver().getCurrentUrl());
        Assert.assertTrue(checkOutPage.checkoutButton.isDisplayed());
        checkOutPage.checkoutButton.click();
        Assert.assertEquals(Config.getProperty("checkOutUrl"),Driver.getDriver().getCurrentUrl());
        Assert.assertTrue(continuePage.continueButton.isDisplayed());
        continuePage.continueButton.click();
        Assert.assertTrue(continuePage.errorMessage.isDisplayed());
        continuePage.firstNameInputField.sendKeys("Huesos");
        continuePage.lastNameInputField.sendKeys("Dalbaeb");
        continuePage.postalCodeInputField.sendKeys("606-56");
        continuePage.continueButton.click();
        Assert.assertEquals(Config.getProperty("overview"),Driver.getDriver().getCurrentUrl());
        Assert.assertTrue(overviewPage.finalProduct.isDisplayed());
        Assert.assertTrue(overviewPage.finishButton.isDisplayed());
        overviewPage.finishButton.click();
        Assert.assertEquals(Config.getProperty("complateUrl"),Driver.getDriver().getCurrentUrl());






    }


    @After
    public void cleanUp(){
        Driver.quit();
    }



}
