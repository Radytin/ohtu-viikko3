Feature: A new user account can be created if a proper unused username and password are given

 Scenario: successfull creation of new user
    Given command new user is selected
    When username "newnew" and password "password123" are entered
    Then system will respond with "new user registered"

Scenario: creation fails with correct password and too short username
    Given command new user is selected
    When username "n" and password "password123" are entered
    Then system will respond with "new user not registered"

Scenario: creation fails with password only consisting letters
    Given command new user is selected
    When username "newbie" and password "password" are entered
    Then system will respond with "new user not registered"

Scenario: creation fails with username that is already taken
    Given command new user is selected
    When username "pekka" and password "password" are entered
    Then system will respond with "new user not registered"

Scenario: creation fails with too short password
    Given command new user is selected
    When username "newbie" and password "1" are entered
    Then system will respond with "new user not registered"

Scenario: can log in with successfully created account
    Given user "urpo" with password "passu123" is created
    And command login is selected
    When username "urpo" and password "passu123" are entered
    Then system will respond with "logged in"
Scenario: can not login with an incorrectly created account
    Given user "uu" with password "oo" is created
    And command login is selected
    When username "uu" and password "oo" are entered
    Then system will respond with "wrong username or password"
