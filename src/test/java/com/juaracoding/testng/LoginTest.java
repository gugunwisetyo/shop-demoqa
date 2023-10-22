package com.juaracoding.testng;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        loginPage.scroll(0,500);
        loginPage.doLogin("gugunwisetyo", "@JuaraCoding");
        loginPage.scroll(0,500);
        Assert.assertEquals(loginPage.getTxtLogin(), "Hello gugunwisetyo (not gugunwisetyo? Log out)");
        System.out.println("Test valid login");
    }

    @Test(priority = 2)
    public void testValidLogout(){
        loginPage.doLogout();
        loginPage.scroll(0,500);
        Assert.assertEquals(loginPage.getTxtLogout(), "USERNAME OR EMAIL ADDRESS *");
        System.out.println("Test valid logout");
    }

    @Test(priority = 3)
    public void testInvalidUsername(){
        loginPage.doLogin("gugunwise", "@JuaraCoding");
        loginPage.scroll(0,500);
        Assert.assertEquals(loginPage.getTxtError(), "Lost your password");
        System.out.println("Test invalid username");
    }

    @Test(priority = 4)
    public void testBlankPassword(){
        loginPage.clearUser();
        loginPage.clearPass();
        loginPage.doLogin("gugunwisetyo", "");
        loginPage.scroll(0,500);
        Assert.assertEquals(loginPage.getTxtError2(), "Error:");
        System.out.println("Test blank password");
    }
}
