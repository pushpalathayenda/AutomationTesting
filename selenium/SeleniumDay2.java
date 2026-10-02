package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDay2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeOptions options=new ChromeOptions();
options.addArguments("--incognito");
WebDriver driver=new ChromeDriver(options);
driver.get("https://selenium-prd.firebaseapp.com/");
driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
//driver.findElement(By.xpath("//button[@onclick='login()']"));
driver.findElement(By.xpath("//button[text()='Login to Account'] ")).click();
driver.findElement(By.xpath("//button[contains(text(),'Login')] ")).click();

	}

}
