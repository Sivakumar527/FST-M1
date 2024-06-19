package Projects_HRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class Activity9 {


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test(priority = 3)
    public void clickEmergencyContact() {
        WebElement emergencyContact = driver.findElement(By.xpath("//*[@id='sidenav']/li[3]/a"));
        emergencyContact.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test(priority = 4)
    public void getTableData() {
        WebElement tableElement = driver.findElement(By.xpath("//*[@id='emgcontact_list']"));
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

        for (WebElement row : rows) {

            List<WebElement> columns = row.findElements(By.tagName("td"));

            for (WebElement column : columns) {
                System.out.print(column.getText() + "\t");
            }
            System.out.println();
        }
    }

    @AfterClass
    public static void afterMethod() {
        //Close the browser
        driver.quit();
    }
}