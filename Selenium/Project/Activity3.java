package Projects_HRM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3 {
    static WebDriver driver;

    @BeforeClass
    public static void opensite() {
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void login(){
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test(priority = 2)
    public void homepagetitle(){
        String title=driver.getTitle();
        System.out.println("Title:" +title);

    }
    @Test(priority = 3)
    public void homepage(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        String homepage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.head>h1"))).getText();
        //String homepage=driver.findElement(By.xpath("//h1[text()='Dashboard')]")).getText();
        System.out.println("Homepage:" +homepage);
        Assert.assertEquals(homepage,"Dashboard");
    }
    @AfterClass
    public static void closebrowser(){
        driver.close();
    }
}