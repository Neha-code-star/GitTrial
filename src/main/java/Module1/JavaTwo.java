package Module1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTwo {
	
	WebDriver d;

	// will use anatation if there is no main method 
	@Test
	public void TestJunit () throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");

		 d = new ChromeDriver();

		d.get("http://techfios.com/test/billing/?ng=admin/");

		d.manage().window().maximize();

	
		d.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		d.findElement(By.id("password")).sendKeys("abc123");

		
		d.findElement(By.name("login")).click();

		
		Thread.sleep(5000);

		d.close();
		d.quit();

	}

}
