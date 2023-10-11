package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProductPage;
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

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        addProductPage = new AddProductPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testCart(){
        driver.get("https://shop.demoqa.com/shop/");
        addProductPage.chooseProduct();
        Assert.assertEquals(addProductPage.getTxtProduct(), "BLACK CROSS BACK MAXI DRESS - BEIGE");
        System.out.println("Test valid add product");
    }
}
