Feature: Test petstore request

  @post
  Scenario: Create new pet
    Given User checks pet is not created before
    When User executes post request
    Then Status code is 200
    And Pet has following attributes
      | petId  | petName | petStatus                |
      | 789456 | Mark    | RestAssured the best pet |

  @get
  Scenario: Get pet by id
    When User executes get request
    Then User validates status code is 200
    And Pet has following items
      | petId  | petName | petStatus                |
      | 789456 | Mark    | RestAssured the best pet |


  Scenario: Update existing pet
    Given User checks pet 789456 is created before
    When User executes put request for pet 789456
    Then Status code is 200 or not
    And Pet has following updated attributes
      | petId  | petName | petStatus   |
      | 134679 | Michael | RestAssured |


  Scenario: Delete existing pet
    Given User checks pet 201020 is created
    When User executes delete request for pet 201020
    Then User validates status code is 200 or not
    And User executes get request for existing pet
    And User checks 404 status code
