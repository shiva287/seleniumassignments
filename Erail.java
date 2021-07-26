package Week3Assignment1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Check box unselected");
		
		WebElement fromStation = driver.findElementByXPath("//input[@id='txtStationFrom']");
		fromStation.clear();
		Thread.sleep(5000);

		fromStation.sendKeys("CBE");
		driver.findElement(By.xpath("//div[@class='autocomplete']/div")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Entered From : Coimbatore Jn");
		
		
		WebElement  toStation = driver.findElementByXPath("//input[@id='txtStationTo']");
		toStation.clear();
		Thread.sleep(5000);

		toStation.sendKeys("MASS");
		driver.findElement(By.xpath("//div[@class='autocomplete']/div[@title='Mgr Chennai Central Suburban']")).click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Entered To Station :Mgr Chennai Central Suburban");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		driver.findElementByXPath("//input[@id='buttonFromTo']").click();
		
		List<WebElement> trainList = driver.findElementsByXPath("//td[@style=';']/a");
		
		//String[] trainNames = new String[100];
		ArrayList<String> trainNames = new ArrayList<String>();
		int noofTrains = trainList.size();
		System.out.println(noofTrains);
		
		for(WebElement trainName : trainList)
		{
			String name = trainName.getText();
			trainNames.add(name);	
		}
		 
		Collections.sort(trainNames);
		
		for(int i=0; i<trainNames.size(); i++) {
			System.out.println(trainNames.get(i));

		}
		System.out.println("Closing the Browser");
	}

}
