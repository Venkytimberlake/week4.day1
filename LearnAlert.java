package week4.day1;

import org.apache.xmlbeans.impl.soap.Text;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
	driver.switchTo().frame("iframeResult");
	driver.findElement(By.xpath("//button[text()='Try it']")).click();
	Alert ram = driver.switchTo().alert();
	ram.sendKeys("Venkatesh");
	ram.accept();
	String a=driver.findElement(By.xpath("//p[@id='demo']")).getText();
	if(a.contains("Venkatesh")) {
	System.out.println("Yes");
	}else
		{System.out.println("no");
	}
	}
}
