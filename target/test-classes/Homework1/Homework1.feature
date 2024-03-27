@homework
Feature: Homework1
  Scenario Outline:  dynamic url
    Given user goes to the "<page_url>"
    Then user waits for 5 seconds
    And verifies that the page title contains the word "<title>"
    And closes the page
    Examples:
      |page_url|  title|
      |https://www.google.com/ | Google |
      |https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166 | Amazon |
      |https://www.youtube.com/ | YouTube  |