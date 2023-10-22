package com.juaracoding.cucumber;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {

    private static WebDriver driver;

    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginPage = new LoginPage();
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Given("user enter url")
    public void user_enter_url(){
        driver.get(Constants.URL);
    }

    @When("user input valid username")
    public void user_input_valid_username(){
        loginPage.scroll(0,500);
        loginPage.setUsername("gugunwisetyo");
    }

    @And("user input valid password")
    public void user_input_valid_password(){
        loginPage.setPassword("@JuaraCoding");
    }

    @And("user click login button")
    public void user_click_login_button(){
        loginPage.login();
    }

    @Then("user get text login")
    public void user_get_text_hello(){
        loginPage.scroll(0,500);
        Assert.assertEquals(loginPage.getTxtLogin(), "Hello gugunwisetyo (not gugunwisetyo? Log out)");
    }

    @When("user click logout button")
    public void user_click_logout_button(){
        loginPage.doLogout();
    }

    @Then("user get text logout")
    public void user_get_text_logout(){
        loginPage.scroll(0,500);
        Assert.assertEquals(loginPage.getTxtLogout(),"USERNAME OR EMAIL ADDRESS *");
    }

    @Given("user input invalid username")
    public void user_input_invalid_username(){
        loginPage.setUsername("gugunwise");
    }

    @Then("user get text error invalid")
    public void user_get_text_error_invalid(){
        loginPage.scroll(0,500);
        Assert.assertEquals(loginPage.getTxtError(),"Lost your password");
    }

    @Given("user clear username")
    public void user_clear_username(){
        loginPage.clearUser();
    }

    @When("user clear password")
    public void user_clear_password(){
        loginPage.clearPass();
    }

    @And("user input blank password")
    public void user_input_blank_password(){
        loginPage.setPassword("");
    }

    @Then("user get text error blank")
    public void user_get_text_error_blank(){
        loginPage.scroll(0,500);
        Assert.assertEquals(loginPage.getTxtError2(),"Error:");
    }
}