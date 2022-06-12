package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement ram = driver.findElement(By.id("twotabsearchtextbox"));
		ram.sendKeys("oneplus 9 pro" + "\n");
		
		//Get the price of the first product
		
		String firstProduct = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("1st Product Price:" + firstProduct);
		Thread.sleep(5000);
		
		//Print the number of customer ratings for the first displayed product
		
		WebElement rating = driver.findElement(By.xpath("(//a[@target='_blank']/span/following::span)[5]"));
		String number = rating.getText();
		System.out.println("Ratings: " + number);
		
		//Click the first text link of the first image
		
		driver.findElement(By.xpath("//a[@target='_blank']/span")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		
		//Screenshot
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./screenshots/screenshot.png");
		FileUtils.copyFile(source, desc);
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Verify the cart value
		
		String cartSubTotal = driver.findElement(By.xpath("(//div[@id='attach-added-to-cart-message']//span/span)[2]"))
				.getText();

		if (firstProduct==cartSubTotal) {
			System.out.println("Price is correct");
		}
			
	}

	

}
