package TestCases;

import ActionPage.CheckoutPage;
import ActionPage.HomePage;
import ActionPage.PaymentSuccessPage;
import ActionPage.ProductPage;
import BaseTest.BaseTest;
import WebDriverManager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestWeatherShopper extends BaseTest {

    HomePage homePage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    PaymentSuccessPage paymentSuccessPage;
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @BeforeMethod()
    @Parameters("browser")
    public void methodSetup(@Optional("Firefox") String browser){
        driver.set(WebDriverManager.startBrowser(browser));
        homePage = new HomePage(driver.get());
        productPage = new ProductPage(driver.get());
        checkoutPage =new CheckoutPage(driver.get());
        paymentSuccessPage =new PaymentSuccessPage(driver.get());
    }
    /***************************************************************************
     * @TestCaseTitle Verify product buy flow
     * @Steps
     *       When: Go to link
     *       Then: Home Page will load
     *       When: Check Temp if Temp is less then 19 click on buy Moisturizer if Temp grater then 34 Click on buy Sunscreen
     *       Then: Product Page will load with product
     *       When: Add 2 least Prized product by given text
     *       Then: Product gets selected and verify cart count should show correct product selection
     *       When: Click on Cart button
     *       Then: Checkout page will load with select product
     *             Verify Product selected are correct and product amount and total amount is correct
     *       When: Click On Pay With Card
     *       Then: Card Payment PopUp will load
     *       When: Enter card detail and click on pay
     *       Then: Payment Success page will load
     *             Verify Payment Success msg
     *
     * @author  Sanket Chaudhari
     * @version 1.0
     * @since   2021-12-19
     ***************************************************************************/
    @Test(priority = 0)
    public void testCase_C01(){
        int temp = homePage.getTemp();

        //Check Temp and select buying option suitable for that temp
        homePage.buyMoisturizerOrSunscreen();
        //Temp Buying logic
        if(temp<19) {
            //Common reusable method for Product Buying Flow test verification
            verifyProductBuyFlow("aloe","almond");
        }
        if(temp>34){
            //Common reusable method for Product Buying Flow test verification
            verifyProductBuyFlow("spf-50","spf-30");
        }
    }

    public void verifyProductBuyFlow(String product1,String product2){

        //Add 2 least prize product by given text and store the name and value
        String productNamePrize1 = productPage.addProductLowestPrizeContainName(product1);
        String productNamePrize2 = productPage.addProductLowestPrizeContainName(product2);

        //Assert 2 products are added in cart
        Assert.assertTrue(productPage.getCartValue()==2);

        //Click On Cart Button and move to Checkout page
        productPage.clickOnCartButton();
        String productName1=productNamePrize1.substring(0, productNamePrize1.length()-3).trim();
        String productName2=productNamePrize2.substring(0, productNamePrize2.length()-3).trim();
        int productPrize1=Integer.parseInt(productNamePrize1.substring(productNamePrize1.length() - 3).trim());
        int productPrize2=Integer.parseInt(productNamePrize2.substring(productNamePrize2.length() - 3).trim());

        //Assert Product Selection
        Assert.assertTrue(checkoutPage.isProductNameAndValuePresent(productName1,productPrize1+""));
        Assert.assertTrue(checkoutPage.isProductNameAndValuePresent(productName2,productPrize2+""));

        //Assert The total amount
        Assert.assertTrue(checkoutPage.getTotalAmount()==(productPrize1+productPrize2));

        //Click on Pay With Card Button
        checkoutPage.clickOnPayWithCardButton();

        //Add Payment Details in Payment Popup
        checkoutPage.addCardDetails("Testing@gmla.com","4242424242424242","1230","123","123456");

        //Assert Total Amount in pay button
        Assert.assertTrue(checkoutPage.paymentButton.getText().contains((productPrize1+productPrize2)+".00"));
        checkoutPage.clickOnPaymentButton();

        //Assert Payment Successful msg text
        Assert.assertTrue(paymentSuccessPage.waitForTestToBePresent(paymentSuccessPage.paymentSuccessText,"PAYMENT SUCCESS"));
        Assert.assertTrue(paymentSuccessPage.waitForTestToBePresent(paymentSuccessPage.paymentSuccessMessageText,"Your payment was successful. You should receive a follow-up call from our sales team."));
    }

    @AfterMethod()
    public void methodCleanup(){
        driver.get().quit();
    }
}
