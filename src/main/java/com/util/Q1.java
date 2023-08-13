package com.util;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://phptravels.com/demo/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
		fname.sendKeys("Ajay");
		
		WebElement lname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
		lname.sendKeys("Anandan");
		
		WebElement bname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Business Name']")));
		bname.sendKeys("Testing");
		
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
		email.sendKeys("Ajay73635@gamil.com");
		
		String n1 = driver.findElement(By.xpath("//*[@id=\"numb1\"]")).getText();
		String n2 = driver.findElement(By.xpath("//span[@id='numb2']")).getText();
		
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		int total = num1 + num2;
		
		WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='number']")));
		
		result.clear();
		
		result.sendKeys(String.valueOf(total));
		
		driver.findElement(By.xpath("//button[@id='demo']")).click();

		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/section[1]/div/div/div[2]/div/div/div/div/div/div/div/div[3]/h2/strong")));
		
		String message = msg.getText();
		
		if(message.contains("Thank you!")) {
			System.out.println("Form was submitted successfully");
		}
		else {
			System.out.println("Form wasn't submitted successfully");
		}
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./img.png");
		
		FileHandler.copy(src, dest);
		
		driver.quit();
				
	}

}
