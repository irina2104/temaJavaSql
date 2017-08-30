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

    @FindBy(xpath = ".//*[@id='input-quantity']")
    private WebElement qtyField;

    @FindBy(xpath = ".//*[@id='input-option226']")
    private List<WebElement> productColorInput;

    @FindBy(xpath = ".//*[@id='button-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = ".//*[@id='top-links']/ul/li[4]/a")
    private WebElement cart;

    @FindBy(xpath = ".//h1[text()='Canon EOS 5D']/../div[@id='product']/div/select")
    private WebElement selectCanon;

    @FindBy(xpath = ".//*[@id='product-product']/div[1]")
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
