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
import utilities.ExcelUtility;
import utilities.MyListener;

@Listeners(MyListener.class)
public class SearchPageTest extends TestBase {
	
	HomePage hp;
	LoginPage lp;
	
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser();
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
	}
	
	@Test(dataProvider="LoginDetails",priority=1)
	public void test_login(String email, String password) throws InterruptedException 
	{
		hp.clickLogin();
		lp.user_login(email,password);
		String uname=lp.get_uname();
		
		Assert.assertNotEquals(uname, "My Account");
		//lp.user_logout();
	}
	
	 @DataProvider(name="LoginDetails") 
	 public Object[][] datasupplier() throws
	  EncryptedDocumentException, IOException {
	  
	  Object[] [] input = ExcelUtility.getTestData("Sheet2"); return input;
	  
	  }
	 
	 @Test(dataProvider="SearchData",priority=2)
	public void search(String search) throws InterruptedException
	{
		hp.searchitem(search);
		String actualsearch=search;
		String Expectedsearch="Beyond The Story: 10-Year Record of BTS";
		Assert.assertEquals(actualsearch, Expectedsearch, "Assert not same search item");
		hp.wishlistsearch();
		Thread.sleep(1500);
		lp.user_logout();
	}
	 @DataProvider(name="SearchData") 
	 public Object[][] datasupplier1() throws EncryptedDocumentException, IOException {
	  
	  Object[] [] input = ExcelUtility.getTestData("Sheet3"); return input;
	  
	  }
	
	@AfterTest
	public void close_browser()
	{
		driver.close();
	}

}
