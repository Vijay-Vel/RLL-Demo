package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.TestBase;
import pages.TodaysDealPage;
import utilities.ExcelUtility;
import utilities.MyListener;
import utilities.RetryAnalyzer;

@Listeners(MyListener.class)
public class TodaysDealPageTest extends TestBase {
	
	HomePage hp;
	LoginPage lp;
	TodaysDealPage tp;
	public static int RowNum=1;
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser();
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		tp = new TodaysDealPage(driver);
	}

	
	@Test(dataProvider="LoginDetails",priority=1,retryAnalyzer=RetryAnalyzer.class)
	public void test_login(String email, String password) throws IOException, InterruptedException
	{
		hp.clickLogin();
		lp.user_login(email,password);
		String uname=lp.get_uname();
		
		//Assert.assertEquals(uname, email);
		Assert.assertNotEquals(uname, "My Account");
		//lp.user_logout();
	}
	
	@Test(priority=2,retryAnalyzer=RetryAnalyzer.class)
	public void dealstoday() throws InterruptedException, IOException
	{ 
		tp.todaysdeallog();
		//Assert.fail();

	}
	
	  @DataProvider(name="LoginDetails") public Object[][] datasupplier() throws
	  EncryptedDocumentException, IOException {
	  
	  Object[] [] input = ExcelUtility.getTestData("Sheet2"); return input;
	  
	  }

	  @AfterTest
		public void close_browser()
		{
			driver.close();
		}

}
