package Domaci;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ZadatakPetak1 {

    WebDriver driver;


    @BeforeMethod
    public void goToPage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
    }


    @Test
    public void verifyThatUserCanNotLogInUsingEmptyInputField(){

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @Test
    public void verifyThatUserCanNotLogInUsingEmptyUsername() throws InterruptedException {


        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("error"));
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @Test
    public void verifyThatUserCanNotLogInUsingEmptyPassword() throws InterruptedException {

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("error"));
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @Test
    public void verifyThatUserCanNotLogInUsingInvalidUsername(){

        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.sendKeys("blabla123");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @Test
    public void verifyThatUserCanNotLogInUsingInvalidPassword() throws InterruptedException {

        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.sendKeys("student");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("blabla55");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("error"));
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }

    @Test
    public void verifyThatUserCanLogOut(){

        String validUsername ="student";
        String validPassword ="Password123";

        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.sendKeys(validUsername);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton.isDisplayed());
        submitButton.click();
        String successfullLogInMessageText = "Logged In Successfully";

        WebElement actualLogInMessage = driver.findElement(By.className("post-title"));
        String actualLogInMessageText = actualLogInMessage.getText();

        Assert.assertEquals(actualLogInMessageText, successfullLogInMessageText);

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        logOutButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void verifyUserCanLogInUsingValidInputs(){


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
    }







}
