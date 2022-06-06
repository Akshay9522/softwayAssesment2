package testPages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {
	static int price_on_flipcarkt; 
	static int price_on_amazon; 

	
	@Test(priority=1)
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitthal\\Desktop\\workspace\\softwayAssesment2\\driver1\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("REDMI Note 10 Pro (Dark Night, 128 GB)(6GB RAM)");
		driver.findElement(By.xpath("//*[contains(@viewBox,'0 0 17 18')]")).click();
		List<WebElement> ls1 =driver.findElements(By.xpath("//div[text()='REDMI Note 10 Pro (Dark Night, 128 GB)']"));
        ls1.get(0).click();
		Set<String> wd = driver.getWindowHandles();
		Iterator<String> itr = wd.iterator();
		String Home_Window = itr.next();
		String Addtocart_Window = itr.next();
		driver.switchTo().window(Addtocart_Window);
		List<WebElement> ls2 =driver.findElements(By.xpath("//div[text()='₹15,999']"));
		String priceflipcarkt=ls2.get(0).getText().replaceAll("[^(0-9)]", "");
        price_on_flipcarkt=Integer.parseInt(priceflipcarkt);
		driver.quit();
	}
	@Test(priority=2)
	public static void setUp2() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitthal\\Desktop\\workspace\\softwayAssesment2\\driver1\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("REDMI Note 10 Pro (Dark Night, 128 GB)(6GB RAM)");
		driver.findElement(By.xpath("//input[@value='Go']")).click();	
		List<WebElement> ls1 =driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		String priceamazon=ls1.get(0).getText().replaceAll("[^(0-9)]", "");
        price_on_amazon=Integer.parseInt(priceamazon);
		driver.close();
	}
	@Test(priority=3)
	public static void validation() {
		System.out.println("price of REDMI note 10 on Flipkart is :-"+ price_on_flipcarkt);
		System.out.println("price of REDMI note 10 on Amazon is :-"+price_on_amazon);
        if(price_on_flipcarkt>price_on_amazon) {
    		System.out.println("price of REDMI note 10 on is less on amazon ");
        }else if(price_on_flipcarkt<price_on_amazon){
    		System.out.println("price of REDMI note 10 on is less on Flipkart ");
        }else {
        	System.out.println("price of REDMI note 10 on is same on amazon and Flipkart");
        }
	}
}

