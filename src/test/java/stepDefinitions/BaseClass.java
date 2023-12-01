package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.CustomerPage;
import pageObjects.LoginPage;


import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public LoginPage lp;
    public CustomerPage CustPage;

    public static Logger logger;
   public Properties configProp;




    //Created for generating random string for Unique email
    public static String randomestring() {
        return (RandomStringUtils.randomAlphabetic(5));
    }

}