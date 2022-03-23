package Oxhead_property;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Header extends TestCases{
	WebDriver dr;
	public Header(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
	public void visibilityOfElement(WebElement ele) throws InterruptedException {
		new WebDriverWait(dr,20,1).until(ExpectedConditions.visibilityOf(ele));
	}
	
	//67,68,69,70,71,72,73
	public void selectcategory(String prd) throws InterruptedException, IOException{
		if(prd.equalsIgnoreCase("All-Products")) {
			select(AllProducts);
		}else if (prd.equalsIgnoreCase("gold")) {
			select(Gold);
		}else if (prd.equalsIgnoreCase("membership")) {
			select(Membership);
		}else if (prd.equalsIgnoreCase("palladium")) {
			select(Palladium);
		}else if (prd.equalsIgnoreCase("platinum")) {
			select(Platinum);
		}else if (prd.equalsIgnoreCase("silver")) {
			select(Silver);
		}
		else{
			System.out.println("please enter correct product, you entered product is: "+prd);
		}
		try {
			if(productmessage.isDisplayed()) {
				Assert.assertTrue(productmessage.getText().equalsIgnoreCase(prd));
				System.out.println("you searched for "+prd);
			}
		}catch (Exception e) {
			System.out.println("  ");
		}
	}
	public void select(WebElement ele) throws InterruptedException, IOException {
		Runner r=new Runner(dr);
		r.clickOnRemeberMeCheckBox();
		visibilityOfElement(selecategory);
		selecategory.click();
		visibilityOfElement(ele);
		ele.click();
		searchbutt.click();
	}
	public void selectBlank(String prd) throws InterruptedException, IOException {
		Runner r=new Runner(dr);
		r.clickOnRemeberMeCheckBox();
		searchbutt.click();
		System.out.println("you searched for "+prd);
	}
	//tc160,161,162,163,164
	public void browserCategory(String prd) throws  IOException, InterruptedException {
		Runner r=new Runner(dr);
		ScreenShort ss= new ScreenShort(dr);
		r.clickOnRemeberMeCheckBox();
		Actions ac=new Actions(dr);
		ac.moveToElement(Browsecategories).perform();
		for(WebElement sel: Browsecategorieslist) {
			if(sel.getText().equalsIgnoreCase(prd)) {
				sel.click();
				break;
			}
		}
		Assert.assertTrue(producctmessage.getText().equalsIgnoreCase(prd));
		System.out.println("You Searches for "+producctmessage.getText());
		ss.sc(producctmessage);
	}
	//tc 75		
	public void browserCategoryPalladiumBullion(String prd) throws InterruptedException, IOException {
		JavaScrptClass js=new JavaScrptClass(dr);
		ScreenShort ss= new ScreenShort(dr);
		browserCategory(prd);
		PalladiumBullion.click();
		visibilityOfElement(Bar);
		//js.scrolll("0", "500");
		js.scroll(Bar);
		Assert.assertTrue(Bar.isDisplayed());
		System.out.println("Bar is available");
		ss.sc(Bar,"alt");
	}
	//tc166
	public void Home( ) throws InterruptedException, IOException {
		Runner r=new Runner(dr);
		ScreenShort ss= new ScreenShort(dr);
		r.clickOnRemeberMeCheckBox();
		home.click();
		ss.sc(home);
	}
	//tc168
	public void Homestikiheader(String x,String y) throws InterruptedException, IOException {
		Runner r=new Runner(dr);
		JavaScrptClass js=new JavaScrptClass(dr);
		ScreenShort ss= new ScreenShort(dr);
		r.clickOnRemeberMeCheckBox();
		js.scrolll(x,y);
		ss.sc(Stickyhesder,"id");
	}
	//tc169
	public void NewArrivalsPage( ) throws InterruptedException, IOException {
		Runner r=new Runner(dr);
		ScreenShort ss= new ScreenShort(dr);
		r.clickOnRemeberMeCheckBox();
		trading.click();
		NewArrivals.click();
		Assert.assertTrue(producctmessage.getText().equalsIgnoreCase("New Arrivals"));
		ss.sc(producctmessage);
	}
	//tc171 not working
	public void CollectionsPage( ) throws InterruptedException, IOException {
		Runner r=new Runner(dr);
		ScreenShort ss= new ScreenShort(dr);
		r.clickOnRemeberMeCheckBox();
		trading.click();
		Collections.click();
		Assert.assertTrue(producctmessage.getText().equalsIgnoreCase("Collections"));
		ss.sc(producctmessage);
	}
	//tc209
	public void shoppingCartpage( ) throws InterruptedException, IOException {
		Runner r=new Runner(dr);
		ScreenShort ss= new ScreenShort(dr);
		r.clickOnRemeberMeCheckBox();
		visibilityOfElement(homepageproduct);
		String homepageproductt=homepageproduct.getText();
		homepageproduct.click();
		addtocart.click();
		visibilityOfElement(Shoppingcartproduct);
		String Shoppingcartproductt=Shoppingcartproduct.getText();
		Assert.assertTrue(Shoppingcart.getText().equalsIgnoreCase("SHOPPING CART"));
		Assert.assertEquals(homepageproductt, Shoppingcartproductt);
		ss.sc(Shoppingcart);
	}
	//tc210
	public void NotAbleToSeeProductInShoppingCartPage( ) throws InterruptedException, IOException {
		Runner r=new Runner(dr);
		ScreenShort ss= new ScreenShort(dr);
		r.clickOnRemeberMeCheckBox();
		String quantity=Shoppingcartbutton.getText();
		Shoppingcartbutton.click();
		Thread.sleep(2000);
		try {
			if(minus.isDisplayed()) {
				for(int i=0;i<=Integer.parseInt(quantity);i++) {
				if(Integer.parseInt(value.getAttribute("value"))!=0) {
					visibilityOfElement(Shoppingcartimage);
					minus.click();
				}
				}
				visibilityOfElement(Shoppingcartbuttonmsg);
				Assert.assertTrue(Shoppingcartbuttonmsg.getText().contains("NO PRODUCTS"));
				System.out.println(Shoppingcartbuttonmsg.getText());
				ss.sc(Shoppingcartbutton);
			}
			
		}catch (Exception e) {
			visibilityOfElement(Shoppingcartbuttonmsg);
			Assert.assertTrue(Shoppingcartbuttonmsg.getText().contains("NO PRODUCTS"));
			System.out.println(Shoppingcartbuttonmsg.getText());
			ss.sc(Shoppingcartbutton);
		}
	}
	//tc211
	public void seeProductInShoppingCartPage() throws InterruptedException, IOException {
		ScreenShort ss= new ScreenShort(dr);
		NotAbleToSeeProductInShoppingCartPage();
		returntoshop.click();
		Assert.assertTrue(producctmessage.getText().equalsIgnoreCase("New Arrivals"));
		String newarrivalsproductt=newarrivalsproduct.getText();
		newarrivalsproduct.click();
		addtocart.click();
		visibilityOfElement(Shoppingcartproduct);
		String Shoppingcartproductt=Shoppingcartproduct.getText();
		Assert.assertTrue(Shoppingcart.getText().equalsIgnoreCase("SHOPPING CART"));
		Assert.assertEquals(newarrivalsproductt, Shoppingcartproductt);
		System.out.println("product is  "+Shoppingcartproduct.getText());
		ss.sc(Shoppingcart);
	}
	
	//tc219
	public void seeShippingAndDeliveryPage(String prd,String x,String y) throws InterruptedException, IOException {
		JavaScrptClass js=new JavaScrptClass(dr);
		ScreenShort ss= new ScreenShort(dr);
		selectcategory(prd);
		goldpageproduct.click();
		ShoppingandDelivery.click();
		js.scrolll(x, y);
		ss.sc(ShoppingandDelivery2);
	}
	//tc220
	public void ableToTrackTheCashOnDelivery(String id,String mail,String x,String y) throws InterruptedException, IOException {
		Runner r=new Runner(dr);
		JavaScrptClass js=new JavaScrptClass(dr);
		ScreenShort ss= new ScreenShort(dr);
		r.clickOnRemeberMeCheckBox();
		String pwindo=dr.getWindowHandle();
		TrackOrder.click();
		Set<String> allwindows = dr.getWindowHandles();
		for(String window:allwindows) {
			if(!(pwindo.equals(window))) {
				dr.switchTo().window(window);
				break;
			}
		}
		Orderid.sendKeys(id);
		Orderemail.sendKeys(mail);
		Track.click();
		Assert.assertEquals(PaymentType.getText(), "Cash on delivery");
		System.out.println("PaymentType is "+PaymentType.getText());
		js.scrolll(x, y);
		ss.sc(PaymentType);
	}
}
