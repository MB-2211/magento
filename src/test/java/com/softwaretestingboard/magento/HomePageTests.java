package com.softwaretestingboard.magento;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(1)
public final class HomePageTests {
    private WebDriver driver;
    private HomePage page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/");

        page = new HomePage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testClickSignInLink() {
        page.clickSignInButton();

        String newUrl = driver.getCurrentUrl();

        assertTrue(newUrl != null && !newUrl.isEmpty());
        assertTrue(newUrl.contains("customer/account/login"));

        String newTitle = driver.getTitle();
        assertTrue(newTitle != null && !newTitle.isEmpty());
        assertEquals("Customer Login", newTitle);
    }

    @Test
    public void testClickSignUpLink() {
        page.clickSignUpButton();

        String newUrl = driver.getCurrentUrl();

        assertTrue(newUrl != null && !newUrl.isEmpty());
        assertTrue(newUrl.contains("customer/account/create"));

        String newTitle = driver.getTitle();
        assertTrue(newTitle != null && !newTitle.isEmpty());
        assertEquals("Create New Customer Account", newTitle);
    }
}
