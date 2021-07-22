package com.airlines;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AutoSuggestiveDrpdown {

	public static void main(String[] args) throws InterruptedException {
		// driver setup
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//get the main page
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println("Main page title is:"+driver.getTitle());
		
//===========Autosuggestive dropdown================type and autosuggest==========================================================================
		
		//find the elemnet and send the text you are searching
		WebElement searchbar = driver.findElement(By.id("autosuggest"));
		searchbar.sendKeys("ire");
		Thread.sleep(2000);
		//searchresult will appear as dropdown list
		//grab the word from the list matching with search key
		//click the option
		List<WebElement> drpoptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
						
		//print the selected option that searching for
		for(WebElement option:drpoptions)
		{	
			System.out.println(option.getText());
			Thread.sleep(2000);
			if(option.getText().equals("Ireland"))
			{
				option.click();	
				System.out.println("selected text: "+ option.getText());
				break;				
			}			
		}
		
		//print the search word
		System.out.println("The search reault text is :"+ searchbar.getAttribute("value"));				
		driver.close();

	}

}
