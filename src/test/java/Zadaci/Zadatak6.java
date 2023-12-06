package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://wordpress.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        //sleepers  --ceka onoliko koliko mu se zada, koristimo da izklikcemo recaptcha
        //implicit wait --ceka koliko mu se zada dok ne pojavi gresku tipa no such element odnosno kad ne moze da nadje
        //explicit wait --kada nesto iskljucivo cekamo da se desi
        //fluid wait --kombinacija implicitnog i explicitnog


        WebElement logInButton = driver.findElement(By.linkText("Log In"));
        logInButton.click();

        String validUsername = "dragoljubqa";
        String validPassword = "Swordfish123!@#";
        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        usernameField.clear();
        usernameField.sendKeys(validUsername);

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();

        //Thread.sleep(3000);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(validPassword);

        WebElement continueButton1 = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton1.click();

       // Thread.sleep(3000);

        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/dragoljubqa.wordpress.com"));

        //kad stavio wdwait nema smisla asertacija
        //String expectedURL = "https://wordpress.com/home/dragoljubqa.wordpress.com";
        //Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

       // Thread.sleep(3000);
        WebElement profileButton = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me"));
        profileButton.click();

       // Thread.sleep(3000);
        WebElement profileName = driver.findElement(By.className("profile-gravatar__user-display-name"));
        String profileNameText = profileName.getText();
        Assert.assertEquals(profileNameText,validUsername);


        WebElement logOutButton = driver.findElement(By.className("sidebar__me-signout-text"));
        Assert.assertTrue(logOutButton.isDisplayed());









    }
}
