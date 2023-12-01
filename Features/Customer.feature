Feature: Customer

  @Customer
  Scenario: Add new Customer
    Given User launch the chrome browser
    When User opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And clicks login
    Then User can view the Dashboard
    And User clicks on customers dropdown
    And User clicks on customer info
    And User clicks on Add New
    Then User can view the Customer new page
    Then User enters all the details
    And clicks on save
    Then User can view the confirmation message "The new customer has been added successfully"
    And close the browser