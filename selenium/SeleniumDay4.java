package com.training.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.reporters.jq.Main;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDay4 {
	static WebDriver driver;
	public static void login() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");
  

     driver = new ChromeDriver(options);
   driver.manage().window().maximize();
		 
		driver.get("https://selenium-prd.firebaseapp.com/");
	WebElement email=driver.findElement(By.id("email_field"));
	email.sendKeys("admin123@gmail.com");
	WebElement psw=driver.findElement(By.id("password_field"));
	psw.sendKeys("admin123");
	WebElement loginbutton =driver.findElement(By.xpath("//button[text()='Login to Account']"));
	loginbutton.click();
	Thread.sleep(1000);
	}
	public static void homepage()
	{
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.findElement(By.id("name")).sendKeys("Pushpa");
		driver.findElement(By.id("lname")).sendKeys("Rajarao");

		driver.findElement(By.xpath("//input[@value='female']")).click();

		WebElement city=driver.findElement(By.id("city"));
		Select citydropdown=new Select(city);
		citydropdown.selectByVisibleText("NEW DELHI");

		WebElement course=driver.findElement(By.id("course"));
		Select coursedropdown=new Select(course);
		coursedropdown.selectByValue("btech");

		WebElement district=driver.findElement(By.id("district"));
		Select districtdropdown=new Select(district);
		districtdropdown.selectByIndex(2);

		WebElement state =driver.findElement(By.id("state"));
		Select statedropdown =new Select(state);
		statedropdown.selectByValue("mba");

		driver.findElement(By.id("emailid")).sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//button[@onclick='ClearFields()']")).click();
		
	}
	public static void switchtab()
	{
		WebElement buttonswitch=driver.findElement((By.xpath("//button[(contains(text(),'Switch To'))]")));
		Actions action =new Actions(driver);
		action.moveToElement(buttonswitch).click().build().perform();
	}
	public static void windowalert()
	{
		
		WebElement alert=driver.findElement(By.xpath("//a[text()='Alert']"));
		alert.click();
		WebElement windowalert=driver.findElement(By.xpath("//button[text()='Window Alert']"));
		windowalert.click();
		driver.switchTo().alert().dismiss();//to dismiss the window popups..
	}
	public static void promptalert()
	{
		WebElement prompt=driver.findElement(By.xpath("//button[text()='Promt Alert']"));
		prompt.click();
		driver.switchTo().alert().sendKeys("pushpa");
		driver.switchTo().alert().accept();
	}
	public static void main(String[] args) throws InterruptedException
	{
		login();
		homepage();
	switchtab();
	windowalert();
	promptalert();

	}

}
