#Author: ssarnaik8@gmail.com
@getUsers
Feature: Feature to validate ReqRes GetListUsers api

  @getListUser1
  Scenario: Scenario to test getListUser api of ReqRes.
    Given User hits reqRes get list users api
    Then User validates field "data[0].first_name" from response with value "George"
