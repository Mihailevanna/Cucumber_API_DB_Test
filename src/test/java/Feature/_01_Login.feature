Feature: Login function
  As an Admin User I should be able to login successfully with valid credentials
  With invalid credentials error message should be displayed.
@Smoke
  Scenario: Login with valid Credentials(Positive)
    Given Navigate to Web Page
    And Enter data in Text Box
      | userName | Admin    |
      | password | admin123 |
    When Click on navigation element
      | loginButton |
    Then Navigation element should be displayed
      | myInfo |
@Smoke
  Scenario: Login with invalid Credentials(Negative)
    Given Navigate to Web Page
    And Enter data in Text Box
      | userName | WrongUserName |
      | password | WrongPassword |
    When Click on navigation element
      | loginButton |
    Then Dialog element should be displayed
      | alertError |




