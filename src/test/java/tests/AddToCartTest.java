package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void userShouldAddItemToCartSuccessfully() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(productsPage.getPageTitle(), "Products");

        productsPage.addBackpackToCart();
        productsPage.openCart();

        Assert.assertEquals(
                cartPage.getCartItemName(),
                "Sauce Labs Backpack"
        );
    }
}
