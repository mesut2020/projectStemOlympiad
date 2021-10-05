package utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ParentClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * class Constructor
     */
    public ParentClass(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        setImplicitlyWaitTimeoutTo(10);
    }

    public void setImplicitlyWaitTimeoutTo(int timeSeconds){
        driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
    }
    public WebElement getElement(By by){
        return driver.findElement(by);
    }

    public List<WebElement> getElements(By by){
        return driver.findElements(by);
    }
    /**
     *
     * @param by
     */
    public void clickTo(By by){
        waitToBeEnableFor(by);
        scrollTo(by);
        driver.findElement(by).click();
    }

    // ========== STALE ELEMENT EXCEPTION FIX METHOD  ==========//

    public void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public void clear(By by){
        waitToBeEnableFor(by);
        scrollTo(by);
        driver.findElement(by).clear();
    }

    public void sendKeysTo(By by, String textToSend){
        waitToBeEnableFor(by);
        scrollTo(by);
        driver.findElement(by).sendKeys(textToSend);
    }

    public void waitToBeExistFor(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitToBeVisibleFor(By by){
        waitToBeExistFor(by);
        scrollTo(by);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitToBeEnableFor(By by){
        waitToBeVisibleFor(by);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void scrollTo(WebElement element){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollTo(By by){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
    }

    public void scrollTo(By by, Boolean bool){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(" + bool + ");", driver.findElement(by));
    }

    public static void selectDropDownByIndex(WebDriver driver, WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void selectDropdownByVisibleText(WebDriver driver,WebElement element,String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    /**
     * Selects a random value from a dropdown list and returns the selected Web Element
     *
     * @param by
     * @return
     */
    public void selectRandomTextFromDropdown(By by) {
        Select select = new Select(driver.findElement(by));
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
    }

    public void selectTextFromDropdown(By by, String option) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(option);
    }

    //elementi methodun icine yazdigimizda js bu elemnte tiklar.
    public static void clickElementByJS(WebElement element){
        JavascriptExecutor jsExecutor =((JavascriptExecutor)Driver.getDriver());
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void clickElementByJS(By by){
        JavascriptExecutor jsExecutor =((JavascriptExecutor)Driver.getDriver());
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(by));
    }

    public static String date(){
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return formatter.format(now);
    }

    /**
     *
     * @param scenario
     */
    public static void screenShot(Scenario scenario){
        // Alinan resmin dosya adini duzenliyoruz: SenaryoAditarihsaat

        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File ekranDosyasi = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(ekranDosyasi, new File("target/failedScreenShots/" +
                    date() + "_" + scenario.getName() + "_" + Driver.browsers.get() +  ".png")); // chrome_Create country_20201021_014228.png
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
