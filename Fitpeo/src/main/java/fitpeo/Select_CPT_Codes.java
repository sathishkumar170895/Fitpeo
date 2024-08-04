package fitpeo;



import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Select_CPT_Codes {
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
      List<String> valuesToCheck = Arrays.asList("CPT-99091","CPT-99453","CPT-99454","CPT-99474");
      for (String value : valuesToCheck) {
          WebElement paragraph = driver.findElement(By.xpath("//p[contains(text(), '" + value + "')]"));
          WebElement parentDiv = paragraph.findElement(By.xpath("./ancestor::div[@class='MuiBox-root css-4o8pys']"));
          WebElement checkbox = parentDiv.findElement(By.xpath(".//input[@type='checkbox' and @class='PrivateSwitchBase-input css-1m9pwf3']"));
          if (!checkbox.isSelected()) {
              checkbox.click();
          }
      }

     
}
}
