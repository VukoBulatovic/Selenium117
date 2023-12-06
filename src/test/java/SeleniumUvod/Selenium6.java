package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium6 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in","dragoljubqa%7C1796316794%7CzB9JB7VtJuy13jM3x5saaTgNQCAVBsJayMZpl0tEVLO%7Cb44d8e4f9307dfd35a344652f41d41b3eedcf45a6b954d00af790043f73382b8");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();





    }
}
