package com.softwaretestingboard.magento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://magento.softwaretestingboard.com/customer/account/login
public final class SignInPage {
    @FindBy(name = "login[username]")
    private WebElement emailId;

    @FindBy(name = "login[password]")
    private WebElement password;

    @FindBy(css = "button[class='action login primary']")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void with(String emailId, String password) {
        this.emailId.sendKeys(emailId);
        this.password.sendKeys(password);

        signInButton.click();
    }
}
