package com.endava.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage {
    private WebDriver webDriver;

    @FindBy(css = ".list-inline .dropdown-toggle")
    private WebElement myAccount;
    @FindBy(css = ".dropdown-menu.dropdown-menu-right")
    private WebElement myAccountBlock;
    @FindBy(css = ".dropdown-menu.dropdown-menu-right li a")
    private List<WebElement> myAccountMenu;

    @FindBy(css = ".caption h4 a")
    private List<WebElement> products;


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public RegisterPage register(String option) {
        myAccount.click();
        for (WebElement elem : myAccountMenu) {
            if (elem.getText().equals(option)) {
                elem.click();
                break;
            }
        }
        return PageFactory.initElements(webDriver, RegisterPage.class);
    }

    public LoginPage login(String option) {
        myAccount.click();
        for (WebElement elem : myAccountMenu) {
            if (elem.getText().equals(option)) {
                elem.click();
                break;
            }
        }
        return PageFactory.initElements(webDriver, LoginPage.class);
    }


    public ProductPage selectProduct(String prod) {
        for (WebElement product : products) {
            if (product.getText().equals(prod)) {
                product.click();
                break;
            }
        }
        return PageFactory.initElements(webDriver, ProductPage.class);
    }
}
