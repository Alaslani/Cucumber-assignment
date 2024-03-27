package Homework2;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Given("user is on the registration page")
    public void userIsOnTheRegistrationPage() {
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        registrationPage = new RegistrationPage(driver);
    }

    @When("user enters valid registration details")
    public void userEntersValidRegistrationDetails() {
        registrationPage.enterFirstName("No")
                .enterLastName("Body")
                .enterEmail("nobody@everybody.com")
                .enterTelephone("1234567890")
                .enterPassword("password")
                .confirmPassword("password")
                .agreeToPrivacyPolicy();
    }

    @When("user submits the registration form")
    public void userSubmitsTheRegistrationForm() {
        registrationPage.submitRegistration();
    }

    @Then("user should be registered successfully")
    public void userShouldBeRegisteredSuccessfully() {

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}