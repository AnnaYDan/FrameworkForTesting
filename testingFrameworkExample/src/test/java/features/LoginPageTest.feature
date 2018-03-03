#Author: your.email@your.domain.com
@tag
Feature: Login Page Test
  As a user I need login page so that I will be able to access my information

  Background: 
    Given I was located on the home page

  @tag1
  Scenario: Login with correct credentials
    When I am logging in with "a" and "a"
    Then I should get SIGN-OFF link

#  @tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step
#
#    Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |
