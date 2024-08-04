package fitpeo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adjust_the_Slider {
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
    
    WebElement sliderThumb = driver.findElement(By.xpath("//span[contains(@class, 'MuiSlider-thumb') and contains(@class, 'css-sy3s50')]"));
    WebElement sliderRail = driver.findElement(By.xpath("//span[@class='MuiSlider-rail css-3ndvyc']"));

    js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", sliderThumb);

    try {
        Thread.sleep(1000); 
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    int railWidth = sliderRail.getSize().getWidth();

    int minValue = 0;
    int maxValue = 2000;
    int desiredValue = 820; 
    int valueRange = maxValue - minValue;
    double pixelsPerValue = (double) railWidth / valueRange;
    int desiredPixelOffset = (int) Math.round((desiredValue - minValue) * pixelsPerValue);
    System.out.println(desiredPixelOffset);
    Actions actions = new Actions(driver);
    actions.clickAndHold(sliderThumb).moveByOffset(-sliderThumb.getLocation().getX(), 0).release().perform();
    actions.clickAndHold(sliderThumb).moveByOffset(desiredPixelOffset, 0).release().perform();
    WebElement sliderInput = driver.findElement(By.xpath("//span[contains(@class, 'MuiSlider-thumb') and contains(@class, 'css-sy3s50')]/input"));
    String sliderValue = sliderInput.getAttribute("value");
    System.out.println("Initial Slider value: " + sliderValue);
    

}
}
