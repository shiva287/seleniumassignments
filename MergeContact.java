package Week4Assignments;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//login
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//CRMS/FA link navigation
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//contacts and merge contacts interaction
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//Working with fromcontact
		driver.findElement(By.xpath("//table[@name='ComboBox_partyIdFrom']/following-sibling::a")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//creating a list to handle windows
		Set<String> selectcontactWindows = driver.getWindowHandles();
		System.out.println(selectcontactWindows.size());
		List<String> switchWindows = new ArrayList<String>(selectcontactWindows);
		driver.switchTo().window(switchWindows.get(1));
		List<WebElement> contactID = driver.findElements(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		contactID.get(1).click();
		System.out.println("First customer selected");
		driver.switchTo().window(switchWindows.get(0));
		
		//Working with fromcontact
		driver.findElement(By.xpath("//table[@name='ComboBox_partyIdTo']/following-sibling::a")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		Set<String> selectcontactWindows1 = driver.getWindowHandles();
		System.out.println(selectcontactWindows1.size());
		List<String> switchWindows1 = new ArrayList<String>(selectcontactWindows1);
		driver.switchTo().window(switchWindows1.get(1));
		List<WebElement> contactIDto = driver.findElements(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		contactIDto.get(2).click();
		System.out.println("second customer selected");
		driver.switchTo().window(switchWindows.get(0));

		//merging contacts
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		//clicking ok on Alert
		driver.switchTo().alert().accept();
		System.out.println("Alert Handled");
		
	String mergepageTitle = "View Contact | opentaps CRM";
			
			if (driver.getTitle().equals(mergepageTitle))
			{
				System.out.println("Merged Contacts Successfully");
			}
		
		
		
		
		
		
		
		
		
		
		
	}

}
