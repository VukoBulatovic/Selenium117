package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class ZadatakSreda1 {
    public static void main(String[] args) {

        //Otici na YouTube i pustiti jednu pesmu po Vasem izboru.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com/");

        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("2 pac changes");
        searchBox.submit();


        WebElement firstResult = driver.findElement(By.cssSelector("#contents > ytd-video-renderer:nth-child(1)"));
        firstResult.click();










    }
}
