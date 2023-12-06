package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium7 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://crop-circle.imageonline.co/#circlecropresult");

        String imageLocation = "D:\\Users\\Bulatovic Vuko\\Desktop\\selenium.jpg";

        WebElement inputImage = driver.findElement(By.id("inputImage"));
        inputImage.sendKeys(imageLocation);

        //Kod za skrol

        //WebElement element = driver.findElement(By.id("id_of_element"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);




    }
}
