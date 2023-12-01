package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.CustomerPage;
import pageObjects.LoginPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MyStepdefs extends BaseClass {

   @Before
    public void setup() throws IOException {
       logger = Logger.getLogger("NopCommerce");
       PropertyConfigurator.configure("Log4j.properties");
        configProp=new Properties();
        FileInputStream configpropfile= new FileInputStream("config.properties");

        configProp.load(configpropfile);
        String br= configProp.getProperty("browser");

        if (br.equals("chrome"))
        {
            System.setProperty("webdriver.edge.driver", configProp.getProperty("chromepath"));
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            logger.info("launch the Web application with the given URl");
        }
        else if (br.equals("edge"))
        {
            System.setProperty("webdriver.edge.driver", configProp.getProperty("edgepath"));
            driver=new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            logger.info("launch the Web application with the given URl");
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.edge.driver", configProp.getProperty("firefoxpath"));
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            logger.info("launch the Web application with the given URl");

        }

    }


    @Given("User launch the chrome browser")
    public void userLaunchTheChromeBrowser()
    {



        lp = new LoginPage(driver);
        CustPage=new CustomerPage(driver);
    }

    @When("User opens url {string}")
    public void userOpensUrl(String url)
    {
        logger.info("----------Opening URL----------");
        driver.get(url);
    }

    @And("User enters Email as {string} and password as {string}")
    public void userEntersEmailAsAndPasswordAs(String email, String pwd)
    {
        logger.info("----------Entering Email---------");
        lp.enterEmail(email);
        logger.info("----------Entering Password ---------");
        lp.enterPassword(pwd);
    }

    @And("clicks login")
    public void clicksLogin()
    {
        logger.info("----------Clicking login Button---------");
        lp.clickLoginBtn();
    }

    @Then("Page Title should be {string}")
    public void pageTitleShouldBe(String title)
    {
        if (driver.getPageSource().contains("Login was unsuccessful"))
        {
            driver.close();
            logger.info("----------Asserting the page Title---------");
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
        logger.info("----------Clicking on logout link---------");
        lp.logOut();
    }

    @And("close the browser")
    public void closeTheBrowser()
    {
        logger.info("----------Closing the browser---------");
        driver.close();
    }
}
