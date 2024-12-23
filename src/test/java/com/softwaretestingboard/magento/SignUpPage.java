package com.softwaretestingboard.magento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://magento.softwaretestingboard.com/customer/account/create/
public final class SignUpPage {
    @FindBy(id = "firstname")
    private WebElement firstname;

    @FindBy(id = "lastname")
    private WebElement lastname;

    @FindBy(id = "email_address")
    private WebElement emailId;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmation;

    @FindBy(css = "button[class='action submit primary']")
    private WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void with(String firstname, String lastname, String emailId, String password) {
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.emailId.sendKeys(emailId);
        this.password.sendKeys(password);
        this.passwordConfirmation.sendKeys(password);

        signUpButton.click();
    }
}
