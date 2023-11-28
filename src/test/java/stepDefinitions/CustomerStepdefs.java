package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.CustomerPage;

public class CustomerStepdefs {

    CustomerPage CustPage;
    WebDriver driver;
    @Then("User can view the Dashboard")
    public void userCanViewTheDashboard() throws InterruptedException {
        CustPage= new CustomerPage(driver);
        try {
            Assert.assertEquals("Dashboard / nopCommerce administration",CustPage.getPageTitle());

        } catch (Exception e) {
            System.out.println("hsah");
        }

    }

    @And("User clicks on customers dropdown")
    public void userClicksOnCustomersDropdown()
    {
        CustPage.clickOnCustomerList();
    }

    @And("User clicks on customer info")
    public void userClicksOnCustomerInfo() {
        CustPage.clickOnCustomerMenu();
    }

    @And("User clicks on Add New")
    public void userClicksOnAddNew()
    {
        CustPage.clickOnNewCust();
    }

    @Then("User can view the Customer new page")
    public void userCanViewTheCustomerNewPage() throws InterruptedException {
       try {
           Assert.assertEquals("Add a new customer / nopCommerce administration",CustPage.getPageTitle());
       }catch
       (Exception e) {
           System.out.println("Exception caught");
    }}

    @Then("User enters all the details")
    public void userEntersAllTheDetails()
    {
      CustPage.enterEmail(CustPage.emailID);
      CustPage.enterPassword("12345");
      CustPage.enterFirstname("Testing");
      CustPage.enterLastname("2");
      CustPage.selectGender("");
      CustPage.DOB("2/9/1996");
      CustPage.enterCompanyName("Testing pvt ltd");
      CustPage.setCustomerRole("Guests");
      CustPage.managerVendor("");
      CustPage.enterAdmin_comment("I have Added a new Customer");
    }

    @And("clicks on save")
    public void clicksOnSave()
    {
        CustPage.clickSave();
    }

    @Then("User can view the confirmation message {string}")
    public void userCanViewTheConfirmationMessage(String arg0) throws InterruptedException {
        System.out.println("Done");
    }
}
