package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    private WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(css = ".input-group.btn-block input")
    private WebElement quantityy;

    @FindBy(css = ".input-group.btn-block .btn.btn-primary")
    private WebElement refreshButton;

    @FindBy(css = ".list-inline .dropdown-toggle")
    private WebElement myAccount;

    @FindBy(css = ".dropdown-menu li:nth-of-type(5) a")
    private WebElement logoutButton;

    public String verifyCart() {
        return quantityy.getAttribute("value");
    }

    public void logout() {
        myAccount.click();
        logoutButton.click();
    }
}
