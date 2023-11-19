Feature:As an Admin user I should be able to create an ESS user account
  so that ESS user will be having his own valid username and valid password.

  Background:
    Given Navigate to Web Page
    And Enter data in Text Box
      | userName | Admin    |
      | password | admin123 |
    And Click on navigation element
      | loginButton |
    And Click on navigation element
      | admin |
    And Click on dialog element
      | addEmployee |

  Scenario: Create ESS user
    And Enter data in Text Box
      | usernameEmployee        | John Snow   |
      | passwordEmployee        | Employee123 |
      | confirmPasswordEmployee | Employee123 |
      | employerName            | J           |
    When Click on dialog element
      | employerNameSelect |
      | userRole           |
      | essOption          |
      | statusEmployee     |
      | enableStatusOption |
      | saveButton         |
    Then Verification
      | messageShow | success |

  Scenario: Create ESS user with same userName (Negative)
    And Enter data in Text Box
      | usernameEmployee        | John Snow   |
      | passwordEmployee        | Employee123 |
      | confirmPasswordEmployee | Employee123 |
      | employerName            | J           |
    When Click on dialog element
      | employerNameSelect |
      | userRole           |
      | essOption          |
      | statusEmployee     |
      | enableStatusOption |
      | saveButton         |
    Then Verification
      | errorText | exists |

  Scenario: Create ESS user without field mandatory filed (Negative)

    When Click on dialog element
      | saveButton |
    Then Verify that Error Messages: displayed,red color and has Text "Required"
      | requiredMessageList |


  Scenario: Enter different values in to the “password’ and “password confirm” fields
    When Enter data in Text Box
      | passwordEmployee        | GoodEmployee123 |
      | confirmPasswordEmployee | GoodEmployee    |
    Then Verify that Error Messages: displayed,red color and has Text "Passwords do not match"
      | passwordDontMatch |

  Scenario:  Enter invalid name in to the “Employee Name’ field (Negative)
    And Enter data in Text Box
      | employerName | Invalid Name |
    When Click on dialog element
      | employerNameSelect |
    Then Verify that Error Messages: displayed,red color and has Text "Invalid"
      | nameErrorMessage |










