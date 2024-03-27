package Homework1;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;



/*/
@homework
Feature: Homework
  Scenario Outline:  dynamic url
    Given user goes to the "<page_url>"
    Then user waits for 5 seconds
    And verifies that the page title contains the word "<title>"
    And closes the page
    Examples:
      |page_url|  title|
      |googleUrl | Google |
      |amazonUrl | Amazon |
      |youtubeUrl | YouTube  |
 */

@Suite
@IncludeEngines("cucumber")
@SelectPackages("Homework1")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber.html")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@homework")
public class RunHomework1Tests {
}