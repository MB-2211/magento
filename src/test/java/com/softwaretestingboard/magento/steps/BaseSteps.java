package com.softwaretestingboard.magento.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseSteps {
    protected final WebDriver driver = new ChromeDriver();

    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void tearDown() {
        driver.quit();
    }
}
