package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static Project.ActionsBase.doSwipe;

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);


        driver.get("https://v1.training-support.net/selenium");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void webAppTest() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));
        Dimension dims = driver.manage().window().getSize();
        Point start = new Point((int)(dims.getWidth()*0.5),(int)(dims.getHeight()*0.8));
        Point end = new Point((int)(dims.getWidth()*0.5),(int)(dims.getHeight()*0.6));

        doSwipe(driver, start, end, 50);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText")));
        //driver.findElement(AppiumBy.className("android.widget.EditText")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("Task1");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Task1\"]")));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Task1\"]")).isDisplayed());
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Clear List\"]")).click();


    }
}
