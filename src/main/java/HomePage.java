import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.core.Is.is;

public class HomePage {
    private WebDriver webDriver;

    @FindBy(xpath = ".//*[@id='top-links']/ul/li[2]")
    private WebElement myAccount;
    @FindBy(xpath = ".//*[@id='top-links']/ul/li[2]/ul")
    private WebElement myAccountBlock;
    @FindBy(xpath = ".//*[@id='top-links']/ul/li[2]/ul/li/a")
    private List<WebElement> myAccountMenu;

    @FindBy(xpath = ".//*[@id='content']/div[2]/div/div/div[2]/h4/a")
    private List<WebElement> products;


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public RegisterPage register(String option) {
        myAccount.click();
        Assert.assertThat(myAccountBlock.isDisplayed(), is(true));
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
        Assert.assertThat(myAccountBlock.isDisplayed(), is(true));
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
