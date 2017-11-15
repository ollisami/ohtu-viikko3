Feature: User can log in with valid username/password-combination

    Scenario: user can login with correct password
       Given command login is selected
       When  username "pekka" and password "akkep" are entered
       Then  system will respond with "logged in"

    Scenario: user can login with correct username
	Given command login is selected
	When  gives a valid username
	Then  ask for password

    Scenario: user can not login with incorrect password
	Given command login is selected
	When  password is incorrect
	Then  log error message

    Scenario: nonexistent user can not login to 
	Given command login is selected
	When  username does not exsist
	Then  log error message
