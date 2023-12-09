package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
	
	Actions a = new Actions(driver);
	@FindBy(xpath="//input[@id='ctl00_phBody_SignIn_txtEmail']")
	WebElement loginemail;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_SignIn_txtPassword']")
	WebElement loginpassword;
	
	@FindBy(xpath="((//div[@class='form-row text-center'][1])/descendant::*)[2]")
	WebElement LoginBtn1;
	
	@FindBy(xpath="//div[@class='col-sm-5 d-flex align-items-center justify-content-end']/descendant::span[3]")
	WebElement UserName;
	
	@FindBy(xpath="//div[@class='userpopup']/descendant::a[9]")
	WebElement LogoutBtn;
	
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		
	}
	
	public void user_login(String email, String password) throws InterruptedException {
		loginemail.sendKeys(email);
		loginpassword.sendKeys(password);
		LoginBtn1.click();
		
	}
	
	public void user_logout() throws InterruptedException  {
		
		a.moveToElement(UserName).perform();
		Thread.sleep(1500);
		LogoutBtn.click();
	}
	public String get_uname() {
		String uname=UserName.getText();
		return uname;
	}
	
	
}
