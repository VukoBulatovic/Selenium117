package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5cEmptyPassword {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");


        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLogInPageLink = driver.findElement(By.linkText("Test Login Page"));
        testLogInPageLink.click();

        WebElement passwordInputField = driver.findElement(By.id("username"));
        passwordInputField.sendKeys("student");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.className("show"));
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);


    }
}
