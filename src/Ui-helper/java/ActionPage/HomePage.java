package ActionPage;

import LocatorPage.HomeLocatorPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends HomeLocatorPage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public int getTemp(){
        return Integer.parseInt(waitForElementToBeVisible(currentTemperatureBox).getText().replaceAll("℃","").replaceAll("°C","").trim());
    }
    public void buyMoisturizerOrSunscreen(){
        int temp = getTemp();

        if(temp<19){
            buyMoisturizerButton.click();
        }else if(temp>34){
            buySunscreenButton.click();
        }
    }
}
