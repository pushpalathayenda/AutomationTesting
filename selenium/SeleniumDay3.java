package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDay3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeOptions options=new ChromeOptions();
options.addArguments("--incognito");
WebDriver driver=new ChromeDriver(options);
driver.get("https://login.salesforce.com");
driver.manage().window().maximize();

driver.findElement(By.id("username")).sendKeys("pushpalatha.yenda.1981b8920d3d@agentforce.com");
driver.findElement(By.id("Login")).click();   // correct login button
driver.findElement(By.id("password")).sendKeys("Lathamurali@123");
driver.findElement(By.id("Login")).click();   // final login

Thread.sleep(20000);
driver.findElement(By.id("save")).click();

		
	}

}
