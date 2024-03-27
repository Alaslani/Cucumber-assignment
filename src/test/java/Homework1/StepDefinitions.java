package Homework1;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    private WebDriver driver;
    private static final String GOOGLE_URL = "https://www.google.com/";
    private static final String AMAZON_URL = "https://www.amazon.com/";
    private static final String YOUTUBE_URL = "https://www.youtube.com/";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("user goes to the {string}")
    public void userGoesToThe(String pageUrl) {
        switch (pageUrl) {
            case "googleUrl":
                driver.navigate().to(GOOGLE_URL);
                break;
            case "amazonUrl":
                driver.navigate().to(AMAZON_URL);
                break;
            case "youtubeUrl":
                driver.navigate().to(YOUTUBE_URL);
                break;
            default:
                throw new IllegalArgumentException("Invalid page URL: " + pageUrl);
        }
    }

    @Then("user waits for {int} seconds")
    public void userWaitsForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("verifies that the page title contains the word {string}")
    public void verifiesThatThePageTitleContainsTheWord(String expectedTitle) {
        String actualTitle = driver.getTitle();
        System.out.println("Actual Page Title: " + actualTitle);
        Assertions.assertTrue(actualTitle.contains(expectedTitle), "Page title does not contain the expected word: " + expectedTitle);
    }

    @And("closes the page")
    public void closesThePage() {
        driver.close();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot-" + System.currentTimeMillis());
        }
        driver.quit();
    }
}