package fitpeo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Update_the_Text_Field {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Fitpeo\\External\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
      
    driver.get("https://www.fitpeo.com/");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    WebElement revenueCalculatorLink = driver.findElement(By.xpath("//header//a[@href='/revenue-calculator']"));
    revenueCalculatorLink.click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    String sliderXPath = "//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-duk49p']";
    WebElement sliderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sliderXPath)));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", sliderElement);
    if (sliderElement.isDisplayed()) {
        System.out.println("Slider element is displayed.");
    } else {
        System.out.println("Slider element is NOT displayed.");
    }
    String inputXPath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']";
    WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputXPath)));
    js.executeScript("arguments[0].scrollIntoView(true);", inputElement);
    if (inputElement.isDisplayed()) {
        System.out.println("Input element is displayed.");
    } else {
        System.out.println("Input element is NOT displayed.");
    }
    js.executeScript("arguments[0].value = '560'; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", inputElement);
    String newValue = inputElement.getAttribute("value");
    System.out.println("The input value is: " + newValue);


}
}




    


