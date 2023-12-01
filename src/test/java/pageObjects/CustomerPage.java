package pageObjects;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CustomerPage
{
    String title;
    public WebDriver ldriver;
    public CustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    By Customer_menu=By.xpath("//p[text()=' Customers']");
    By Customer=By.xpath("//p[text()=' Customers']");

    By addNewCust=By.xpath("//a[@href=\"/Admin/Customer/Create\"]");
    By Email = By.id("Email");
    By Password = By.id("Password");
    By FirstName= By.id("FirstName");
    By LastName=By.id("LastName");
    By Gender_Male=By.id("Gender_Male");
    By Gender_Female=By.id("Gender_Female");
    By DateOfBirth=By.id("DateOfBirth");
    By CompanyName=By.id("Company");
    By IsTaxExempt=By.id("IsTaxExempt");
    By SelectedNewsletterSubscriptionStoreIds_listbox=By.id("SelectedNewsletterSubscriptionStoreIds_listbox");
    By customer_role = By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']/child::div");
    By Administrator=By.xpath("//li[text()='Administrators']");
    By Forum_Moderators=By.xpath("//li[text()='Forum Moderators']");
    By Guests=By.xpath("//li[text()='Guests']");
    By Registered=By.xpath("//li[text()='Registered']");
    By Vendors=By.xpath("//li[text()='Vendors']");
    By Not_a_Vendor=By.xpath("//option[text()='Not a vendor']");
    By Vendor_1=By.xpath("//option[text()='Vendor 1']");
    By Vendor_2=By.xpath("//option[text()='Vendor 2']");
    By Active_checkbox=By.id("Active");
    By Admin_comment=By.id("AdminComment");
    By Save=By.xpath("//button[@name='save']");

    public String getPageTitle() throws InterruptedException {
        Thread.sleep(5000);
            title= ldriver.getTitle();
        return title;
    }

    public void clickOnCustomerList()
    {
        ldriver.findElement(Customer_menu).click();
    }
    public void clickOnCustomerMenu()
    {
        ldriver.findElement(Customer).click();
    }
    public void clickOnNewCust()
    {
        ldriver.findElement(addNewCust);
    }
     public String emailID;
    public void RandomiseString()
    {
        String Alphabet= RandomStringUtils.random(6);
        emailID = Alphabet.concat("@gmail.com");
    }
    public void enterEmail(String emailID)
    {
        ldriver.findElement(Email).clear();
        ldriver.findElement(Email).sendKeys(emailID);
    }
    public void enterPassword(String pwd)
    {
        ldriver.findElement(Password).clear();
        ldriver.findElement(Password).sendKeys(pwd);
    }
    public void enterFirstname(String fName)
    {
        ldriver.findElement(FirstName).clear();
        ldriver.findElement(FirstName).sendKeys(fName);
    }
    public void enterLastname(String Lname)
    {
        ldriver.findElement(LastName).clear();
        ldriver.findElement(LastName).sendKeys(Lname);
    }
    public void selectGender(String gender)
    {
        if(gender.equals("male"))
        {
            ldriver.findElement(Gender_Male).click();
        }
        else if (gender.equals("female"))
        {
            ldriver.findElement(Gender_Female).click();
        }
        else
        {
            ldriver.findElement(Gender_Male).click();
        }
    }
    public void DOB(String dob)
    {
        ldriver.findElement(DateOfBirth).sendKeys(dob);
    }
    public void enterCompanyName(String companyName)
    {
        ldriver.findElement(CompanyName).sendKeys(companyName);
    }
    public void setCustomerRole(String role)
    {
        ldriver.findElement(customer_role).click();
        if (role.equals("Administrator"))
        {
          ldriver.findElement(Administrator).click();
        }
        else if (role.equals("Forum Moderators"))
        {
            ldriver.findElement(Forum_Moderators).click();
        } else if (role.equals("Guests"))
        {
            ldriver.findElement(Guests).click();
        } else if (role.equals("Registered"))
        {
            ldriver.findElement(Registered).click();
        }
        else if (role.equals("Vendors"))
        {
            ldriver.findElement(Vendors).click();
        }
    }
    public void managerVendor(String Vendor)
    {
       if (Vendor.equals("Vendor1"))
       {
           ldriver.findElement(Vendor_1).click();
       }
       else
       {
           ldriver.findElement(Vendor_2).click();
       }
    }
    public void enterAdmin_comment(String adminComments)
    {
        ldriver.findElement(Admin_comment).sendKeys(adminComments);
    }
    public void clickSave()
    {
        ldriver.findElement(Save);
    }


}
