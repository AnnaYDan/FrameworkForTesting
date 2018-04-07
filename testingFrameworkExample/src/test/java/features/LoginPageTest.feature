#Author: your.email@your.domain.com
@tag
Feature: Login Page Test
  As a user I need login page so that I will be able to access my information

  Background: 
    Given I was located on the home page

  @tag1
  Scenario Outline: Login with correct credentials
    When I am logging with user "<name>" and password "<pass>"
    Then I should get this "<status>" link

    Examples: 
      | name  | pass  | status  |
      | a     | wrong | SIGN-ON |
      | a     |       | SIGN-ON |
      |       | a     | SIGN-ON |
#      |       |       | SIGN-ON |
#      |       | wrong | SIGN-ON |
#      | wrong | wrong | SIGN-ON |
#      | wrong | a     | SIGN-ON |
#      | wrong |       | SIGN-ON |
