package ActionPage;

import LocatorPage.ProductLocatorPage;
import org.openqa.selenium.WebDriver;

public class ProductPage extends ProductLocatorPage {
    WebDriver driver;

    public ProductPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public int getProductValue(int index){
        return Integer.parseInt(productValue.get(index).getText().replaceAll("[^0-9]", ""));
    }

    public String getProductName(int index){
        return productName.get(index).getText();
    }

    public void selectProductByName(String productName){
        waitForElementToBeVisible(productButtonByName(productName)).click();
    }

    public void clickOnCartButton(){
        waitForElementToBeClickable(cartButton).click();
    }

    public int getCartValue(){
        return Integer.parseInt(cartNumberOfAddedItem.getText().replaceAll("[^0-9]", ""));
    }

    public String addProductLowestPrizeContainName(String text){
        scrollDown();
        sleep(2);
        String productNameText="";
        int productPrize = 5000;

        for(int i= 0; i<productName.size();i++){
            if(getProductName(i).toLowerCase().contains(text.toLowerCase()) && productPrize>getProductValue(i)){
                productNameText = getProductName(i).trim();
                productPrize = getProductValue(i);
            }
        }
        System.out.println(productNameText + productPrize);
         selectProductByName(productNameText);
         if(getCartValue()==0){
             selectProductByName(productNameText);
         }
        return productNameText + productPrize;
    }
}
