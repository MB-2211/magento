package com.softwaretestingboard.magento.steps;

import com.softwaretestingboard.magento.Values;
import com.softwaretestingboard.magento.pages.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public final class SignInSteps extends BaseSteps {
    private final SignInPage page;

    public SignInSteps() {
        page = new SignInPage(driver);
    }

    @Before
    public void before() {
        setUp();
    }

    @After
    public void after() {
        tearDown();
    }

    @Given("the SignIn page")
    public void theSignInPage() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    @When("I fill in login details")
    public void iFillInLoginDetails() {
        page.fill(Values.emailId, Values.password);
    }

    @And("I submit the SignIn form")
    public void iSubmitTheSignInForm() {
        page.clickSignInButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        String newUrl = driver.getCurrentUrl();

        assertNotNull(newUrl);
        assertTrue(newUrl.endsWith("customer/account/"));

        assertEquals("My Account", driver.getTitle());
    }

    @When("I fill in invalid login details")
    public void iFillInInvalidLoginDetails() {
        page.fill(Values.emailId, "InvalidPassword@12345");
    }

    @Then("I should not be logged in to my account")
    public void iShouldNotBeLoggedInToMyAccount() {
        assertEquals("Customer Login", driver.getTitle());
    }

    @And("I should see a failure message")
    public void iShouldSeeAFailureMessage() {
        String error = driver.findElement(By.cssSelector(".message-error.error.message")).getText();
        assertTrue(error.contains("The account sign-in was incorrect or your account is disabled temporarily."));
    }
}
