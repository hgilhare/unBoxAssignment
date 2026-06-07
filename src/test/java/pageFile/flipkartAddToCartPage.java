package pageFile;

import helperFile.base;

import junit.framework.Assert;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Set;

public class flipkartAddToCartPage extends base {
    WebDriver driver;
    By globalSearchLocator = By.cssSelector("input.Pke_EE");
    String tenthPhoneName;
    String tenthPhonePrice;

    /**
     * This code will launch the Chrome browser and open the URLs.
     */

    public void useropenflipkartwebpage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
    }

    /**
     * This code will click on the global search bar.
     */

    public void userClickOnGlobalSearch() {
        waitforexpectedelement(globalSearchLocator, driver).click();
    }

    /**
     * This code will type 'mobile' and hit Enter.
     */
    public void userSearchWithTheKeywordMobile() {

        waitforexpectedelement(globalSearchLocator, driver).sendKeys("mobile");
        waitforexpectedelement(globalSearchLocator, driver).sendKeys(Keys.RETURN);
    }

    /**
     * This code will verify the search result and its text message
     */
    public void userVerifySearchResultForMobile() {

        String actualResponse = waitforexpectedelement(By.cssSelector("span.BUOuZu"), driver).getText();
        Assert.assertTrue(driver.findElement(By.cssSelector("span.BUOuZu")).isDisplayed());
        if (actualResponse.contains("Showing 1 – 24 of ") && actualResponse.contains("results for \"mobile\"")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    /**
     * This code will click on the compare checkbox for the 10th and 11th phones.
     */
    public void userClicksCompareCheckboxForTenthAndEleventhMobile() {
        List<WebElement> elements = driver.findElements(By.xpath("//label[@class='uu79Xy']"));
        elements.get(9).click();
        elements.get(10).click();
    }

    /**
     * This code will check the count in the compare tray.
     */
    public void userVerifyItemIsAddedToCompareTray() {

        String actualCount = waitforexpectedelement(By.xpath("//span[@class='PTbpe2 otPvkK lAMaJw']"), driver).getText();
        Assert.assertEquals("2", actualCount);
    }

    /**
     * This code will click on the 10th phone and open its webpage.
     */
    public void userClicksAndOpenedTenthPhone() {
        String firstWindowHandle = driver.getWindowHandle();
        List<WebElement> element = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        List<WebElement> priceElement = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
        element.get(9).click();
        tenthPhoneName = element.get(9).getText();
        tenthPhonePrice = priceElement.get(9).getText();
        Set<String> handles = driver.getWindowHandles();
        for (String s : handles) {
            if (!(s == firstWindowHandle)) {
                driver.switchTo().window(s);
            }
        }
    }

    /**
     * This code will click on the 'Add to Cart' button and verify the 'Going to Cart' text
     */
    public void userClicksOnAddToCartButton() {


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement ele;
        try {
            ele = driver.findElement(By.xpath("//button[@class='QqFHMwp vslbG+ In9uk2 JTo6b7']"));
        } catch (Exception e) {
            ele = null;
        }

        if (ele == null) {
            waitforexpectedelement(By.xpath("//button[contains(@class, 'QqFHMw vslbG+ In9uk2')]"), driver).click();


            String gotocartText = waitforexpectedelement(By.xpath("//button[contains(@class, 'QqFHMw vslbG+ In9uk2')]"), driver).getText();


            if (!(gotocartText == null)) {
                Assert.assertEquals("GOING TO CART", gotocartText);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            ele.click();
        }


    }

    /**
     * This code will verify the item on cart that was added from the mobile list
     */
    public void userVerifyItemIsAddedToCart() {

        String actualPhoneName = waitforexpectedelement(By.xpath("//div[@class='gE4Hlh']"), driver).getText();
        Assert.assertEquals(tenthPhoneName, actualPhoneName);
    }

    /**
     * This code will verify the price from the mobile list to the total amount appearing in the cart.
     */
    public void userVerifyTotalAmountIsSame() {

        String totalAmount = waitforexpectedelement(By.xpath("(//div[@class='_1Y9Lgu'])[2]"), driver).getText();
        Assert.assertEquals(tenthPhonePrice, totalAmount);
    }

    /**
     * This code will increase the product quantity and verify the pop-up message
     */
    public void userIncreaseProductQtyByOneAndVerifyPopUpMessageDisplayed() {

        waitforexpectedelement(By.xpath("(//button[@class='LcLcvv' and text()='+'] )"), driver).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement popup = driver.findElement(By.xpath("//div[@class='eIDgeN']"));
        Assert.assertTrue(popup.isDisplayed());
        String expectedPopUpText = "You've changed '" + tenthPhoneName + "' QUANTITY to '2'";
        Assert.assertEquals(expectedPopUpText, popup.getText());
    }

    /**
     * This code will remove the product and verify the empty screen message.
     */
    public void userRemoveProductAndVerifyEmptyScreen() {

        clickbyJavascriptExecutor(By.xpath("(//div[@class='sBxzFz'])[2]"), driver);

        waitforexpectedelement(By.xpath("//div[@class='sBxzFz fF30ZI A0MXnh']"), driver).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualMissingtext = waitforexpectedelement(By.xpath("//div[@class='s2gOFd']"), driver).getText();


        String actualLoginText = waitforexpectedelement(By.xpath("//div[@class='orqM3-']"), driver).getText();
        Assert.assertEquals("Missing Cart items?", actualMissingtext);
        Assert.assertEquals("Login to see the items you added previously", actualLoginText);
        driver.quit();
    }


}
