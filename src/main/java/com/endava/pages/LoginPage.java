package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(css = "form .btn.btn-primary")
    private WebElement loginButton;
    @FindBy(css = ".list-group-item:nth-of-type(13)")
    private WebElement logoutButton;

    @FindBy(xpath = ".//*[@id='column-right']/div/a[4]")
    private WebElement addressBook;

    @FindBy(css = "#logo h1 a")
    private WebElement yourStore;

    @FindBy(css = ".btn.btn-primary")
    private WebElement continueButton;


    public void loginCredentials(String email, String pass) {
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        loginButton.click();

    }

    public Boolean checkIfLogoutExists(){
        return logoutButton.isDisplayed();
    }
    public void logout() {
        if (logoutButton.isDisplayed()) logoutButton.click();
        continueButton.click();
    }

    public AddressBookPage goToAddressBook() {
        addressBook.click();
        return PageFactory.initElements(webDriver, AddressBookPage.class);
    }

    public HomePage goToYourStore() {
        yourStore.click();
        return PageFactory.initElements(webDriver, HomePage.class);
    }
}
