package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class LoginPage
{
    public static WebDriver ldriver;
    public LoginPage(WebDriver rdriver)
    {
       ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath = "//input[@id='Email']")
    WebElement username;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;
    @FindBy(xpath = "//button[text()='Log in']")
    WebElement loginBtn;
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutBtn;



    public void enterEmail(String email)
    {
        username.clear();
        username.sendKeys(email);
    }
    public void enterPassword(String pwd)
    {
        password.clear();
        password.sendKeys(pwd);
    }
    public void clickLoginBtn()
    {
        loginBtn.click();
    }
    public void logOut()
    {
        logoutBtn.click();
    }







}
