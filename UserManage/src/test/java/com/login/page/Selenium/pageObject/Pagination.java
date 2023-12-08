package com.login.page.Selenium.pageObject;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {


	public static void main(String[] args) {
		
		// Lounch Browser
		
		WebDriverManager .chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		
		
		//Login
		
		WebElement username=driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password=driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//button[@class=\"btn-close\"]")).click();
		
		
		//Sales
		
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		//Total no of Page in table 
		String text=driver.findElement(By.xpath("//div[contains(@class,'col-sm-6 text-end')]")).getText();
		System.out.println("Total no of Page in table ->"+ text);
		
		int  total_page =Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		System.out.println("Total no of Pages " +total_page );
		
		
		for (int p=1; p<=total_page; p++) {
			
			WebElement Active_page= driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li//span"));
			System.out.println("Active page no is "+ Active_page.getText());
			Active_page.click();
			System.out.println("Active page is opend "+p);
			
			
			//Dynamic Web Table
			List < WebElement > row=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr"));
			int rowCount = row.size();
			System.out.println("print the total row "+rowCount); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Dynamic xpath	
			String pageNo=Integer.toString(p+1);
			System.out.println("Page number is " +p);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageNo+"']")).click();
			System.out.println("Opend_Page "+p);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			
		}
		
		
		
	}
	
	
}
