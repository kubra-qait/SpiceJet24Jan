package task24Jan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitAssignment {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kubraabbas\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		driver.findElement(By.xpath("//a[text() = 'Click to load get data via Ajax!']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
		System.out.println(driver.findElement(By.id("results")).getText());
		

	}

}
