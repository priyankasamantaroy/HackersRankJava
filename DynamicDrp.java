package com.airlines;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DynamicDrp {

	public static void main(String[] args) {
		// set up driver to system
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		//instanciate driver object
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//get the title of page
		System.out.println("Base page title: " + driver.getTitle());
		
/*======Dynamic dropdown=====No Select Class used======Node based========value same in each box need to define node index of box===================*/
		
		//find first drpbox and click to see the drplist from
		WebElement drplistfrom = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		drplistfrom.click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();	
		//display the box value
		System.out.println("The selected place from is:"+ drplistfrom.getAttribute("value"));
		
		//No Need to find 2nd box for destination to as auto selected after first one
		//as its clicked after the from box selected (we need to locate element using xpath and the node position)		
		//just need to find the value from dropdown and need to click
		driver.findElement(By.xpath("(//a[@value='BLR'])[1]")).click();
		//display the box value
		System.out.println("The destination is: " + driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value"));
		
		driver.close();
	}

}
