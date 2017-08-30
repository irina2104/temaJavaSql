import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    private WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = ".//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input")
    private WebElement quantityy;

    @FindBy(xpath = ".//*[@id='content']/form/div/table/tbody/tr/td[4]/div/span/button[1]")
    private WebElement refreshButton;

    @FindBy(xpath = ".//*[@id='top-links']/ul/li[2]")
    private WebElement myAccount;

    @FindBy(xpath = ".//*[@id='top-links']/ul/li[2]/ul/li[5]/a")
    private WebElement logoutButton;

    public String verifyCart() {
        return quantityy.getAttribute("value");
    }

    public void logout() {
        myAccount.click();
        logoutButton.click();
    }
}
