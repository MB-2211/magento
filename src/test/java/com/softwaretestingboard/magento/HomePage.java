package com.softwaretestingboard.magento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://magento.softwaretestingboard.com/
public final class HomePage {
    @FindBy(linkText = "Sign In")
    private WebElement signInButton;

    @FindBy(linkText = "Create an Account")
    private WebElement signUpButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
