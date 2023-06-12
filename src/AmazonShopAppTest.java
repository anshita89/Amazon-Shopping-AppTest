
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;


public class AmazonShopAppTest {
	@Test
	public static void amazonApps() throws IOException {
		//launch the browser
		WebDriver driver=new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to amazon page
		driver.navigate().to("https://www.amazon.com/");
		
		//implicit wait apply
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//parent
		String parent_window=driver.getWindowHandle();
		
		//locate and search
		WebElement search=driver.findElement(By.cssSelector("input#twotabsearchtextbox[class=\"nav-input nav-progressive-attribute\"]"));
		
		//create action obj
		Actions act=new Actions(driver);
		
		// search and click
		act.click(search).sendKeys("city of djinns a year in delhi",Keys.ENTER).build().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//locate and click
		driver.findElement(By.cssSelector("img[src=\"https://m.media-amazon.com/images/I/A1kR3OdgwYL._AC_UY218_.jpg\"]")).click();
		
		//parent to child 
		 Set<String> handle=driver.getWindowHandles();
			for(String e :handle) {
				if(!e.equalsIgnoreCase(parent_window))
				{
					driver.switchTo().window(e);
				}
				}
			
		//locate and buy now click
		driver.findElement(By.cssSelector("input[id=\"buy-now-button\"]")).click();
		
		//locate and click
		driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys("4651654841");
		
		//locate and contiune
		driver.findElement(By.cssSelector("input[id=\"continue\"]")).click();
		
		//take secreen shot
		File T1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(T1,new File("./p5.png"));
		
		//refresh page
		driver.navigate().refresh();
		
		//close
		//driver.close();
	}

}

