package com.juaracoding.cucumber;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProductPage;
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

import javax.swing.*;

public class TestAddProduct {
    private static WebDriver driver;

    private static AddProductPage addProductPage;
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL2);
        addProductPage = new AddProductPage();
        loginPage = new LoginPage();
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Given("user enter url shop")
    public void user_enter_url_shop(){
        driver.get(Constants.URL2);
    }

    @When("user choose first product")
    public void user_choose_first_product(){
        loginPage.scroll(0,400);
        addProductPage.selectProductOne();
    }

    @And("user choose color")
    public void user_choose_color(){
        loginPage.scroll(0,400);
        addProductPage.selectColor("Beige");
    }

    @And("user choose size")
    public void user_choose_size(){
        addProductPage.selectSize("Large");
    }

    @And("user click add to cart")
    public void user_click_add_to_cart(){
        addProductPage.selectToCart();
    }

    @And("user back to list product")
    public void user_back_to_list_product(){
        addProductPage.backToProduct();
        loginPage.scroll(0,400);
    }

    @And("user choose second product")
    public void user_choose_second_product(){
        addProductPage.selectProductTwo();
        loginPage.scroll(0,500);
    }

    @And("user click view cart")
    public void user_click_view_cart(){
        addProductPage.selectViewCart();
    }

    @Then("user get text cart")
    public void user_get_text_cart(){
        String expectedValue1 = "Cart(2)";
        String expectedValue2 = "₹39.00";
        boolean bothValuePresent = addProductPage.getCartCount().contains(expectedValue1) && addProductPage.getCartCount().contains(expectedValue2);
        Assert.assertTrue(bothValuePresent, "Both value present");
    }

    @When("user click checkout")
    public void user_click_checkout(){
        addProductPage.checkoutBtn();
    }

    @And("user input first name")
    public void user_input_first_name(){
        loginPage.scroll(0,500);
        addProductPage.firstName();
    }

    @And("user input last name")
    public void user_input_last_name(){
        addProductPage.lastName();
    }

    @And("user choose region")
    public void user_choose_region(){
        addProductPage.fillRegion();
        loginPage.scroll(0,500);
    }

    @And("user input address")
    public void user_input_address(){
        addProductPage.fillAddress();
    }

    @And("user input city")
    public void user_input_city(){
        addProductPage.fillCity();
    }

    @And("user choose province")
    public void user_choose_city(){
        addProductPage.fillProvince();
    }

    @And("user input postcode")
    public void user_input_postcode(){
        addProductPage.fillPostcode();
    }

    @And("user input phone number")
    public void user_input_phone_number(){
        addProductPage.fillPhone();
    }

    @And("user input email")
    public void user_input_email(){
        addProductPage.fillEmail();
    }

    @And("user click place order")
    public void user_click_place_order(){
        addProductPage.selectPlaceOrder();
    }

    @Then("user get text incomplete")
    public void user_get_text_incomplete(){
        Assert.assertEquals(addProductPage.getTxtUncheckTnc(), "Please read and accept the terms and conditions to proceed with your order.");
    }

    @When("user mark check TNC")
    public void user_mark_check_TNC(){
        addProductPage.checklistTNC();
    }

    @Then("user get text order complete")
    public void user_get_text_order_complete(){
        Assert.assertEquals(addProductPage.getTxtOrderDone(), "Thank you. Your order has been received.");
    }
}
