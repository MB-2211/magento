package com.softwaretestingboard.magento;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(2)
public final class SignUpPageTests {
    private WebDriver driver;
    private SignUpPage page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

        page = new SignUpPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void testSignUp() {
        page.with(Values.firstname, Values.lastname, Values.emailId, Values.password);

        String newUrl = driver.getCurrentUrl();

        assertTrue(newUrl != null && !newUrl.isEmpty());
        assertTrue(newUrl.contains("customer/account"));

        String newTitle = driver.getTitle();
        assertTrue(newTitle != null && !newTitle.isEmpty());
        assertEquals("My Account", newTitle);
    }

    @Test
    @Order(2)
    public void testSignUpWithExistingEmail() {
        page.with(Values.firstname, Values.lastname, Values.emailId, Values.password);

        String error = driver.findElement(By.cssSelector(".message-error.error.message")).getText();
        assertTrue(error.contains("There is already an account with this email address."));

        String title = driver.getTitle();
        assertTrue(title != null && !title.isEmpty());
        assertEquals("Create New Customer Account", title);
    }
}
