import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class loginTest{
    public static void main(String[] args) {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\Asus\\\\\\\\Downloads\\\\\\\\chromedriver-win64\\\\\\\\chromedriver-win64\\\\\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Open the login page
            driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");
            driver.manage().window().maximize();
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Enter email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
            emailField.sendKeys("prasadpawar292003@gmail.com");

            // Enter password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
            passwordField.sendKeys("satara@123");
            
            //i agree
            WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
            termsCheckbox.click();

            // Scroll to the login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Log In')]")));
            js.executeScript("arguments[0].scrollIntoView(true);", loginButton);
            
            // Click the button using JavaScript
            js.executeScript("arguments[0].click();", loginButton);

            System.out.println("Login Attempted!");

            // Wait to observe the result
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
