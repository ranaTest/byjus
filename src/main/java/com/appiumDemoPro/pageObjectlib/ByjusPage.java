package com.appiumDemoPro.pageObjectlib;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Constant;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.appiumDemoPro.Generic.BaseLibrary;
import com.appiumDemoPro.Generic.Constantlib;
import com.appiumDemoPro.Generic.ExcelDataMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ByjusPage extends BaseLibrary
{
	
	
	public void OTPverify() throws Exception
	{
		driver.startActivity(Constantlib.msgappPackage,Constantlib.msgappActivity);
		 waitForPageLoad();
		  getOTP();
		  waitForPageLoad();
         clickOnBackButton();
		    
		  waitForPageLoad();
	    //allow button
		clickOnButton(0.64,0.63);
	   // ad.tap(1,1242,687,30);
		waitForOtpVerification();
	    //enter otp
		clickOnButton(0.64,0.63);
		
	}
	public void enterPhoneNo() throws Throwable 
	{
		 WebElement textBoard=driver.findElement(By.xpath("//android.widget.EditText"));
		
		 textBoard.click();
		Thread.sleep(2000);
		 textBoard.clear();
		 Thread.sleep(2000);
		ExcelDataMethod edm=PageFactory.initElements(driver, ExcelDataMethod.class);
		
		String phoneno=edm.getExcelData("sheet1", 0, 0);
		System.out.println(phoneno);
		textBoard.sendKeys(phoneno);
		 System.out.println(textBoard.getText());
		 if(!(textBoard.getText().equals(phoneno)))
		 {
			 textBoard.clear();
			 textBoard.sendKeys(phoneno);
		 }

	}
	/*public void enterPhoneNo() throws InterruptedException 
	{
		driver.tap(1,215,842,30);
		Thread.sleep(2000);
		driver.tap(1,215,842,30);
		Thread.sleep(2000);
		driver.tap(1,1118,737,30);
		Thread.sleep(2000);
		driver.tap(1,620,934,30);
		Thread.sleep(2000);
		driver.tap(1,1118,737,30);
		Thread.sleep(2000);
		driver.tap(1,620,934,30);
		Thread.sleep(2000);
		driver.tap(1,594,594,30);
		Thread.sleep(2000);
		driver.tap(1,594,594,30);
		Thread.sleep(2000);
		driver.tap(1,1012,823,30);
		Thread.sleep(2000);
		driver.tap(1,209,823,30);
		Thread.sleep(2000);

	}*/
	public void takeScreenShot(String filename) throws IOException
	{
		File srcFiler=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFiler, new File("./appiumDemoPro/screenshot"+filename+".png"));
	}
	
	public void waitForPageLoad() throws Exception  
	{
		//ad.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


		Thread.sleep(7000);
	}

	public void clickOnButton(double x_offset,double y_offset) 
	{
		Dimension dsize =driver.manage().window().getSize();
		int x =(int)(dsize.width*x_offset);
		int y=(int)(dsize.height*y_offset);
		driver.tap(1,x,y,30);
	}
	
	public void SelectOptions(double x_offset,double y_offset) 
	{
		Dimension dsize =driver.manage().window().getSize();
		int x =(int)(dsize.width*x_offset);
		int y=(int)(dsize.height*y_offset);
		driver.tap(1,x,y,30);
	}
	
	public void selectGame(double x_offset,double y_offset) 
	{
		Dimension dsize =driver.manage().window().getSize();
		int x =(int)(dsize.width*x_offset);
		int y=(int)(dsize.height*y_offset);
		driver.tap(1,x,y,30);
	}
	
	public void getOTP() 
	{
		String text=driver.findElement(By.xpath(Constantlib.OTPXpath)).getText();
		String[] word=text.split("\\s");
		    try{
		        if(word[(word.length-1)].length()==4){
		            int k=Integer.parseInt(word[(word.length-1)]);
		            System.out.println(k);
	                }}
		       catch(Exception e){
		            e.printStackTrace();
		        }
	}
	public void waitForOtpVerification() throws InterruptedException
	{
		Thread.sleep(21000);
	}
	public void clickOnBackButton() 
	{
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}

}
