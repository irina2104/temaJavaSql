package com.endava.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.core.Is.is;

public class ProductPage {
    private WebDriver webDriver;

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(id = "input-quantity")
    private WebElement qtyField;

    @FindBy(css = "input-option226 option")
    private List<WebElement> productColorInput;

    @FindBy(id = "button-cart")
    private WebElement addToCartButton;

    @FindBy(css = ".alert-dismissible a:nth-of-type(2)")
    private WebElement cart;

    @FindBy(id = "input-option226")
    private WebElement selectCanon;

    @FindBy(css = ".alert-success.alert-dismissible")
    private WebElement message;


    public void addToCart(String cant) {
        qtyField.clear();
        qtyField.sendKeys(cant);
        addToCartButton.click();
    }

    public void addToCart(String cant, String color) {

        selectCanonColor(color);
        qtyField.clear();
        qtyField.sendKeys(cant);
        addToCartButton.click();

    }

    public CartPage goToCart() {

        cart.click();
        return PageFactory.initElements(webDriver, CartPage.class);
    }


    private void selectCanonColor(String option) {
        Assert.assertThat(selectCanon.isDisplayed(), is(true));
        Select colorDropdown = new Select(selectCanon);
        colorDropdown.selectByVisibleText(option);

    }
}
