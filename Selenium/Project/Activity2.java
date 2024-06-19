package Projects_HRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Activity2 {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();;
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void getTitle() {
        WebElement image = driver.findElement(By.xpath("//div[@id = 'divLogo']/img"));
        String src = image.getAttribute("src");
        System.out.println("SRC is---"+src);
    }

    @AfterClass
    public static void afterMethod() {
        //Close the browser
        driver.quit();
    }
}


