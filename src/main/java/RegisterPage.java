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

    @FindBy(xpath = ".//*[@id='input-firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = ".//*[@id='input-lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = ".//*[@id='input-email']")
    private WebElement emailField;

    @FindBy(xpath = ".//*[@id='input-telephone']")
    private WebElement phoneField;

    @FindBy(xpath = ".//*[@id='input-password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='input-confirm']")
    private WebElement confirmPassField;

    @FindBy(xpath = ".//*[@id='content']/form/fieldset[3]/div/div/label/input")
    private List<WebElement> subscribeField;

    @FindBy(xpath = ".//*[@id='content']/form/div/div/input[1]")
    private WebElement agreePolicy;

    @FindBy(xpath = ".//*[@id='content']/form/div/div/input[2]")
    private WebElement continueButton;

    @FindBy(xpath = ".//*[@id='content']/div/div/a")
    private WebElement continue2Button;

    @FindBy(xpath = ".//*[@id='content']/ul[1]/li[1]/a")
    private WebElement editAccount;

    @FindBy(xpath = ".//*[@id='content']/form/fieldset/legend")
    private WebElement personalDetails;

    @FindBy(xpath = ".//*[@id='content']/form/div/div[2]/input")
    private WebElement continueAccount;

    @FindBy(xpath = ".//*[@id='top-links']/ul/li[2]/a")
    private WebElement myAccount;

    @FindBy(xpath = ".//*[@id='top-links']/ul/li[2]/ul")
    private WebElement myAccountBlock;

    @FindBy(xpath = ".//*[@id='top-links']/ul/li[2]/ul/li/a")
    private List<WebElement> myAccountOptions;

    @FindBy(xpath = ".//*[@id='column-right']/div/a[13]")
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
