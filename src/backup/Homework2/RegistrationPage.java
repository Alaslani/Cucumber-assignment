package Homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//label[@for='input-agree']")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//input[@type='submit' and @value='Continue' and @class='btn btn-primary']")
    private WebElement continueButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public RegistrationPage enterTelephone(String telephone) {
        telephoneInput.sendKeys(telephone);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage confirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
        return this;
    }

    public RegistrationPage agreeToPrivacyPolicy() {
        agreeCheckbox.click();
        return this;
    }

    public void submitRegistration() {
        continueButton.click();
    }
}