package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");

        //Hijerarhija lokatora/selektora

        //id                ==  najmanje podlozan pormenama i jedinstven element
        //name              ==
        //class
        //cssSelector
        //relative xpath
        //apsolute xpath

        WebElement searchBoxByID = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxByName = driver.findElement(By.name("q"));
        WebElement searchBoxByClass = driver.findElement(By.className("gLFyf"));
        WebElement searchBoxByCss = driver.findElement(By.cssSelector("textarea[type='search']"));
        WebElement searchBoxByRelativeXpath = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        WebElement searchBoxByAsoluteXpath = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));










    }
}
