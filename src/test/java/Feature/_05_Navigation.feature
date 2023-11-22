Feature: As an Admin user I should be able to see all necessary buttons and information,
  when I navigate to the User Management page


  Background:
    Given Navigate to Web Page
    And Enter data in Text Box
      | userName | Admin    |
      | password | admin123 |
    And Click on navigation element
      | loginButton    |
      | admin          |
      | userManagement |
      | userButton     |
@Smoke
  Scenario: When I navigate to User Management page I should be able to see Add button
    And Verification
      | addEmployee | Add |
@Smoke
  Scenario:  When I navigate to the User Management page I should be able to see all the required elements displayed
  (Username, User Role, Employee Name, Status, Actions)
    And List of headers is Displayed and contains Text
      | Username, User Role, Employee Name, Status, Actions |

