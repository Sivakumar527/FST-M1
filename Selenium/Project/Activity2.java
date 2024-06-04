package Projects_HRM;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2 {
    static WebDriver driver;
    @BeforeClass
    public static void opensite(){
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().window().maximize();
    }
    @Test
    public void getimageurl(){
        String imageURL=driver.findElement(By.xpath("//div[@id='divLogo']/img")).getAttribute("src").toString();
        System.out.println(imageURL);

    }
    @AfterClass
    public static void closebrowser(){
        driver.close();
    }
}
