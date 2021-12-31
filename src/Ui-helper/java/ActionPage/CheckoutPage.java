package ActionPage;

import LocatorPage.CheckoutLocatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends CheckoutLocatorPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public int getTotalAmount(){
        return Integer.parseInt(waitForElementToBeVisible(totalAmount).getText().replaceAll("[^0-9]", "").trim());
    }

    public void clickOnPayWithCardButton(){
        waitForElementToBeClickable(payWithCardButton).click();
    }

    public void sendKeyInField(WebElement webElement,String text){
        waitForElementToBeVisible(webElement).click();
        for (int i = 0 ; i<text.length();i++) {
            waitForElementToBeVisible(webElement).sendKeys(text.charAt(i)+"");
        }
    }

    public void addCardDetails(String email,String cardNumber,String date,String cvc,String zipCode) {
        driver.switchTo().frame(0);
        sendKeyInField(paymentPopUpEmailTextTestField, email);
        sendKeyInField(paymentPopUpCardTextField, cardNumber);
        sendKeyInField(paymentPopUpDateTextField, date);
        sendKeyInField(paymentPopUpCVCTextField, cvc);
        sendKeyInField(paymentPopUpZipCodeTextField, zipCode);
    }

    public void clickOnPaymentButton(){
        waitForElementToBeVisible(paymentButton).click();
        driver.switchTo().defaultContent();
    }

    public boolean isProductNameAndValuePresent(String productName,String productPrize){
        for(int i = 0;i<productNameList.size();i++){
            if(productNameList.get(i).getText().contains(productName) && productPrizeList.get(i).getText().contains(productPrize)){
                return true;
            }
        }
        return false;
    }

}
