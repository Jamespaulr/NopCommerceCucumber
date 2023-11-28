package pageObjects;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

import static org.openqa.selenium.By.xpath;

public class CustomerPage {
    WebDriver ldriver;

    public CustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p/i")
    WebElement Customer_menu;
    @FindBy(xpath = "//p[text()=' Customers']")
    WebElement Customer;
    @FindBy(xpath = "//a[@href=\"/Admin/Customer/Create\"]")
    WebElement addNewCust;

    @FindBy(id = "Email")
    WebElement Email;
    @FindBy(id = "Password")
    WebElement Password;
    @FindBy(id = "FirstName")
    WebElement FirstName;
    @FindBy(id = "LastName")
    WebElement LastName;
    @FindBy(id = "Gender_Male")
    WebElement Gender_Male;
    @FindBy(id = "Gender_Female")
    WebElement Gender_Female;
    @FindBy(id = "DateOfBirth")
    WebElement DateOfBirth;
    @FindBy(id = "Company")
    WebElement CompanyName;
    @FindBy(id = "IsTaxExempt")
    WebElement IsTaxExempt;
    @FindBy(id = "SelectedNewsletterSubscriptionStoreIds_listbox")
    WebElement SelectedNewsletterSubscriptionStoreIds_listbox;
    @FindBy(xpath = "//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']/child::div")
    WebElement customer_role;
    @FindBy(xpath = "//li[text()='Administrators']")
    WebElement Administrator;
    @FindBy(xpath = "//li[text()='Forum Moderators']")
    WebElement Forum_Moderators;
    @FindBy(xpath = "//li[text()='Guests']")
    WebElement Guests;
    @FindBy(xpath = "//li[text()='Registered']")
    WebElement Registered;
    @FindBy(xpath = "//li[text()='Vendors']")
    WebElement Vendors;
    @FindBy(xpath = "//option[text()='Not a vendor']")
    WebElement Not_a_Vendor;
    @FindBy(xpath = "//option[text()='Vendor 1']")
    WebElement Vendor_1;
    @FindBy(xpath = "//option[text()='Vendor 2']")
    WebElement Vendor_2;
    @FindBy(id = "Active")
    WebElement Active_checkbox;
    @FindBy(id = "AdminComment")
    WebElement Admin_comment;
    @FindBy(xpath = "//button[@name='save']")
    WebElement Save;



        public void clickOnCustomerList ()
        {
            Customer_menu.click();
        }

        public void clickOnCustomerMenu ()
        {
            Customer.click();
        }
        public void clickOnNewCust ()
        {
            addNewCust.click();
        }
        public String emailID;
        public void RandomiseString ()
        {
            String Alphabet = RandomStringUtils.random(6);
            emailID = Alphabet.concat("@gmail.com");
        }
        public void enterEmail (String emailID)
        {
            Email.clear();
            Email.sendKeys(emailID);
        }
        public void enterPassword (String pwd)
        {
           Password.clear();
           Password.sendKeys(pwd);
        }
        public void enterFirstname (String fName)
        {
            FirstName.clear();
            FirstName.sendKeys(fName);
        }
        public void enterLastname (String Lname)
        {
           LastName.clear();
           LastName.sendKeys(Lname);
        }
        public void selectGender (String gender)
        {
            if (gender.equals("male")) {
                Gender_Male.click();
            } else if (gender.equals("female")) {
                Gender_Female.click();
            } else {
                Gender_Male.click();
            }
        }
        public void DOB (String dob)
        {
            DateOfBirth.sendKeys(dob);
        }
        public void enterCompanyName (String companyName)
        {
           CompanyName.sendKeys(companyName);
        }
        public void setCustomerRole (String role)
        {
            customer_role.click();
            if (role.equals("Administrator")) {
                Administrator.click();
            } else if (role.equals("Forum Moderators")) {
                Forum_Moderators.click();
            } else if (role.equals("Guests")) {
                Guests.click();
            } else if (role.equals("Registered")) {
                Registered.click();
            } else if (role.equals("Vendors")) {
                Vendors.click();
            }
        }
        public void managerVendor (String Vendor)
        {
            if (Vendor.equals("Vendor1")) {
                Vendor_1.click();
            } else {
                Vendor_2.click();
            }
        }
        public void enterAdmin_comment (String adminComments)
        {
            Admin_comment.sendKeys(adminComments);
        }
        public void clickSave ()
        {
            Save.click();
        }


    }

