package Oxhead_property;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScrptClass {

	WebDriver dr;
	public JavaScrptClass(WebDriver dr2) {
		this.dr=dr2;
	}
	public WebElement highlite(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)dr;
		WebElement ob=(WebElement)js.executeScript("arguments[0].style.border='2px solid red'", ele);
		return ob;
	}
	public void scroll(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)dr;
		Point loc=ele.getLocation();
		js.executeScript("window.scrollBy"+loc);
	}
	public void scrolll(String x,String y) {
		JavascriptExecutor js=(JavascriptExecutor)dr;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}

}
