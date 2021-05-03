Feature: Cucumber Project Git

  Background:login
    Given the user navigate to the page
    When user enter the "Admin" and "admin123"
    Then  user click the login button
    When user clicks the admin function

  @ValidateDescendingOrder @Regression @Smoke
  Scenario: Test Case 1

    Then user clicks first checkbox next to the Username
    And Validate that all checkboxes are selected
    And Click on top of username 2 times
    And Validate usernames are listed in descending order

  @ValidateMessage @Regression @Smoke
  Scenario: Test Case 2

    And user clicks add button
      | role  | employeeName | username  | status  | password   | confirmPassword |
      | Admin | David Morris | David-12D | Enabled | Jack12345. | Jack12345.      |

    Then  validate the message

  @ValidateUpdatedMessage @Regression @Smoke
  Scenario: Test Case 3

    Then under System User search with the username which you have saved
      | username  | role  | employeeName | status  |
      | David-12D | Admin | David Morris | Enabled |

    Then validate only one user displayed after a search
    Then validate username , user role, employee name and status of the employee
    Then click on top the username
    Then click edit button
    And change the status and click save button
    Then validate updated message
    And search with the username
    And validate status us updated for the user

  @ValidateExistingEmployee @Regression @Smoke
  Scenario: Test Case 4
    When user click admin button
    And user click add user button
    Then user enter the username "David-12D" which is already exist
    Then validate Already exits text is  displayed


  @ValidateDeletedMessage @Regression @Smoke
  Scenario: Test Case 5
    When under System User search with the username which you have saved
      | username  | role  | employeeName | status  |
      | David-12D | Admin | David Morris | Enabled |
    Then click the checkbox for the user,click delete button
    And validate popup is displayed,click ok button
    And validate successfully deleted message
    Then search with same username
    And validate no records found text














