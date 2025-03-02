import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



public class baseTest {

	public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://app-staging.nokodr.com.");

        System.out.println("Successfully Navigate to a noKodr platform");

	}

}