package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity1 {
    WebDriverWait wait;
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test(priority = 1)
    public void multiplytest(){
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_6")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
        String resulttext=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.calculator2:id/result"))).getText();
        System.out.println(resulttext);
        Assert.assertEquals("54",resulttext);
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
