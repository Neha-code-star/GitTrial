package Module3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Assertion {
	
	// is only used to validate, see if the software is working or not
	// Assert.assertEquals(String(this the is msg u want to write),expected(what do u expect), actual(what is actual)
	//will only print if the title is not there, if the title matched will not show anything

	@Test
	public void VerifyDashboard() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("http://techfios.com/test/billing/?ng=admin/");
		
		d.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("techfiosdemo@gmail.com");
		d.findElement(By.xpath("//input[contains(@id,'password') and @name='password'] ")).sendKeys("abc123");
		d.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		String expected = "Dashboard- TechFios Test Application - Billing";
		String actual = d.getTitle();
		Assert.assertEquals("Did not show up", expected, actual);
		
		d.findElement(By.xpath("//*[@id=\"side-menu\"]/li[4]/a/span[1]")).click();
		d.findElement(By.xpath("//*[@id=\"side-menu\"]/li[4]/ul/li[1]/a")).click();
		
		WebDriverWait n = new WebDriverWait(d, 10);
		n.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"), "Invoice"));
		
		// did not work 
//		String expected1 = "Invoice";
//		String actual1 = d.getTitle();
//		Assert.assertEquals("int did not show up", expected1, actual1);
		
		
		Thread.sleep(2000);
		
		d.close();
		d.quit();
	}
}
