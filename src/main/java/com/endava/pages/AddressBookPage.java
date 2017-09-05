package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage {
    private WebDriver webDriver;

    public AddressBookPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(css = ".table-responsive tr:first-of-type .text-left")
    private WebElement address;

    public WebElement checkAddress() {
        return address;
    }
}
