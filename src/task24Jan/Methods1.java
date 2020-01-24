package task24Jan;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Methods1 {
	
	static WebDriver driver;
	
	public void launchURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kubraabbas\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
	}
		
	public void staticDropdown() {
		driver.findElement(By.id("divpaxinfo")).click();
		Select adult = new Select(driver.findElement(By.cssSelector("select[id = 'ctl00_mainContent_ddl_Adult']")));
		adult.selectByIndex(2);
		Select child = new Select(driver.findElement(By.cssSelector("select[id = 'ctl00_mainContent_ddl_Child']")));
		child.selectByValue("4");
		Select infant = new Select(driver.findElement(By.cssSelector("select[id = 'ctl00_mainContent_ddl_Infant']")));
		infant.selectByVisibleText("3");
	}
	
	public void dynamicDropdown() {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id = 'ctl00_mainContent_ddl_originStation1_CTNR']//a[@value = 'IXG']")).click();
		driver.findElement(By.xpath("//div[@id = 'ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value = 'HYD']")).click();
	}
	
	public void autoSuggestiveDropdown() throws Exception {
		Thread.sleep(5000);
		WebElement departureCity = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		departureCity.clear();
		departureCity.click();
		departureCity.sendKeys("ma");
		Thread.sleep(5000);
		departureCity.sendKeys(Keys.ARROW_RIGHT);
		Thread.sleep(5000);
		departureCity.sendKeys(Keys.ENTER);
		
		WebElement arrivalCity = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		arrivalCity.clear();
		arrivalCity.sendKeys("ko");
		Thread.sleep(5000);
		for (int i =1; i<4; i++) {
			arrivalCity.sendKeys(Keys.ARROW_RIGHT);
		}
		Thread.sleep(5000);
		arrivalCity.sendKeys(Keys.ENTER);
		}
			
	}
	

