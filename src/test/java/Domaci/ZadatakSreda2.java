package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ZadatakSreda2 {
    public static void main(String[] args) {

        //https://demoqa.com/text-box napisati test case za dati text box

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");

        String validUsernameInput = "Ivana";
        String validEmailInput = "ivandd1@gmail.com";
        String validCurrentAddressInput = "Srejovica 64";
        String validPermamentAddressInput = "Aracica Broza br 4";


        WebElement usernameField = driver.findElement(By.id("userName"));
        usernameField.sendKeys(validUsernameInput);

        WebElement passwordField = driver.findElement(By.id("userEmail"));
        passwordField.sendKeys(validEmailInput);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(validCurrentAddressInput);

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(validPermamentAddressInput);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

//provjera postojanosti box-a sa prikazima

        WebElement textBox = driver.findElement(By.cssSelector("#output > div"));
        Assert.assertTrue(textBox.isDisplayed());


//provjera prikaza vec unesenih unosa

        WebElement outPutResult = driver.findElement(By.id("output"));
        String actualOutPutResult = outPutResult.getText();
        String expectedOutPutResult =
                "Name:" + validUsernameInput + "\n" +
                "Email:" + validEmailInput + "\n" +
                "Current Address :" + validCurrentAddressInput + "\n" +
                "Permananet Address :" + validPermamentAddressInput;

        Assert.assertEquals(actualOutPutResult,expectedOutPutResult);
















    }
}
