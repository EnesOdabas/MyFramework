Feature:Login Function Test

  Background:functionality
    Given the user navigate to the login page

  @NegativeLoginTest @Regression
  Scenario Outline:Negative Test
    When user enter "<username>" and "<password>"
    Then validate "<error message>"
    Examples:
      | username | password | error message            |
      |          |          | Username cannot be empty |
      | Admin    |          | Password cannot be empty |
      |          | admin123 | Username cannot be empty |
      | asdffdsf | asdsdfs  | Invalid credentials      |
      | asdffdsf | admin123 | Invalid credentials      |
      | Admin    | asdsdfs  | Invalid credentials      |

 @PositiveLoginTest @Regression @Smoke
  Scenario:Positive Test
    Then Verify if a user will be able to login with a valid username and valid password
    Then Verify the messages for invalid login


