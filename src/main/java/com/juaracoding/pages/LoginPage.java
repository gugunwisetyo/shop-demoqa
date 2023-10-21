package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver;

    public LoginPage(){
        driver = DriverSingleton.getDriver();
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

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//label[@for='username']")
    private WebElement txtLogout;

    @FindBy(xpath = "//a[contains(text(),'Lost your password')]")
    private WebElement txtError;

    @FindBy(xpath = "//strong[normalize-space()='Error:']")
    private WebElement txtError2;

    public void doLogin(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginBtn.click();
    }

    public void doLogout(){
        this.logoutBtn.click();
    }

    public void clearUser(){
        username.sendKeys(Keys.CONTROL+"a");
        username.sendKeys(Keys.DELETE);
    }

    public void clearPass(){
        password.sendKeys(Keys.CONTROL+"a");
        password.sendKeys(Keys.DELETE);
    }

    public String getTxtLogin(){
        return txtLogin.getText();
    }

    public String getTxtLogout(){
        return txtLogout.getText();
    }

    public String getTxtError(){
        return txtError.getText();
    }

    public String getTxtError2(){
        return txtError2.getText();
    }

    public void scroll(int horizontal, int vertical){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+horizontal+","+vertical+")");
    }
}
