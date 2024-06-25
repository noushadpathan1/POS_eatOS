package com.qa.pages;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.CommonUtils;
import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage {
    private AppiumDriver driver;
    CommonUtils utils = new CommonUtils();

    public BasePage(){
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    public void threadSleep(int milliSec){
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void longwaitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.LongWAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public void clearText(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void clickOnElement(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void clickOnElement1(WebElement element)  {
        WebElement webElement = waitForElement(element);
        webElement.click();
    }

    public void clickOnElement(WebElement e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.click();
    }

    public void clickOnElement(By e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        driver.findElement(e).click();
    }

    public void typeTextIntoElement(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void typeTextIntoElement(WebElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.sendKeys(txt);
    }

    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    public void switchFrame(WebElement ele){
        try {
            driver.switchTo().frame(0);
        }catch (Exception e){
            e.getMessage();
        }
    }
    public String getAttributeValue(WebElement ele,String attribute){
        try{
            return ele.getAttribute(attribute);
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }
    public String getText(WebElement e, String msg) {
        String txt;
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }
        utils.log().info(msg + txt);
        return txt;
    }

    public String getText(By e, String msg) {
        String txt = switch (new GlobalParams().getPlatformName()) {
            case "Android" -> getAttribute(e, "text");
            case "iOS" -> getAttribute(e, "label");
            default -> throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        };
        utils.log().info(msg + txt);
        return txt;
    }
    public void closeApp() {
        if ("Android".equals(new GlobalParams().getPlatformName())) {
            ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                    getCapability("appPackage").toString());
        }
    }
    public void removeApp() {
        if ("Android".equals(new GlobalParams().getPlatformName())) {
            ((InteractsWithApps) driver).removeApp(driver.getCapabilities().
                    getCapability("appPackage").toString());
        }
    }
    public void launchApp() {
        if ("Android".equals(new GlobalParams().getPlatformName())) {
            ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                    getCapability("appPackage").toString());
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement andScrollToElementUsingUiScrollable(String childLocAttr, String childLocValue) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector()."+ childLocAttr +"(\"" + childLocValue + "\"));"));
    }

    public WebElement waitForVisibilityOfElement(WebElement element) {

        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }



        public WebElement waitForElement(WebElement element) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }
/*    public MobileElement scrollToElement(MobileElement element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if(!isFound){
            throw new Exception("Element not found");
        }
        return element;
    }

    public By scrollToElement(By element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if(!isFound){
            throw new Exception("Element not found");
        }
        return element;
    }*/

    public boolean find(final WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (element.isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public boolean find(final By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (driver.findElement(element).isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

/*    public void swipe(int startX, int startY, int endX, int endY, int millis)
            throws InterruptedException {
        TouchAction t = new TouchAction(driver);
        t.press(point(startX, startY)).waitAction(waitOptions(ofMillis(millis))).moveTo(point(endX, endY)).release()
                .perform();
    }*/

}
