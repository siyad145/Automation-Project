package pagePackage;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class HealthCarePageClass {
	WebDriver driver;
	
	By AppointBtn=By.xpath("//*[contains(@id,'btn-make-appointment')]");
	By Username =By.id("txt-username");
	By Password= By.id("txt-password");
	By Login=By.id("btn-login");
    By checkbox=By.id("chk_hospotal_readmission");
	By Medicab=By.id("radio_program_medicaid");
	By Calender=By.xpath("//*[@id=\"appointment\"]/div/div/form/div[4]/div/div/div");
	By comment =By.xpath("//*[contains(@id,'txt_comment')]");
	By scrolldown=By.xpath("/html/body/footer/div/div/div/ul[1]/li[2]/a");
	By bookAppoinmt= By.id("btn-book-appointment");
	By elementscrnshot=By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a");
	By menu=By.id("menu-toggle");
	By history=By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a");
	By logout=By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[5]/a");

	public HealthCarePageClass(WebDriver driver)
	{
		this.driver=driver;
	}

	public void ClickAppoitmnt()
	{
		driver.findElement(AppointBtn).click();
     }
	
	public void linkCount()
	{
		 List <WebElement> linkcount=driver.findElements(By.tagName("a"));
		int links= linkcount.size();
		 System.out.println("total links="+links);
	}
	public void ResponseCode() throws IOException
	{
		String url="https://katalon-demo-cura.herokuapp.com/";
		URL u =new URL(url);
		HttpURLConnection con=(HttpURLConnection)u.openConnection();
		int code=con.getResponseCode();
		System.out.println("Response code ="+code);
		
	}
	public void displaylink()
	{
		 List<WebElement>linkz=driver.findElements(By.tagName("a"));
		 for(WebElement element: linkz)
		 {
			String Link= element.getAttribute("href");
			String LinkText=element.getText();
			System.out.println("Link is ="+Link);
			System.out.println("Link text is = "+LinkText);
			
	     }
	}
	
	public void login() throws Throwable
	{
		driver.findElement(Username).sendKeys("John Doe");
		driver.findElement(Password).sendKeys("ThisIsNotAPassword");
		driver.findElement(Login).click();
		Thread.sleep(5000);
	}
	public void titleVerify()
	{
		String title=driver.getTitle();
		System.out.println("page title= "+title);
		String exptitle="CURA Healthcare Service";
		if(title.equals(exptitle))
		{
			System.out.println("title verified");
		}
		else
		{
			System.out.println("title not verified");
		}
	}
	public void stringPresent()
	{
	 String pagesource=	driver.getPageSource();
	 if(pagesource.contains("appointment"))
	 {
		 System.out.println("String Present");
	 }
	 else
	 {
		 System.out.println("string not present");
	 }
	}
	public void selectDropdwn()
	{
		WebElement Dropdown=driver.findElement(By.xpath("//*[contains(@id,'combo_facility')]"));
		Select slctTokyo= new Select(Dropdown);
		slctTokyo.selectByValue("Tokyo CURA Healthcare Center");
	}
	public void checkoptions()
	{
		driver.findElement(checkbox).click();
		driver.findElement(Medicab).click();
	}
	public void DatePick()
	{
		driver.findElement(Calender).click();
		datepickermethod("January 2025","25");
	}

	private void datepickermethod(String expmonth,String expdate)
	{
	while(true)
	{
       String month=driver.findElement(By.xpath("//*[@class=\"datepicker-days\"]/table/thead/tr[2]/th[2]")).getText();
       if(month.equals(expmonth))
       {
    	   
    	   break;
       }
       else
       {
    	 WebElement nextmonth=driver.findElement(By.xpath("//*[@class=\"datepicker-days\"]/table/thead/tr[2]/th[3]"));
    	 nextmonth.click();
       }
		
	}
	List<WebElement> date=driver.findElements(By.xpath("//*[@class='datepicker-days']/table/tbody/tr/td"));
	for(WebElement e:date)
	{
		String dateText=e.getText();
		if(dateText.equals(expdate))
		{
			e.click();
			break;
			
		}
	}
	}public void bookAppointment() throws Exception
	{
		driver.findElement(comment).sendKeys("I have a fever and need an appointment on 25/01/2025 at 10 am.");
		driver.findElement(bookAppoinmt).click();
		Thread.sleep(5000);
	}
	
	public void pageScreenshot() throws Exception
	{
		 File s= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(s, new File(".\\screenshot\\img5.png"));
	}
	public void elementScreenshot() throws Exception
	{
		 File s2 = driver.findElement(elementscrnshot).getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(s2, new File(".\\screenshot\\img6.png"));
	}
	public void srolldown() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 2000)");
		Thread.sleep(5000);
		
	}
	public void viewhistory() throws Exception
	{
		driver.findElement(menu).click();
		driver.findElement(history).click();
		Thread.sleep(5000);
	}
	public void Logout()
	{
		driver.findElement(menu).click();
		driver.findElement(logout).click();
	}
}	

