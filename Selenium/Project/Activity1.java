package Projects_HRM;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
    static WebDriver driver;
    @BeforeClass
    public static void opensite(){
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void gettitle(){
        String title=driver.getTitle();
        System.out.println(title);
        if(title.equalsIgnoreCase("OrangeHRM")){
            driver.close();
        }
    }

}