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
@Order(3)
public final class SignInPageTests {
    private WebDriver driver;
    private SignInPage page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        page = new SignInPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void testSignIn() {
        page.with(Values.emailId, Values.password);

        String newUrl = driver.getCurrentUrl();

        assertTrue(newUrl != null && !newUrl.isEmpty());
        assertTrue(newUrl.contains("customer/account"));

        String newTitle = driver.getTitle();
        assertTrue(newTitle != null && !newTitle.isEmpty());
        assertEquals("My Account", newTitle);
    }

    @Test
    @Order(2)
    public void testSignInWithInvalidPassword() {
        page.with(Values.emailId, "InvalidPassword@12345");

        String error = driver.findElement(By.cssSelector(".message-error.error.message")).getText();
        assertTrue(error.contains("The account sign-in was incorrect or your account is disabled temporarily."));

        String title = driver.getTitle();
        assertTrue(title != null && !title.isEmpty());
        assertEquals("Customer Login", title);
    }
}
