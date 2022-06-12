package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("home")).click();
		String parentWindow = driver.getWindowHandle();

		// get the number of windows
		Set<String> windowHandles = driver.getWindowHandles();

		// Convert set to list
		List<String> windows = new ArrayList<String>(windowHandles);		
		for (int i = 0; i < windowHandles.size(); i++) {
			driver.switchTo().window(windows.get(i));
			if(driver.getTitle().equals("LeafTaps")) {
				break;
			}
		}

		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(parentWindow);
		driver.quit();

	}

}
