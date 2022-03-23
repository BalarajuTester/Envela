package Oxhead_property;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class ScreenShort {

	WebDriver dr;
	public ScreenShort(WebDriver dr) {
		this.dr=dr;
	}

	Calendar cal=Calendar.getInstance();
	Date time=cal.getTime();
    
	public void visibilityOfElement(WebElement ele)  {
		new WebDriverWait(dr,20,1).until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void sc(WebElement ele,String attribute) throws IOException {
		visibilityOfElement(ele);
		TakesScreenshot ts=(TakesScreenshot)dr;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\BalarajuGone\\Balaraju\\Eclipse-Workspace\\Envela\\Screenshort\\"+ele.getAttribute(attribute)+".jpg");
		Files.copy(src, trg);
	}


	public void sc(WebElement ele) throws IOException {
		visibilityOfElement(ele);
		TakesScreenshot ts=(TakesScreenshot)dr;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\BalarajuGone\\Balaraju\\Eclipse-Workspace\\Envela\\Screenshort\\"+ele.getText()+".jpg");
		Files.copy(src, trg);

	}
}
