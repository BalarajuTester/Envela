package Oxhead_property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Runner extends TestCases {
	WebDriver dr;
	public Runner(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
	public String properties(String ele) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\BalarajuGone\\Balaraju\\Eclipse-Workspace\\Envela\\src\\test\\java\\Oxhead_property\\config.properties");
		prop.load(fis);
		String obj=prop.getProperty(ele);
		return obj;
	}
	
	public void visibilityOfElement(WebElement ele) throws InterruptedException {
		new WebDriverWait(dr,20,1).until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void loginRegister() throws InterruptedException  {
		//new FluentWait<WebDriver>(dr).withTimeout(60,TimeUnit.SECONDS).pollingEvery(1,TimeUnit.SECONDS);
		visibilityOfElement(popupclose);
		popupclose.click();
		visibilityOfElement(loginregister);
		loginregister.click();
	}
	
	//tc 23
	public void clickOnRemeberMeCheckBox() throws InterruptedException, IOException  {
		loginRegister();
		username.sendKeys(properties("username"));
		password.sendKeys(properties("password"));
		Assert.assertTrue( rememberme.isDisplayed());
		rememberme.click();
		loginButton.click();
		//Assert.assertTrue( loginusername.getText().contains("Hello"));
		//System.out.println("Welcome & "+ loginusername.getText());
	}
	
	//tc 24
	public void clickOnLostYourPasswordLink() throws InterruptedException, IOException {
		loginRegister();
		username.sendKeys(properties("username"));
		password.sendKeys(properties("password"));
		lostpassword.click();
		Assert.assertTrue( lostyourpassword.getText().contains("Lost your password?"));
		System.out.println(lostyourpassword.getText());
	}
	
	//tc 25,26,27,28,29
	public void passwordReset(String npw,String rpw) throws InterruptedException, IOException {
		loginRegister();
		visibilityOfElement(lostpassword);
		lostpassword.click();
		Assert.assertTrue( lostyourpassword.getText().contains("Lost your password?"));
		System.out.println(  lostyourpassword.getText());
		uname.sendKeys(properties("username"),Keys.ENTER);
		Assert.assertTrue( passwordmessage.getText().contains("Password reset email has been sent"));
		System.out.println(  passwordmessage.getText());
		dr.get("https://accounts.google.com/");
		visibilityOfElement(gmail);
		gmail.sendKeys(properties("username"),Keys.ENTER);
		visibilityOfElement(gmailPassword);
		gmailPassword.sendKeys(properties("password"),Keys.ENTER);
		visibilityOfElement(logo);
		logo.click();
		dr.switchTo().frame( frame);
		gmaillogo.click();
		String wnd=dr.getWindowHandle();
		Set<String> wnds = dr.getWindowHandles();
		for(String windo:wnds) {
			if(!(windo.equals(wnd))){
				dr.switchTo().window(windo);
				try {
					if(frame.isDisplayed()) {
						dr.switchTo().frame( frame);
						dontswitch.click();
					}
				}catch (Exception e) {
					System.out.println("");
				}
				visibilityOfElement(mail);
				mail.click();
				visibilityOfElement(resetlink);
				Assert.assertTrue( resetlink.getText().contains("Click here to reset your password"));
				System.out.println( resetlink.getText());
				resetlink.click();
				deletmail.click();
			}
		}
		visibilityOfElement(lostpassword);
		dr.close();
		dr.switchTo().window(wnd);
		Set<String> wndos = dr.getWindowHandles();
		for(String windo:wndos) {
			if(!(windo.equals(wnd))){
				dr.switchTo().window(windo);
			}
		}
		newPwd.sendKeys(npw);
		ReNewPwd.sendKeys(rpw);
		save.click();
		try {
			if( passworderrormessage.isDisplayed()) 
				System.out.println( passworderrormessage.getText());
		}catch (Exception e) {
			Assert.assertTrue( passwordmessage.getText().contains("Your password"));	
			System.out.println(  passwordmessage.getText());
		}

	}
	//tc 30
	public void clicknOnCreateAnAccountLink() throws InterruptedException {
		loginRegister();
		visibilityOfElement(createaccount);
		createaccount.click();
	}

	//tc 31
	public void clickOnCrossMarkButton () throws InterruptedException {
		loginRegister();
		visibilityOfElement(loginclose);
		loginclose.click();
	}

	//tc 32
	public void clickOnCloseButton() throws InterruptedException {
		visibilityOfElement(popupclose);
		popupclose.click();
	}
	//tc 33
	public void CustomerAbletToDoSignUpWithValidEmailAddress() throws InterruptedException, IOException {
		visibilityOfElement(popupemail);
		popupemail.sendKeys(properties("username"));
		popupsubmit.click();
		visibilityOfElement(popupmessage);
		Assert.assertTrue( popupmessage.getText().contains("Thank you,"));
		System.out.println(popupmessage.getText());
	}
	//tc65,66
	public void productsinthesearch(String prd) throws InterruptedException, IOException {
		clickOnRemeberMeCheckBox();
		visibilityOfElement(productsearch);
		productsearch.sendKeys(prd,Keys.ENTER);
		try {
			if(productErrormsg.isDisplayed()) {
				System.out.println( productErrormsg.getText());
			}
		}catch (Exception e) {
			System.out.println( producctmessage.getText());
		}
	}
	//tc 67,68,69,70,71,72,73-inprogress ,74,76-not available     76,77,78,80,81-need select catrgories    79-inprogress                    82,83-responsive        84,85-products not available     86-not resolved
	//tc 132
	public void paymentMethod() throws InterruptedException, IOException {
		clickOnRemeberMeCheckBox();
		loginregister.click();
		Paymentmethods.click();
		Addpaymentmethod1.click();
		cardnumber.sendKeys("4111");
		cardnumber.sendKeys("1111");
		cardnumber.sendKeys("1111");
		cardnumber.sendKeys("1111");
		Expiry.sendKeys("12");
		Expiry.sendKeys("22");
		Cardcode.sendKeys("123");
		Addpaymentmethod2.click();
		Assert.assertTrue(passwordmessage.getText().contains("Payment method"));
		System.out.println(passwordmessage.getText());
		deletpaymentmethod.click();
	}
	
	//tc137
	public void orderDetails() throws InterruptedException, IOException {
		JavaScrptClass js=new JavaScrptClass(dr);
		ScreenShort ss= new ScreenShort(dr);
		clickOnRemeberMeCheckBox();
		loginregister.click();
		orders.click();
		ordersview.click();
		Assert.assertTrue(ordersdetails.getText().contains("Order"));
		js.scroll(ordersdetails);
		ss.sc(ordersdetails);
	}
	//tc139
	public void dashBoardlogout() throws InterruptedException, IOException {
		clickOnRemeberMeCheckBox();
		loginregister.click();
		dashboardlogout.click();
		Assert.assertTrue(loginregister.getText().contains("Login"));
		System.out.println("Logout Sucessfull");
	}
	//tc140
	public void myAccountlogout( ) throws InterruptedException, IOException {
		Actions ac=new Actions(dr);
		clickOnRemeberMeCheckBox();
		ac.moveToElement(loginregister).perform();
		myaccountlogout.click();
		Assert.assertTrue(loginregister.getText().contains("Login"));
		System.out.println("Logout Sucessfull");
	}
	//tc243
	public void clickingOnTheShopNowButtonItHasToRedirectToThatParticularPage( ) throws InterruptedException, IOException {
		clickOnRemeberMeCheckBox();
		visibilityOfElement(SilverShopnow);
		SilverShopnow.click();
		Assert.assertTrue(producctmessage.getText().equalsIgnoreCase("Silver"));
		System.out.println(producctmessage.getText());
		dr.navigate().back();
		visibilityOfElement(rightarrow);
		rightarrow.click();
		visibilityOfElement(goldShopnow);
		goldShopnow.click();
		Assert.assertTrue(producctmessage.getText().equalsIgnoreCase("Gold"));
		System.out.println(producctmessage.getText());
		dr.navigate().back();
		visibilityOfElement(leftarrow);
		leftarrow.click();
		visibilityOfElement(platiniumShopnow);
		platiniumShopnow.click();
		Assert.assertTrue(producctmessage.getText().equalsIgnoreCase("Platinum"));
		System.out.println(producctmessage.getText());
	}
	//tc244
	public void clickOnTheShopNowButtonItHasToRedirectToThatParticularPage(String x,String y) throws InterruptedException, IOException {
		JavaScrptClass js=new JavaScrptClass(dr);
		clickOnRemeberMeCheckBox();
		js.scrolll(x, y);
		visibilityOfElement(StsticShopnow1);
		StsticShopnow1.click();
		Assert.assertTrue(producctmessage.getText().contains("New"));
		System.out.println("Redirected to  "+producctmessage.getText());
		dr.navigate().back();
		visibilityOfElement(StsticShopnow2);
		StsticShopnow2.click();
		Assert.assertTrue(producctmessage.getText().contains("New"));
		System.out.println("Redirected to  "+producctmessage.getText());
	}			
	
}
