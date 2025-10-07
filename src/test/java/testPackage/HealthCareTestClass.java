package testPackage;

import org.testng.annotations.Test;

import baseClassPackage.CuraHealthCareBaseClass;
import pagePackage.HealthCarePageClass;

public class HealthCareTestClass extends CuraHealthCareBaseClass 
{
  @Test
  public void test() throws Throwable
  {
	  HealthCarePageClass ob =new HealthCarePageClass(driver);
	  ob.ClickAppoitmnt();
	  ob.linkCount();
	  ob.displaylink();
	  ob.ResponseCode();
	  ob.login();
	  ob.stringPresent();
	  ob.selectDropdwn();
	  ob.checkoptions();
	 // ob.DatePick();
	  ob.bookAppointment();
	  ob.pageScreenshot();
	  ob.elementScreenshot();
	  ob.srolldown();
	  ob.viewhistory();
	  ob.Logout();
  }
}
 