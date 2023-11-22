Feature: The user is logged in successfully and the personal information page is displayed
  Change  fields: Employee First and Last  Name, ID, SSN No, SIN No, Driver License No, Date of Birth
  Validate all fields saved successfully.

  Background:
    Given Navigate to Web Page
    And Enter data in Text Box
      | userName | Admin    |
      | password | admin123 |
    When Click on navigation element
      | loginButton |

@Smoke
  Scenario: Change personal Info
    And Click on navigation element
      | myInfo |
    And Delete old info and Enter data in Text Box
      | firstNameField | John |
      | lastNameField  | Snow |
    When Click on dialog element
      | saveButton |
    Then Verification
      | messageShow | success |
@Smoke
  Scenario: Change personal Info (Negative) without entering lastName
    And Click on navigation element
      | myInfo |
    And Delete old info and Enter data in Text Box
      | firstNameField | John |
      | lastNameField  |  |
    Then Verification
      | errorMessage    | Required |