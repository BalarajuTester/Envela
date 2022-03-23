package Oxhead_property;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocatersClass  {



	@FindBy(xpath = "//button[@title='Close (Esc)']") public WebElement popupclose;
	@FindBy(xpath = "//header//div[1]//div[2]//div//div//div[3]//div[2]//a") public WebElement loginregister;   

	@FindBy(name = "username") public WebElement username;
	@FindBy(name = "password") public WebElement password;                                                  
	@FindBy(name = "rememberme") public WebElement rememberme;
	@FindBy(name = "login") public WebElement loginButton;
	@FindBy(xpath = "//div[2]//div//div//div[3]//div[2]//a//span[2]") public WebElement loginusername;

	@FindBy(xpath = "//div[11]//form//div[1]//a") public WebElement lostpassword;
	@FindBy(xpath = "//p[contains(text(),'Lost your password?')]") public WebElement lostyourpassword;

	@FindBy(xpath = "//input[@id='user_login']") public WebElement uname;
	@FindBy(xpath = "//button[@value='Reset password']") public WebElement resetpassword;
	@FindBy(xpath = "//div[@class='woocommerce-message']") public WebElement passwordmessage;
	@FindBy(xpath = "//input[@type='email']") public WebElement gmail;
	@FindBy(xpath = "//input[@type='password']") public WebElement gmailPassword;
	@FindBy(xpath = "//a[contains(@aria-label,'Google apps')]") public WebElement logo;
	@FindBy(xpath = "//div[@class='gb_Td gb_Va gb_Id gb_Wd']//div[2]//iframe") public WebElement frame;//div[@class='gb_Td gb_Va gb_Id gb_Wd']//div[2]//iframe
	@FindBy(xpath = "//div[@class='qWuU9c']//ul[1]//li[7]") public WebElement gmaillogo;
	@FindBy(xpath = "//button[@class='M6CB1c rr4y5c']") public WebElement dontswitch;
	@FindBy(xpath = "//tbody//tr[1]//td[5]//span[text()='Password Reset Request for Oxhead']") public WebElement mail;
	@FindBy(xpath = "//div//p//a[contains(text(),'Click here')]") public WebElement resetlink;
	@FindBy(xpath = "//div[@class='G-atb D E']//div[@class='T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA']") public WebElement deletmail;
	@FindBy(xpath = "//input[@type='password' and @name='password_1']") public WebElement newPwd;
	@FindBy(xpath = "//input[@type='password' and @name='password_2']") public WebElement ReNewPwd;
	@FindBy(xpath = "//button[@type='submit' and @value='Save']") public WebElement save;
	@FindBy(xpath = "//ul[@class='woocommerce-error']//li") public WebElement passworderrormessage;

	@FindBy(xpath = "//a[text()='Create an Account']") public WebElement createaccount;
	@FindBy(xpath = "//div[11]//div[1]//div//a") public WebElement loginclose; 

	@FindBy(xpath = "//input[@placeholder='Your email address']") public WebElement popupemail;
	@FindBy(xpath = "//input[@type='submit']") public WebElement popupsubmit;
	@FindBy(xpath = "//div[@role='alert']") public WebElement popupmessage;


	//search for product,selecr category,product
	@FindBy(xpath = "//div[2]//input[@placeholder='Search for products']") public WebElement productsearch;
	@FindBy(xpath = "//p[@class='woocommerce-info']") public WebElement productErrormsg;
	@FindBy(xpath = "//div[@class='wd-search-cat wd-scroll']") public WebElement selecategory;
	@FindBy(xpath = "//div[@class='wd-search-cat wd-scroll']//ul[@class='wd-sub-menu']//li") public List<WebElement> selecategorylist; 
	@FindBy(xpath = "//a[@data-val='all-products']") public WebElement AllProducts; 
	@FindBy(xpath = "//a[@data-val='gold']") public WebElement Gold; 
	@FindBy(xpath = "//a[@data-val='membership']") public WebElement Membership; 
	@FindBy(xpath = "//a[@data-val='palladium']") public WebElement Palladium; 
	@FindBy(xpath = "//a[@data-val='platinum']") public WebElement Platinum; 
	@FindBy(xpath = "//a[@data-val='silver']") public WebElement Silver;
	@FindBy(xpath = "//span[@class='woof_remove_ppi']") public WebElement productmessage;
	@FindBy(xpath = "//div[1]//div[2]//form//button") public WebElement searchbutt;     //html/body/div[1]/header/div[1]/div[2]/div/div/div[2]/div[2]/form/button
	@FindBy(css = "li[class='cat-item cat-item-88 cat-parent']") public WebElement junksilver;
	@FindBy(css = "a[class='category-link wd-fill']") public WebElement silverproduct;



	//browser category
	@FindBy(xpath = "//span[@class='menu-opener color-scheme-light']") public WebElement Browsecategories;
	@FindBy(xpath = "//div[@class='wd-dropdown wd-dropdown-cats ']//ul//li") public List<WebElement> Browsecategorieslist; 
	@FindBy(xpath = "//ul[@class='children list-shown']") public WebElement PalladiumBullion;
	@FindBy(css = "a[class='category-link wd-fill']") public WebElement productPalladiumBullion;
	@FindBy(xpath = "//div[5]/div[2]/div/div[1]/a/img") public WebElement Bar;
	@FindBy(xpath = "//h1[@class='entry-title title']") public WebElement producctmessage;


	@FindBy(xpath="//div[@class='product-information']//h3//a[text()='Gold Swiss 20 Franc']") public WebElement goldpageproduct;
	@FindBy(xpath="//div[@class='summary-inner']//button[@name='add-to-cart']") public WebElement addtocart;
	@FindBy(xpath="//div[@class='wc-proceed-to-checkout']") public WebElement Proceedtocheckout;
	@FindBy(xpath="//input[@name='billing_company']") public WebElement company;
	@FindBy(xpath="//input[@placeholder='House number and street name' and @class='input-text wooccm-required-field']") public WebElement street;
	@FindBy(xpath="//input[@class='input-text wooccm-required-field' and @name='billing_city']") public WebElement city;
	@FindBy(xpath="//span[@class='select2-selection__arrow']") public WebElement state;
	@FindBy(xpath="//input[@name='billing_postcode']") public WebElement zipcode;
	@FindBy(xpath="//input[@name='billing_phone']") public WebElement phone;


	@FindBy(xpath="//div[@class='payment-methods-link']") public WebElement Paymentmethods;
	@FindBy(xpath="//a[@class='button']") public WebElement Addpaymentmethod1;
	@FindBy(xpath="//input[@id='authnet-card-number']") public WebElement cardnumber;
	@FindBy(xpath="//input[@id='authnet-card-expiry']") public WebElement Expiry;
	@FindBy(xpath="//input[@id='authnet-card-cvc']") public WebElement Cardcode;
	@FindBy(xpath="//div[@class='form-row']//button[@type='submit']") public WebElement Addpaymentmethod2;
	@FindBy(xpath="//a[@class='button delete']") public WebElement deletpaymentmethod;

	@FindBy(xpath="//div[@class='orders-link']") public WebElement orders;
	@FindBy(xpath="//a[@class='woocommerce-button button view']") public WebElement ordersview;
	@FindBy(xpath="//h2[@class='woocommerce-order-details__title']") public WebElement ordersdetails;
	@FindBy(xpath="//div[@class='customer-logout-link']") public WebElement dashboardlogout;
	@FindBy(xpath="//div[3]//div[2]//div//ul//li[8]//a") public WebElement myaccountlogout;

	@FindBy(xpath="//div[@class='whb-flex-row whb-header-bottom-inner']//ul//li[@id='menu-item-8692']") public WebElement home;//header//div[1]//div[3]//div//div//div[2]//div//ul//li[1]//a//span
	@FindBy(xpath="//div[@id='myHeader']") public WebElement Stickyhesder;
	@FindBy(xpath="//div[@class='whb-flex-row whb-header-bottom-inner']//ul//li[@id='menu-item-7887']") public WebElement trading;
	@FindBy(xpath="//div[@class='whb-flex-row whb-header-bottom-inner']//ul//li[@id='menu-item-7887']//ul//li//a[text()='New Arrivals']") public WebElement NewArrivals;
	@FindBy(xpath="//div[@class='whb-flex-row whb-header-bottom-inner']//ul//li[@id='menu-item-7887']//ul//li//a[text()='Collections']") public WebElement Collections ;
	@FindBy(xpath="//div[@class='vc_row wpb_row vc_row-fluid vc_custom_1591793172822']//h3[@class='wd-entities-title']//a[contains(text(),'1 oz Gold A')]") public WebElement homepageproduct;
	@FindBy(xpath="//td[@class='product-name']") public WebElement Shoppingcartproduct;
	@FindBy(xpath="//li[@class='step-cart step-active']") public WebElement Shoppingcart;
	@FindBy(xpath="//header//div//span[@class='wd-tools-icon wd-icon-alt']") public WebElement Shoppingcartbutton;
	@FindBy(xpath="//input[@class='minus']") public WebElement minus;
	@FindBy(xpath="//input[@name='quantity']") public WebElement value;
	@FindBy(xpath="//a[@class='cart-item-image']") public WebElement Shoppingcartimage;
	@FindBy(xpath="//p[@class='woocommerce-mini-cart__empty-message empty title']") public WebElement Shoppingcartbuttonmsg;
	@FindBy(xpath="//a[@class='btn btn-size-small btn-color-primary wc-backward']") public WebElement returntoshop;
	@FindBy(xpath="//h3[@class='wd-entities-title']//a[contains(text(),'1 oz Gold A')]") public WebElement newarrivalsproduct;
	@FindBy(xpath="//li[@class='wd_additional_tab_tab']//a") public WebElement ShoppingandDelivery;
	@FindBy(xpath="//li[@class='wd_additional_tab_tab active']//a") public WebElement ShoppingandDelivery2;

	@FindBy(xpath="//div[@class='whb-flex-row whb-header-bottom-inner']//div[@class='wd-button-wrapper text-left']") public WebElement TrackOrder;
	@FindBy(xpath="//input[@id='orderid']") public WebElement Orderid;
	@FindBy(xpath="//input[@id='order_email']") public WebElement Orderemail;
	@FindBy(xpath="//button[@name='track']") public WebElement Track;
	@FindBy(xpath="//div[@class='responsive-table']//tr[4]//td") public WebElement PaymentType;

	@FindBy(xpath="//h4[@class='rs-layer']") public List<WebElement> DynamicPname;
	@FindBy(xpath="//a[@class='rs-layer rev-btn rs-waction rs-wclickaction']") public List<WebElement> DynamicShopnow;
	@FindBy(xpath="//a[@id='slider-3-slide-7-layer-5']") public WebElement SilverShopnow;
	@FindBy(xpath="//a[@id='slider-3-slide-109-layer-5']") public WebElement platiniumShopnow;
	@FindBy(xpath="//a[@id='slider-3-slide-6-layer-5']") public WebElement goldShopnow;
	@FindBy(xpath="//rs-arrow[@class='tp-rightarrow tparrows custom noSwipe']") public WebElement rightarrow;
	@FindBy(xpath="//rs-arrow[@class='tp-leftarrow tparrows custom noSwipe']") public WebElement leftarrow;


	@FindBy(xpath="//article//div//div[5]//div[1]//div//div//div//div//div[2]//div//div[3]//div//a") public WebElement StsticShopnow1;
	@FindBy(xpath="//article//div//div[5]//div[2]//div//div//div//div//div[2]//div//div[3]//div//a") public WebElement StsticShopnow2;
}
