import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = ".//*[@id='input-email']")
    private WebElement emailField;

    @FindBy(xpath = ".//*[@id='input-password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='content']/div/div[2]/div/form/input")
    private WebElement loginButton;
    @FindBy(xpath = ".//*[@id='column-right']/div/a[13]")
    private WebElement logoutButton;

    @FindBy(xpath = ".//*[@id='column-right']/div/a[4]")
    private WebElement addressBook;

    @FindBy(xpath = ".//*[@id='logo']/h1/a")
    private WebElement yourStore;

    public void loginCredentials(String email, String pass) {
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        loginButton.click();
        //if(logoutButton.isDisplayed()) logoutButton.click();
    }

    public void logout() {
        if (logoutButton.isDisplayed()) logoutButton.click();
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
