import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.hamcrest.core.Is.is;

public class HomePageTest extends FirstTest {


    @Test
    public void registerTest() {
        RegisterPage registerPage = homePage.register("Register");
        Assert.assertEquals("Irina Magureanu irinamagureanu@yahoo.com 0758636827",
                registerPage.addRegisterInfo("Irina", "Magureanu", "irinamagureanu@yahoo.com",
                        "0758636827", "Password1*", "No", "Logout"));
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = homePage.login("Login");
        loginPage.loginCredentials("irinamagureanu@yahoo.com", "Password1*");
        loginPage.logout();

    }

    @Test
    public void addAddressBook() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mariadb://192.168.164.15:3306/bitnami_opencart", "root", "root");
        Statement stmt = connection.createStatement();
        String query = "insert into oc_address()" + "values(null,(select customer_id from oc_customer where email='irinamagureanu@yahoo.com'),'Irina','Magureanu','Endava','address1','address2','Bucharest',603010,(select country_id from oc_country where name='Romania'),53,0)";
        stmt.executeUpdate(query);
        stmt.close();
        connection.close();

        LoginPage loginPage = homePage.login("Login");
        loginPage.loginCredentials("irinamagureanu@yahoo.com", "Password1*");

        AddressBookPage addressBookPage = loginPage.goToAddressBook();
        Assert.assertThat(addressBookPage.checkAddress().isDisplayed(), is(true));
        System.out.println(addressBookPage.checkAddress().getText());

        loginPage.logout();
    }

    @Test
    public void productSelection() throws SQLException {
        LoginPage loginPage = homePage.login("Login");
        loginPage.loginCredentials("irinamagureanu@yahoo.com", "Password1*");
        loginPage.goToYourStore();

        ProductPage productPage = homePage.selectProduct("MacBook");
        String quantity = "1";
        productPage.addToCart(quantity);

        Connection connection = DriverManager.getConnection("jdbc:mariadb://192.168.164.15:3306/bitnami_opencart", "root", "root");
        Statement stmt = connection.createStatement();
        String query = "update oc_cart set quantity = quantity+1";
        stmt.executeUpdate(query);
        stmt.close();
        connection.close();

        CartPage cartPage = productPage.goToCart();
        cartPage.verifyCart();
        System.out.println(cartPage.verifyCart());
        Assert.assertEquals(String.valueOf(Integer.parseInt(quantity) + 1), cartPage.verifyCart());

        cartPage.logout();

    }

}
