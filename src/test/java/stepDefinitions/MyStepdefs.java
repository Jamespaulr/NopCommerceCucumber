package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.LoginPage;

public class MyStepdefs {
    WebDriver driver;
    LoginPage lp;

    @Given("User launch the chrome browser")
    public void user_launch_the_chrome_browser() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrator\\Desktop\\NopCommerceCucumber\\Drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        lp = new LoginPage(driver);
    }

    @When("User opens url {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("User enters Email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {
        lp.enterEmail(email);
        lp.enterPassword(pwd);
    }

    @When("clicks login")
    public void clicks_login() {
        lp.clickLoginBtn();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        Thread.sleep(3000);
        lp.logOut();
    }

    @Then("close the browser")
    public void close_the_browser() {
        driver.close();
    }
}
