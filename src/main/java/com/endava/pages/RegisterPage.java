package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage {
    private WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameField;

    @FindBy(id = "input-lastname")
    private WebElement lastNameField;

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-telephone")
    private WebElement phoneField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(id = "input-confirm")
    private WebElement confirmPassField;

    @FindBy(css = ".radio-inline input")
    private List<WebElement> subscribeField;

    @FindBy(css = ".pull-right input:nth-of-type(1)")
    private WebElement agreePolicy;

    @FindBy(css = ".pull-right .btn.btn-primary")
    private WebElement continueButton;

    @FindBy(css = ".btn.btn-primary")
    private WebElement continue2Button;

    @FindBy(css = ".list-group-item:nth-of-type(2)")
    private WebElement editAccount;

    @FindBy(css = "legend")
    private WebElement personalDetails;

    @FindBy(css = ".btn.btn-primary")
    private WebElement continueAccount;

    @FindBy(css = ".list-group-item:nth-of-type(1)")
    private WebElement myAccount;

    @FindBy(css = ".list-group-item:nth-of-type(13)")
    private WebElement logoutButton;


    public String addRegisterInfo(String firstName, String lastName, String email, String phone, String password, String option, String text) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
        passwordField.sendKeys(password);
        confirmPassField.sendKeys(password);
        for (WebElement elem : subscribeField) {
            if (elem.getText().equals(option)) elem.click();
        }
        agreePolicy.click();
        continueButton.click();
        continue2Button.click();
        editAccount.click();

        List<String> list = new ArrayList<String>();

        list.add(firstNameField.getAttribute("value"));
        list.add(lastNameField.getAttribute("value"));
        list.add(emailField.getAttribute("value"));
        list.add(phoneField.getAttribute("value"));

        String personalDet = String.join(" ", list);
        continueAccount.click();

        logoutButton.click();
        return personalDet;


    }
}
