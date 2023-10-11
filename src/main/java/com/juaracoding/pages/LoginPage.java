package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator login
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//p[contains(text(), 'Hello')]")
    private WebElement txtLogin;

    public void doLogin(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginBtn.click();
    }

    public String getTxtLogin(){
        return txtLogin.getText();
    }
}
