package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {
// System.setProperty("webdriver.chrome.driver","driber-lib\\chromedriver.exe"); --depricated (zastarelo)


        WebDriverManager.chromedriver().setup(); //setujemo chrome driver
        WebDriver driver = new ChromeDriver();  //kreiramo objekat od chrome drivera
        driver.manage().window().maximize();
        //driver.get("https://www.google.com"); //dajemo komandu driveru na koji link da ode
        driver.navigate().to("https://www.google.com"); //moze i ovako isto je
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.youtube.com");
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().forward();
        driver.quit(); //zatvara sve
        // driver.close(); //zatvara samo tu stranicu












    }
}
