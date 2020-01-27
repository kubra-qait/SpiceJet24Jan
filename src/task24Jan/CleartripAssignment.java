package task24Jan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CleartripAssignment {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kubraabbas\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		driver.findElement(By.id("DepartDate")).click();
		Select adults = new Select(driver.findElement(By.id("Adults")));		
		adults.selectByValue("5");
		Select children = new Select(driver.findElement(By.id("Childrens")));
		children.selectByIndex(2);
		Select infant = new Select(driver.findElement(By.id("Infants")));
		infant.selectByVisibleText("4");
		driver.findElement(By.id("MoreOptionsLink")).click();
		Select classofTravel = new Select(driver.findElement(By.id("Class")));
		classofTravel.selectByIndex(3);
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
	}

}
