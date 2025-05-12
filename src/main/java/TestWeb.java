import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestWeb {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");               // Run in headless mode
        options.addArguments("--no-sandbox");             // For Ubuntu
        options.addArguments("--disable-dev-shm-usage");  // Overcome limited resource problems
        options.addArguments("--disable-gpu");            // GPU issues
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to("https://myrealtordash.clareityiam.net/idp/login");
		driver.findElement(By.name("username")).sendKeys("1234567");
		driver.findElement(By.name("password")).sendKeys("abcdefg");
		driver.findElement(By.id("loginbtn")).click();
		//*[@id="form_login"]/div[5]/div
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.findElement(By.id("error")).isDisplayed())
			System.out.println("Login with Incorrect Credentials: Passed");
		else
			System.out.println("Login with Incorrect Credentials: Failed");
		driver.quit();

	}
}
