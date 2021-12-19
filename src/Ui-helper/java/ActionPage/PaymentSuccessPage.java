package ActionPage;

import LocatorPage.PaymentSuccessLocatorPage;
import org.openqa.selenium.WebDriver;

public class PaymentSuccessPage extends PaymentSuccessLocatorPage {
    WebDriver driver;

    public PaymentSuccessPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
