package fitpeo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Navigate_to_the_Revenue_Calculator_Page {
    public static void main(String[] args) throws InterruptedException {
       {
          System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Fitpeo\\External\\chromedriver.exe");
            
            WebDriver driver = new ChromeDriver();
            
            
            driver.get("https://www.fitpeo.com/");
            
            driver.manage().window().maximize();
            WebElement revenueCalculatorLink = driver.findElement(By.xpath("//header//a[@href='/revenue-calculator']"));
            
            revenueCalculatorLink.click();
            Thread.sleep(3000);
             driver.quit();
       }
    }
}