package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");   //otvaranje novog blanko taba
        js.executeScript("window.open()");   // otvaranje jos jednog
        js.executeScript("window.open()");   // jos jednog taba


        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(1));   //bacamo focus na drugi tab
        driver.navigate().to("https://www.linkedin.com/");

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.joberty.com/");

        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.youtube.com");

        driver.close();

        driver.switchTo().window(listaTabova.get(2));
        driver.close();

        driver.switchTo().window(listaTabova.get(1));
        driver.close();

        driver.switchTo().window(listaTabova.get(0));
        driver.close();

        //ovako izgledaju indeksi tabova
        //0
        //0 - 1
        //0 - 2 - 1
        //0 - 3 - 2 - 1





    }
}
