package fitpeo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scroll_Down_to_the_Slider_section {

public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Fitpeo\\External\\chromedriver.exe");
    
    WebDriver driver = new ChromeDriver();
      
    driver.get("https://www.fitpeo.com/");
    
    driver.manage().window().maximize();
     Thread.sleep(3000);
    WebElement revenueCalculatorLink = driver.findElement(By.xpath("//header//a[@href='/revenue-calculator']"));
    
    revenueCalculatorLink.click();
    
    String sliderXPath ="//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-duk49p']";

    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement sliderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sliderXPath)));

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", sliderElement);
}
}
