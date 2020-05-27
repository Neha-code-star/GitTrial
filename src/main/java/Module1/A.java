package Module1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("http://newtours.demoaut.com/mercurywelcome.php");
		d.manage().window().maximize();
		
		// to verify if the certain thing is there or not 
		if(d.getPageSource().contains("Welcome: Mercury Tours"))
		  {
		    System.out.println("Matched with Welcome: Mercury Tours ");
		  }
		else
		  {
		    System.out.println("No Match with Welcome: Mercury Tours");
		  }
		
		d.findElement(By.name("userName")).sendKeys("mercury");
		d.findElement(By.name("password")).sendKeys("mercury");

		
		d.findElement(By.name("login")).click();
		
		if(d.getPageSource().contains("SIGN-OFF"))
		  {
		    System.out.println("Matched with signoff");
		  }
		else
		  {
		    System.out.println("No Match with sign off");
		  }
		

		Thread.sleep(2000);
		

		d.close();
	}

}
