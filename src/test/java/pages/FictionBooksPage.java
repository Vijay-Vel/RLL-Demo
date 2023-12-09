package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FictionBooksPage extends TestBase {
	
	@FindBy(xpath="//div[@class='row  w-100']/descendant::a[2]")
	WebElement Book1;
	
	@FindBy(xpath="//input[@class='btn themebackground text-white']")
	WebElement BuyNow;

	public FictionBooksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void click_book1() throws InterruptedException {
		Thread.sleep(1500);
		Book1.click();
		
	}
	
	public void click_buynow() {
		BuyNow.click();
	}
}
