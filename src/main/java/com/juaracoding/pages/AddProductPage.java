package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage extends LoginPage{

    private WebDriver driver;

    public AddProductPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator add product

    @FindBy(xpath = "//a[normalize-space()='Black Cross Back Maxi Dress']")
    private WebElement productOne;

    @FindBy(xpath = "//a[normalize-space()='black lux graphic t-shirt']")
    private WebElement productTwo;

    @FindBy(xpath = "//select[@id='pa_color']")
    private WebElement chooseColor;

    @FindBy(xpath = "//select[@id='pa_size']")
    private WebElement chooseSize;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    private WebElement viewCart;

    @FindBy(xpath = "//a[normalize-space()='Black Cross Back Maxi Dress - Beige']")
    private WebElement cartOne;

    @FindBy(xpath = "//a[normalize-space()='black lux graphic t-shirt - Black']")
    private WebElement cartTwo;

    @FindBy(xpath = "//a[@title='Go to Products.']")
    private WebElement goToProduct;

    @FindBy(xpath = "//span[@class='cart-name-and-total']")
    private WebElement cartCount;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    private WebElement fillFirstName;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    private WebElement fillLastName;

    @FindBy(xpath = "//span[@id='select2-billing_country-container']")
    private WebElement region;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement chooseRegion;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    private WebElement address;

    @FindBy(xpath = "//input[@id='billing_city']")
    private WebElement city;

    @FindBy(xpath = "//span[@id='select2-billing_state-container']")
    private WebElement province;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement chooseProvince;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    private WebElement postcode;

    @FindBy(xpath = "//input[@id='billing_phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@id='billing_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='terms']")
    private WebElement tnc;

    @FindBy(xpath = "//button[@id='place_order']")
    private WebElement placeOrder;

    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    private WebElement txtOrderDone;

    @FindBy(xpath = "//li[contains(text(),'Please read and accept the terms and conditions to')]")
    private WebElement txtUncheckTnc;

    public void chooseProduct(){
        scroll(0,400);
        this.productOne.click();
        scroll(0,400);
        this.chooseColor.sendKeys("Beige");
        this.chooseSize.sendKeys("Large");
        this.addToCart.click();
//        this.viewCart.click();
//        scroll(0,400);
    }

    public void chooseProductTwo(){
        this.goToProduct.click();
        scroll(0,400);
        this.productTwo.click();
        scroll(0,500);
        this.chooseColor.sendKeys("Black");
        this.chooseSize.sendKeys("32");
        this.addToCart.click();
        this.viewCart.click();
    }

    public void checkoutBtn(){
        scroll(0,900);
        this.checkoutBtn.click();
    }

    public void checkout(){
        scroll(0,500);
        this.fillFirstName.sendKeys("Gugun");
        this.fillLastName.sendKeys("Wisetyo");
        this.region.click();
        this.chooseRegion.sendKeys("indo");
        this.chooseRegion.sendKeys(Keys.ENTER);
        scroll(0,500);
        this.address.sendKeys("Jl. Kelurahan Raya no 55");
        this.city.sendKeys("Jakarta Timur");
        this.province.click();
        this.chooseProvince.sendKeys("dki");
        this.chooseProvince.sendKeys(Keys.ENTER);
        this.postcode.sendKeys("13440");
        this.phone.sendKeys("081289371982");
        this.email.sendKeys("gugunwisetyo@gmail.com");
//        this.tnc.click();
        this.placeOrder.click();
        scroll(0,500);
    }

    public void checkTnc(){
        scroll(0,500);
        this.tnc.click();
        this.placeOrder.click();
        scroll(0,500);
    }

    public String getCartCount(){
        return cartCount.getText();
    }

    public String getTxtOrderDone(){
        return txtOrderDone.getText();
    }

    public String getTxtUncheckTnc(){
        return txtUncheckTnc.getText();
    }
}
