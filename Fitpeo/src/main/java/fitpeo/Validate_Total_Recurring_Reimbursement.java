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

public class Validate_Total_Recurring_Reimbursement {
    public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Fitpeo\\External\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.fitpeo.com/");

            driver.manage().window().maximize();
            Thread.sleep(3000);
            WebElement revenueCalculatorLink = driver.findElement(By.xpath("//header//a[@href='/revenue-calculator']"));
            revenueCalculatorLink.click();
            String sliderXPath = "//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-duk49p']";
            WebDriverWait wait = new WebDriverWait(driver, 15); // Increased timeout
            JavascriptExecutor js = (JavascriptExecutor) driver;
            List<String> valuesToCheck = Arrays.asList("CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474");

            for (String value : valuesToCheck) {
                WebElement paragraph = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(), '" + value + "')]")));
                WebElement parentDiv = paragraph.findElement(By.xpath("./ancestor::div[@class='MuiBox-root css-4o8pys']"));
                WebElement checkbox = parentDiv.findElement(By.xpath(".//input[@type='checkbox' and @class='PrivateSwitchBase-input css-1m9pwf3']"));
                if (!checkbox.isSelected()) {
                    checkbox.click();
                    WebElement sliderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sliderXPath)));
                    js.executeScript("arguments[0].scrollIntoView(true);", sliderElement);
                    if (sliderElement.isDisplayed()) {
                        System.out.println("Slider element is displayed.");
                    } else {
                        System.out.println("Slider element is NOT displayed.");
                    }

                    String inputXPath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']";
                    WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputXPath)));
                    if (inputElement.isDisplayed()) {
                        System.out.println("Input element is displayed.");
                    } else {
                        System.out.println("Input element is NOT displayed.");
                    }
                    js.executeScript("arguments[0].value = '820'; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", inputElement);
                    String newValue = inputElement.getAttribute("value");
                    System.out.println("The input value is: " + newValue);
                }
            }
        } finally {
            driver.quit();
        }
    }
}
