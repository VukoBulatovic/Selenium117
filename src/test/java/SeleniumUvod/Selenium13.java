package SeleniumUvod;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selenium13 {

    WebDriver driver;
    String baseURL;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void verifyThatUserCanLogIn(){

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.clear();
        username.sendKeys("student");
        password.clear();
        password.sendKeys("Password123");
        submitButton.click();

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @Test
    public void verifyThatUserCannotLogIn(){

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.clear();
        username.sendKeys("000");
        password.clear();
        password.sendKeys("Password123");
        submitButton.click();

        /*WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertFalse(logoutButton.isDisplayed());*/
        boolean logOut = false;
        try{
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        }catch (Exception e){
            System.out.println("Element not fount");
        }
        Assert.assertFalse(logOut);


    }









}
