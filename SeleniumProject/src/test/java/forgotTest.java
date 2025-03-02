import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class forgotTest{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\Asus\\\\\\\\Downloads\\\\\\\\chromedriver-win64\\\\\\\\chromedriver-win64\\\\\\\\chromedriver.exe"); // Set the correct path

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Step 1: Open NoKodr login page
            driver.get("https://app-staging.nokodr.com/");
            driver.manage().window().maximize();

            // Step 2: Click "Forgot Password?" link
            WebElement forgotPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Forgot Password?')]")));
            forgotPasswordLink.click();

            // Step 3: Wait for modal popup to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Forgot Password')]")));

            // Step 4: Click on "Email" tab to ensure input field is visible
            WebElement emailTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//abx-tab[@name='email']")));
            emailTab.click();

            // Step 5: Locate email input field
            WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']")));

            // Step 6: Scroll to the field and enter email
            js.executeScript("arguments[0].scrollIntoView(true);", emailField);
            js.executeScript("arguments[0].focus();", emailField);
            emailField.sendKeys("prasadpawar292003@gmailcom");

            System.out.println("✅ Email Entered!");

            // Step 7: Click "Proceed" button
            WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Proceed')]")));
            proceedButton.click();
            System.out.println("📩 Forgot Password Request Sent!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
