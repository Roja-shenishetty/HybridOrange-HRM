
@tag
Feature: I want to test EmpReg
 

 

  @EmpModule
  Scenario Outline: Adding multiple employees
    Given I want to launch browser 
    When I launch url 
    When I wait for username  with "name" and "txtUsername" and "10"
    When I enter username with "name" and "txtUsername" and "Admin"
    When I enter password with "name" and "txtPassword" and "Qedge123!@#"
    When I click login button with "id" and "btnLogin"
    When I wait for PIM link with "xpath" and "//b[normalize-space()='PIM']" and "10"
    When I click PIM link with "xpath" and "//b[normalize-space()='PIM']" 
    When I wait for addEmployee link with "xpath" and "//a[@id='menu_pim_addEmployee']" and "10"
    When I click addEmployee link with "xpath" and "//a[@id='menu_pim_addEmployee']"
    When I enter in "<FirstName>" with "name" and "firstName"  
    When I enter in "<LastName>" with "name" and "lastName" 
    When I capture EmployeeId with "xpath" and "//input[@id='employeeId']"
    When I click saveBtn with "id" and "btnSave"
    When I verify AddedEmployee 
    When I click Welcome link with "xpath" and "//a[@id='welcome']"
    When I wait for logout link with "xpath" and "//a[normalize-space()='Logout']" and "10"
    When I click logout link with "xpath" and "//a[normalize-space()='Logout']"
    When I close browser
    
    
    Examples:
    |FirstName|LastName|
    |Swathi|Damacharla|
    |Vineela|Pagidela|
    |Sujatha|Shekar|
    |Sreemayee|Shekar|