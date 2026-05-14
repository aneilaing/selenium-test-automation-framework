package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By cartItemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }
}