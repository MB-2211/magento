package com.softwaretestingboard.magento.steps;

import com.softwaretestingboard.magento.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public final class HomeSteps extends BaseSteps {
    private final HomePage page;

    public HomeSteps() {
        page = new HomePage(driver);
    }

    @Before
    public void before() {
        setUp();
    }

    @After
    public void after() {
        tearDown();
    }

    @Given("the Home page")
    public void theHomePage() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("I click the SignUp link")
    public void iClickTheSignUpLink() {
        page.clickSignUpButton();
    }

    @Then("I go to the SignUp page")
    public void iGoToTheSignUpPage() {
        String newUrl = driver.getCurrentUrl();

        assertNotNull(newUrl);
        assertTrue(newUrl.contains("customer/account/create"));

        assertEquals("Create New Customer Account", driver.getTitle());
    }

    @When("I click the SignIn link")
    public void iClickTheSignInLink() {
        page.clickSignInButton();
    }

    @Then("I go to the SignIn page")
    public void iGoToTheSignInPage() {
        String newUrl = driver.getCurrentUrl();

        assertNotNull(newUrl);
        assertTrue(newUrl.contains("customer/account/login"));

        assertEquals("Customer Login", driver.getTitle());
    }
}
