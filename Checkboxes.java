package com.airlines;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//This programm will select the checkbox first then will count the no of passengers
public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		// driver setup
				System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				//get the main page
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				System.out.println("Main page title is:"+driver.getTitle());
				
//============checkbox selected================================================================================================================
				//find the element friendandFamily
				WebElement checkbox = driver.findElement(By.cssSelector("input[id*='friendsandfamily']"));	//using * as regular expression. this will collect all the letter related to friendesandfamily
				//is it selected?
				System.out.println("Is it selected/checked? "+ checkbox.isSelected());
				//click on the box
				checkbox.click();
				//now chaeck the selection
				System.out.println("Checkbox clicked .Is selected/checked? "+ checkbox.isSelected());
				
//check how many checkboxes are there============================================================================================================
				//find the ele with name attribute
				List<WebElement> noOfCheckBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
				System.out.println("No of checkboxes are :" + noOfCheckBox.size());
				Thread.sleep(2000);
				
/*========================== list passengers that add the value inside dropdown ================================================================*/
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
