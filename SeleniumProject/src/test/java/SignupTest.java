import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignupTest{
    public static void main(String[] args) throws InterruptedException {
        // Set ChromeDriver path (Update this to match your actual path)
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Asus\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

        // Chrome Options to handle bot detection
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open the Login Page
            driver.get("https://app-staging.nokodr.com/");
            driver.manage().window().maximize();

            // Click on "Sign Up" link
            WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign up')]")));
            signupButton.click();
            Thread.sleep(2000); // Small wait to ensure the signup modal is loaded
            
            // Enter email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
            emailField.sendKeys("prasadpawar292003@gmail.com");
            System.out.println("✅ Email entered successfully!");

            // Click on "I agree to Terms and Conditions" checkbox (using JavaScript in case it's hidden)
            WebElement termsCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsCheckbox);
            System.out.println("✅ Checkbox clicked!");

            // Click Proceed Button (using JavaScript in case normal click fails)
            WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Proceed')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceedButton);
            System.out.println("✅ Proceed button clicked!");

            // ✅ Verify success (Wait for redirection or success message)
            wait.until(ExpectedConditions.urlContains("dashboard")); // Change URL if needed
            System.out.println("🚀 Signup process completed successfully!");
            driver.get("https://app-staging.nokodr.com/");
            driver.manage().window().maximize();

            // Wait for email field and enter email
            WebElement emailField1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
            emailField1.sendKeys("prasadpawar292003@gmail.com");

            // Click on "I agree to Terms and Conditions" checkbox
            WebElement termsCheckbox1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
            termsCheckbox1.click();

            // Click on Proceed Button
            WebElement proceedButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Proceed')]")));
            proceedButton1.click();

            // Wait for next page to load (if any success message)
            Thread.sleep(5000); // Adjust based on response time

            System.out.println("🚀 Signup process completed successfully!");


        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            // Close Browser
            driver.quit();
        }
    }
}

