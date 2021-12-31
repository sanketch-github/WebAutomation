package WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static final String dir = System.getProperty("user.dir");

    public synchronized static WebDriver startBrowser(String browser){
        WebDriver driver = null;

        if(browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized","--disable-extensions","--no-sandbox","--disable-application-cache","--disable-gpu","--disable-dev-shm-usage");
            driver = new FirefoxDriver(options);
        }else if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            driver = new ChromeDriver(chromeOptions);
        }
        driver.get("https://weathershopper.pythonanywhere.com/");
        driver.manage().window().maximize();
        return driver;
    }

}
