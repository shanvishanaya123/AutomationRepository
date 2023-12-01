package automationTestAssignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.amazon.in/");
		
		//search for iphone
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		
		//click on search icon
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(2000);
		
	
		
		// get the address of list iphone window page
		String parentHandle = driver.getWindowHandle();
		
		
		// searching for iphone 
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		
		
		Thread.sleep(2000);
		
		//get the address of all the Windows 
		Set<String> allHandles = driver.getWindowHandles();
		
		//switch the controls from list window to product window
		for(String wh:allHandles)
		{
			if(!parentHandle.equals(wh))
			{
				driver.switchTo().window(wh);
			}
			
		}
		
		
	   System.out.println("We are on product page " + driver.getTitle());
	   
		Thread.sleep(2000);
		
	  //get the price of iphone and store into variable
	   String priceOfIphone = driver.findElement(By.xpath("//span[@id='productTitle']/ancestor::div[@id='centerCol']/descendant::span[@class='a-price-whole']")).getText();
		
		System.out.println(priceOfIphone);
		
		//scroll till add to card button and click
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		 
		Point loc = addToCartButton.getLocation();
		
		int xaxis = loc.getX();
		int yaxis = loc.getY();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+xaxis+","+yaxis+")");
		
		
		addToCartButton.click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
		
		

	}

}
