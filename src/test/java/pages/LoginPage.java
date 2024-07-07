package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

@Data
public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@data-testid='cypress-headernav-profile']")
    private WebElement profileIcon;

    @FindBy(linkText = "Log in")
    private WebElement loginLink;

    @FindBy(xpath = "//div[.='Continue with email']")
    private WebElement loginWithEmail;

    @FindBy(xpath = "//input[@data-testid='email-login-email']")
    private WebElement emailField;

    @FindBy(name = "user[password]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-testid='cypress-headernav-profile']//img[@class]")
    private WebElement userProfileButtonWithInitial;

    public void login(){
        profileIcon.click();
        SeleniumUtils.waitForClickability(loginLink, 5);
        loginLink.click();
        SeleniumUtils.waitForClickability(loginWithEmail, 5);
        loginWithEmail.click();
        SeleniumUtils.waitForClickability(emailField, 5);
        emailField.sendKeys(ConfigReader.getProperty("username"), Keys.ENTER);
        SeleniumUtils.waitForClickability(passwordField, 5);
        passwordField.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);
    }

    public void login(String username, String password){
        profileIcon.click();
        SeleniumUtils.waitForClickability(loginLink, 5);
        loginLink.click();
        SeleniumUtils.waitForClickability(loginWithEmail, 5);
        loginWithEmail.click();
        SeleniumUtils.waitForClickability(emailField, 5);
        emailField.sendKeys(username, Keys.ENTER);
        SeleniumUtils.waitForClickability(passwordField, 5);
        passwordField.sendKeys(password, Keys.ENTER);
    }

}
