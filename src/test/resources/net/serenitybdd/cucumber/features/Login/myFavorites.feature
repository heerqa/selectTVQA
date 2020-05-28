Feature: Test

  The purpose of the feature
  is to make sure
  that user is able to Login

 Scenario: Verify that user is able to login
    Given user is on login page
    And user enter username and "heer@heersoftware.com" and password as "At1234$$" and click Login button
    Then home page is displayed

  Scenario: Verify User can Navigate and click My Favorites
    And user can navigate and click the "My Favorites" left menu tab
    Then user can navigate and click the following sub menu tabs
      |TV Shows|
      |Movies|
      |Movie Genres|
      |Channels|
      |Networks|
      |Video Libraries|


