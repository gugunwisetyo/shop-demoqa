package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProductPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductTest {

    private WebDriver driver;

    private AddProductPage addProductPage;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        addProductPage = new AddProductPage();
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testAddProduct(){
        driver.get("https://shop.demoqa.com/shop/");
        addProductPage.chooseProduct();
        addProductPage.chooseProductTwo();
        String expectedValue1 = "Cart(2)";
        String expectedValue2 = "₹39.00";
        boolean bothValuePresent = addProductPage.getCartCount().contains(expectedValue1) && addProductPage.getCartCount().contains(expectedValue2);
        Assert.assertTrue(bothValuePresent, "Both value present");
        System.out.println("Terdapat 2 produk dalam Shopping Cart");
    }

    @Test(priority = 2)
    public void testInvalidCheckout(){
        addProductPage.checkoutBtn();
        addProductPage.checkout();
        Assert.assertEquals(addProductPage.getTxtUncheckTnc(), "Please read and accept the terms and conditions to proceed with your order.");
        System.out.println("Test incomplete checkout requirements");
    }

    @Test(priority = 3)
    public void testCheckout(){
//        driver.switchTo().alert().dismiss();
        DriverSingleton.delay(2);
        addProductPage.checkTnc();
        Assert.assertEquals(addProductPage.getTxtOrderDone(),"Thank you. Your order has been received.");
        System.out.println("Test valid checkout");
    }
}
