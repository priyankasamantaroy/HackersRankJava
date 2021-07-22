package com.airlines;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;//need to fix the select manually by importing suport

public class StaticDrp {

	public static void main(String[] args) throws InterruptedException {
		
/* ==========================chrome browser ============================*/
		// set up driver to system
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		//instanciate driver object
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//get the title of page
		System.out.println("Base page title: " + driver.getTitle());
		
/*====Static dropdown currency with Select class =================================*/
			
		WebElement drpdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		System.out.println("Drpdown text List are : "+ drpdown.getText());		
		Select drplists = new Select(drpdown);	
		//select all option and print
		for(int i=0; i<4; i++) 
		{
			drplists.selectByIndex(i);
			System.out.println("Select by Index : " + drplists.getFirstSelectedOption().getText());	
			
		}
		drplists.selectByValue("INR");
		System.out.println("Select by Value : " + drplists.getFirstSelectedOption().getText());	
		drplists.selectByVisibleText("AED");
		System.out.println("Select by Visible text : " + drplists.getFirstSelectedOption().getText());
		
		/*========================== list passengers that add the value inside dropdown ==============================*/
		WebElement psngerbox = driver.findElement(By.id("divpaxinfo"));
		System.out.println("Before adding passenger number is:"+psngerbox.getText());
		psngerbox.click();	//click on pasengerbox
		Thread.sleep(4000);
		driver.findElement(By.id("hrefIncAdt")).click();	//click on + button
		
		for(int i=1; i<4; i++) //will add 5 adults starting default 1
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();	//click on done button
		System.out.println("After adding passenger number is:"+ driver.findElement(By.id("divpaxinfo")).getText());
		
		
		
		
		
		driver.close();

	}

}
