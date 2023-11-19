Feature: As a user I should be able to upload of PNG, JPG  image that is less then 1 MB.

  Background:
    Given Navigate to Web Page
    And Enter data in Text Box
      | userName | Admin    |
      | password | admin123 |
    And Click on navigation element
      | loginButton |

  Scenario: Able to upload PNG format image.
    And Click on navigation element
      | myInfo |
    And Click on dialog element
      | employeeImage |
      | addImage      |
    And Upload file
      | src/test/Resources/PNG_1mb.png |
    When Click on dialog element
      | saveButton |
    Then Verification
      | messageShow | success |

  Scenario: Able to upload JPG format image.
    And Click on navigation element
      | myInfo |
    And Click on dialog element
      | employeeImage |
      | addImage      |
    And Upload file
      | src/test/Resources/JPG_1mb.jpg |
    When Click on dialog element
      | saveButton |
    Then Verification
      | messageShow | success |

  Scenario: Able to upload over 1 MB format image. (Negative)
    And Click on navigation element
      | myInfo |
    And Click on dialog element
      | employeeImage |
      | addImage      |
    And Upload file
      | src/test/Resources/3MB.png |
    When Click on dialog element
      | saveButton |
    Then Verification
      | errorImageMessage | Size Exceeded |


