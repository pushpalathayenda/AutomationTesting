package com.training.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDay4DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
List <WebElement>element=driver.findElements(By.tagName("iframe"));
System.out.println(element.size());
WebElement iframe=driver.findElement(By.xpath("//iframe[@class='demo-frame'][1]"));//switch to frame with seperate html code
driver.switchTo().frame(iframe);
WebElement dragfrom=driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
WebElement dropto=driver.findElement(By.id("trash" ));
Actions action=new Actions(driver);
action.dragAndDrop(dragfrom, dropto).build().perform();
//Thread.sleep(4000);
driver.switchTo().defaultContent();


	}

}
