Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  username and password is valid
        Then  create new user
    
    Scenario: creation fails with already taken username and valid password
        Given command new user is selected
        When  username is taken
        Then  log error message

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  username is too short
        Then  log error message

    Scenario: creation fails with valid username and too short password
        Given command new user is selected
        When  password is too short
        Then  log error message

    Scenario: creation fails with valid username and password enough long but consisting of only letters
        Given command new user is selected
        When  password contains only letter
        Then  log error message

    Scenario: can login with successfully generated account
        Given user "eero" with password "salainen1" is created
        And   command login is selected
        When  user enter valid username and password
        Then  user logs in

