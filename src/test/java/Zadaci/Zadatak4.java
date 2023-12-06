package Zadaci;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");


        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        String validUsername ="student";
        String validPassword ="Password123";

        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.sendKeys(validUsername);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String successfullLogInMessageText = "Logged In Successfully";

        WebElement actualLogInMessage = driver.findElement(By.className("post-title"));
        String actualLogInMessageText = actualLogInMessage.getText();

        Assert.assertEquals(actualLogInMessageText, successfullLogInMessageText);

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        String expectedLogOutMessage = "Log out";
        String actualLogOutMessage = logOutButton.getText();

        Assert.assertEquals(expectedLogOutMessage,actualLogOutMessage);

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL,actualURL);

        WebElement message = driver.findElement(By.className("has-text-align-center"));

        String expectedMessage = "Congratulations " + validUsername + ". You successfully logged in!";

        Assert.assertEquals(message.getText(),expectedMessage);






    }
}
