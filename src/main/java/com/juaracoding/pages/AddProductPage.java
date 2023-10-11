package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {

    private WebDriver driver;

    public AddProductPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator add product

    @FindBy(xpath = "//a[normalize-space()='Black Cross Back Maxi Dress']")
    private WebElement productOne;

    @FindBy(xpath = "//select[@id='pa_color']")
    private WebElement chooseColor;

    @FindBy(xpath = "//select[@id='pa_size']")
    private WebElement chooseSize;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    private WebElement viewCart;

    @FindBy(xpath = "//a[normalize-space()='Black Cross Back Maxi Dress - Beige']")
    private WebElement productInCart;

    public void chooseProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        this.productOne.click();
        js.executeScript("window.scrollBy(0,300)");
        this.chooseColor.sendKeys("Beige");
        this.chooseSize.sendKeys("Large");
        this.addToCart.click();
        this.viewCart.click();
        js.executeScript("window.scrollBy(0,300)");
    }

    public String getTxtProduct(){
        return productInCart.getText();
    }
}
