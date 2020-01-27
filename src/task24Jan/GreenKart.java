package task24Jan;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	static int j = 0;

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kubraabbas\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		String[] listofVeggies = {"Tomato", "Water Melon", "Brocolli"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		addItemstoCart(driver, listofVeggies);	
		checkoutPage(driver);
	}
	
	public static void addItemstoCart(WebDriver driver, String[] listofVeggies) {
		List<WebElement> listofProducts = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < listofProducts.size(); i++) {
			String[] singleProduct = listofProducts.get(i).getText().split("-");
			String nameofVeggie = singleProduct[0].trim();
			List<String> listofVegetables = Arrays.asList(listofVeggies);
			if (listofVegetables.contains(nameofVeggie)) {
				j++;
				driver.findElements(By.xpath("//div[@class = 'product-action']//button")).get(i).click();
				if (j == listofVeggies.length) {
					break;
				}
			}
		}
	}
	
	public static void checkoutPage(WebDriver driver) {
		driver.findElement(By.cssSelector("img[alt ='Cart']")).click();
		driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());	
	}
}