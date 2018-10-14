Feature: UpdateFeature
  This feature votes for movies in the application

  Scenario Outline: Vote for a movie
    Given I navigate to the app
    Then I click login link
    And I login with username as "test-user" and password as "TA12345"
    And I search a <movieName>
    When I click on movie
    Then I should see movie page that includes the <movieName>
    And I vote for the movie with <movieScore>
    And I log out
    Examples:
      | movieName       | movieScore |
      | winter sleep    | 88         |
      | the dark knight | 97         |
