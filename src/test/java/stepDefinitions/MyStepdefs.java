package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pageObjects.LoginPage;

public class MyStepdefs {
    WebDriver driver;
    LoginPage lp;
    @Given("User launch the chrome browser")
    public void userLaunchTheChromeBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/James Paul R/IdeaProjects/NopCommerceCucumber/Drivers/msedgedriver.exe");
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        lp = new LoginPage(driver);
    }

    @When("User opens url {string}")
    public void userOpensUrl(String url)
    {
        driver.get(url);
    }

    @And("User enters Email as {string} and password as {string}")
    public void userEntersEmailAsAndPasswordAs(String email, String pwd)
    {
        lp.enterEmail(email);
        lp.enterPassword(pwd);
    }

    @And("clicks login")
    public void clicksLogin()
    {
        lp.clickLoginBtn();
    }

    @Then("Page Title should be {string}")
    public void pageTitleShouldBe(String title)
    {
        if (driver.getPageSource().contains("Login was unsuccessful"))
        {
            driver.close();
            Assert.assertTrue(false);
        }
        else
        {
            Assert.assertEquals(title,driver.getTitle());
        }
    }

    @When("User click on Log out link")
    public void userClickOnLogOutLink() throws InterruptedException {
        Thread.sleep(3000);
        lp.logOut();
    }

    @And("close the browser")
    public void closeTheBrowser()
    {
        driver.close();
    }
}
