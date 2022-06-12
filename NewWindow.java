package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
driver.findElement(By.xpath("//button[text()='OK']")).click();
driver.findElement(By.xpath("//span[@class='allcircle circleone']")).click();
Set<String> windowHandles = driver.getWindowHandles();
List<String> windows=new ArrayList<String>();
driver.switchTo().window(windows.get(1));
	System.out.println(driver.getTitle());
	}

}
