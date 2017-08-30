import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage {
    private WebDriver webDriver;

    public AddressBookPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = ".//*[@id='content']/div[1]/table/tbody/tr/td[1]")
    private WebElement address;

    public WebElement checkAddress() {
        return address;
    }
}
