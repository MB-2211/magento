package com.softwaretestingboard.magento.steps;

import com.softwaretestingboard.magento.Values;
import com.softwaretestingboard.magento.pages.SignUpPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public final class SignUpSteps extends BaseSteps {
    private final SignUpPage page;

    public SignUpSteps() {
        page = new SignUpPage(driver);
    }

    @Before
    public void before() {
        setUp();
    }

    @After
    public void after() {
        tearDown();
    }

    @Given("the SignUp page")
    public void theSignUpPage() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @When("I fill in valid account details")
    public void iFillInValidAccountDetails() {
        page.fill(Values.firstname, Values.lastname, Values.emailId, Values.password);
    }

    @And("I submit the SignUp form")
    public void iSubmitTheSignUpForm() {
        page.clickSignUpButton();
    }

    @Then("my account should be created successfully")
    public void myAccountShouldBeCreatedSuccessfully() {
        String newUrl = driver.getCurrentUrl();

        assertNotNull(newUrl);
        assertTrue(newUrl.endsWith("customer/account/"));

        assertEquals("My Account", driver.getTitle());
    }

    @And("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        String message = driver.findElement(By.cssSelector(".message-success.success.message")).getText();
        assertTrue(message.contains("Thank you for registering with Main Website Store."));
    }

    @Then("no new account should be created")
    public void noNewAccountShouldBeCreated() {
        assertEquals("Create New Customer Account", driver.getTitle());
    }

    @And("I should see a failure message of email id already existing")
    public void iShouldSeeAFailureMessageOfEmailIdAlreadyExisting() {
        String error = driver.findElement(By.cssSelector(".message-error.error.message")).getText();
        assertTrue(error.contains("There is already an account with this email address."));
    }
}
