Feature: Get information Action
  Scenario: Get information successfully
    Given User is on Register Page
    When User enters Email
    And User click on Submit button
    Then Access details is displayed

  Scenario Outline: Login successfully
#    Scenario: Login successfully
    Given User is on Login Page
#    When User enters "nhung1" and "nhung1" DDT in Cucumber
    When User enters "<username>" and "<password>"
#    When User enters credentials to Login
#    |username|password|
#    |nhung1  |nhung1  |
#    |nhung2  |nhung2  |
    And User click on Sign in button
    Then Home page is displayed successfully
  Examples:
    |username|password|
    |nhung1  |nhung1  |
    |nhung2|nhung2|