package WebDriverManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverManager {

    public static final String dir = System.getProperty("user.dir");

    public synchronized static WebDriver startBrowser(String browser){
        WebDriver driver = null;

        if(browser.equalsIgnoreCase("Firefox")){
            if(Platform.getCurrent().is(Platform.WINDOWS)){
                System.setProperty("webdriver.gecko.driver",dir+"\\src\\TestData\\resources\\Driver\\geckodriver.exe");
            }if(Platform.getCurrent().is(Platform.MAC)){
                System.setProperty("webdriver.gecko.driver",dir+"/src/TestData/resources/Driver/geckodriverMac");
            }if(Platform.getCurrent().is(Platform.LINUX)){
                System.setProperty("webdriver.gecko.driver",dir+"/src/TestData/resources/Driver/geckodriverLinux");
            }
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized","--disable-extensions","--no-sandbox","--disable-application-cache","--disable-gpu","--disable-dev-shm-usage");
            driver = new FirefoxDriver(options);
        }else if(browser.equalsIgnoreCase("Chrome")){
            if(Platform.getCurrent().is(Platform.WINDOWS)){
                System.setProperty("webdriver.chrome.driver",dir+"\\src\\TestData\\resources\\Driver\\chromedriver.exe");
            }if(Platform.getCurrent().is(Platform.MAC)){
                System.setProperty("webdriver.chrome.driver",dir+"/src/TestData/resources/Driver/chromedriverMac");
            }if(Platform.getCurrent().is(Platform.LINUX)){
                System.setProperty("webdriver.chrome.driver",dir+"/src/TestData/resources/Driver/chromedriverLinux");
            }

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            driver = new ChromeDriver(chromeOptions);
        }
        driver.get("https://weathershopper.pythonanywhere.com/");
        driver.manage().window().maximize();
        return driver;
    }

}
