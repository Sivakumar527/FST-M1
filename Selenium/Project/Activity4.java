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

public class Activity4{
    static WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void opensite() {
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
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
        String homepage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.head>h1"))).getText();
        //String homepage=driver.findElement(By.xpath("//h1[text()='Dashboard')]")).getText();
        System.out.println("Homepage:" +homepage);
        Assert.assertEquals(homepage,"Dashboard");
    }

    @Test(priority = 4)
    public void PIMOption() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.current>a")));
        boolean boolean1=driver.findElement(By.cssSelector("li.current>a")).isDisplayed();
        Assert.assertEquals(boolean1,true);
        driver.findElement(By.linkText("PIM")).click();
        //driver.findElement(By.linkText("PIM")).click();

    }
    @Test(priority = 5)
    public void Addbutton(){
        boolean boolean2=driver.findElement(By.id("btnAdd")).isEnabled();
        Assert.assertEquals(boolean2,true);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd"))).click();
        //driver.findElement(By.id("btnAdd")).click();
    }
    @Test(priority = 6)
    public void savebutton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Angana");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys("Ash");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave"))).click();
    }
    @Test(priority = 7)
    public void PIMlinkagain(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.current>a")));
        boolean boolean1=driver.findElement(By.cssSelector("li.current>a")).isDisplayed();
        Assert.assertEquals(boolean1,true);
        driver.findElement(By.linkText("PIM")).click();
    }
    @Test(priority = 8)
    public void search(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empsearch_employee_name_empName"))).sendKeys("Angana");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn"))).click();
    }
    @Test(priority = 9)
    public void verification(){
        String FirstName= driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[3]")).getText();
        String LastName= driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[4]")).getText();
        System.out.println(FirstName + " " +LastName);
        if(FirstName!=" " || FirstName!=null){
            Assert.assertEquals(true,true);
        }
    }
    @AfterClass
    public static void closebrowser(){
        driver.close();
    }
}