package baseClassPackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class CuraHealthCareBaseClass {
	public static ChromeDriver driver;
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		
	}

}