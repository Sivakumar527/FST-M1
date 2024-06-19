package Projects_HRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7 {
    static WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//*[@id='txtPassword']"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        //--------- Login
        userName.sendKeys("orange");
        password.sendKeys("orangepassword123");
        loginBtn.click();
    }

    @Test(priority = 2)
    public void clickMyInfo() {

        WebElement myInfo = driver.findElement(By.cssSelector("a#menu_pim_viewMyDetails"));
        myInfo.click();

    }

    @Test(priority = 3)
    public void clickQualification() {
        WebElement myInfo = driver.findElement(By.cssSelector("a#menu_pim_viewMyDetails"));
        myInfo.click();
        WebElement qualification = driver.findElement(By.xpath("//*[@id = 'sidenav']/li/a[text()='Qualifications']"));
        qualification.click();
        WebElement add = driver.findElement(By.xpath("//*[@id = 'addWorkExperience']"));
        add.click();
        WebElement company = driver.findElement(By.xpath("//*[@id = 'experience_employer']"));
        company.sendKeys("IBM India");
        WebElement jobTitle = driver.findElement(By.xpath("//*[@id = 'experience_jobtitle']"));
        jobTitle.sendKeys("Test Specialist");
        driver.findElement(By.xpath("//*[@id = 'btnWorkExpSave']")).click();
    }


    @AfterClass
    public static void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
