package Zadaci;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak7 {
    public static void main(String[] args) {

        /*Zadatak 7
        https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
        Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

        WebElement cartBeforeAdding = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartBeforeAdding.getText(),"0");

        cartBeforeAdding.click();
        WebElement emptyCart = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
        Assert.assertTrue(emptyCart.isDisplayed());

        driver.navigate().back();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement itemAddedToCartMessage = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
        Assert.assertTrue(itemAddedToCartMessage.isDisplayed());

        WebElement cartAfterAdding = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartAfterAdding.getText(),"1");

        cartAfterAdding.click();
        WebElement itemInCart = driver.findElement(By.className("sc-list-item-content"));
        Assert.assertTrue(itemInCart.isDisplayed());


        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        WebElement emptyCartAfterRemoval = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
        Assert.assertTrue(emptyCartAfterRemoval.isDisplayed());

        WebElement cartAfterRemoval = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartAfterRemoval.getText(),"0");





    }
}
