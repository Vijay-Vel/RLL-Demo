package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{
	
	Actions a = new Actions(driver);
	
	@FindBy(xpath="//div[@class='col-sm-5 d-flex align-items-center justify-content-end']/descendant::span[3]")
	WebElement MyAccount;
	
	@FindBy(xpath="//div[@class='userpopup']/descendant::a[1]")
	WebElement LoginBtn;
	
	@FindBy(linkText="Fiction Books")
	WebElement FictionLink;
	
	@FindBy(xpath=("//input[@class='inputbar']"))
	static WebElement searchbox1;
	
	@FindBy(xpath=("//input[@name='btnTopSearch']"))
	static WebElement searchbutton;
	
	@FindBy(xpath="//input[@value='Add to Wishlist']")      
	static WebElement wishlist1;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void	clickLogin() throws InterruptedException {
		
		a.moveToElement(MyAccount).perform();
		Thread.sleep(1500);
		
		LoginBtn.click();
		
	}
	
	public void click_fiction() {
		FictionLink.click();
	}
	

	public void searchitem(String search)
	{
		searchbox1.sendKeys(search);
		//String actualsearch=search;
		//String Expectedsearch="BTS BOOK";
		//Assert.assertSame(actualsearch, Expectedsearch, "Assert not same search item");
		searchbutton.click();
	}
	public void wishlistsearch()
	{
		wishlist1.click();
		//assertTrue(true);
	}
	


}
