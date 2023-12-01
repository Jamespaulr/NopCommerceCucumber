Feature: Login
@Login
  Scenario: Login into the application with valid Credentials.
    Given User launch the chrome browser
    When User opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And clicks login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close the browser
