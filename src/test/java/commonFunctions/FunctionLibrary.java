package commonFunctions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class FunctionLibrary {
	public static WebDriver driver;
	public static Properties conpro;
	
	
	
	
	public static WebDriver startBrowser() throws Throwable
	{
	  conpro=new Properties();
	  conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
		if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			Reporter.log("browser value is not matching");
			
		}
		
		return driver;
		
	}
	
	
	public static void openUrl()
	{
		driver.get(conpro.getProperty("url"));
	}
	
	
	public static void waitForElement(String ltype,String lvalue,String Tdata) throws Throwable
	{
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Tdata)));
		
		if(ltype.equalsIgnoreCase("xpath"))
		{
			Thread.sleep(2000);
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lvalue)));
		}
		if(ltype.equalsIgnoreCase("name"))
		{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(lvalue)));
		}	
		if(ltype.equalsIgnoreCase("id"))
		{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(lvalue)));
		}
		
	}
	
	
	public static void typeAction(String ltype,String lvalue,String Tdata)
	{
		if(ltype.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(lvalue)).clear();
			driver.findElement(By.xpath(lvalue)).sendKeys(Tdata);
		}
		if(ltype.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(lvalue)).clear();
			driver.findElement(By.name(lvalue)).sendKeys(Tdata);
		}
		if(ltype.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(lvalue)).clear();
			driver.findElement(By.id(lvalue)).sendKeys(Tdata);
		}

	}
	
	
	public static void clickAction(String ltype,String lvalue) throws Throwable
	{
		if(ltype.equalsIgnoreCase("xpath"))
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath(lvalue)).click();
		}
		if(ltype.equalsIgnoreCase("name"))
		{
			Thread.sleep(3000);
			driver.findElement(By.name(lvalue)).click();
		}
		if(ltype.equalsIgnoreCase("id"))
		{
			Thread.sleep(3000);
			driver.findElement(By.id(lvalue)).sendKeys(Keys.ENTER);
		}
	}
	
	
	public static void validateTitle(String exp_title)
	{
		String act_title=driver.getTitle();
		try
		{
			Assert.assertEquals(act_title, exp_title,"title not matching");
		}catch(AssertionError a)
		{
			System.out.println(a.getMessage());
		}
	}
	
	
	public static void captureData(String ltype,String lvalue) throws Throwable
	{
		String empno="";
		if(ltype.equalsIgnoreCase("xpath"))
		{
		empno=driver.findElement(By.xpath(lvalue)).getAttribute("value");
		}
		if(ltype.equalsIgnoreCase("name"))
		{
		empno=driver.findElement(By.name(lvalue)).getAttribute("value");
		}
		if(ltype.equalsIgnoreCase("id"))
		{
		empno=driver.findElement(By.id(lvalue)).getAttribute("value");
		}
		
		FileWriter fw=new FileWriter("./CaptureData/Employee.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(empno);
		bw.flush();
		bw.close();
		
	
		
	}
	
	public static void empTable() throws Throwable
	{
		FileReader fr=new FileReader("./CaptureData/Employee.txt");
		BufferedReader br=new BufferedReader(fr);
		String Exp_data= br.readLine();
		driver.findElement(By.xpath("//a[contains(.,'Employee List')]")).click();
		driver.findElement(By.xpath("//input[@id='empsearch_id']")).clear();
		driver.findElement(By.xpath("//input[@id='empsearch_id']")).sendKeys(Exp_data);

		String Act_data=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[2]")).getText();
		try {
			Assert.assertEquals(Exp_data, Act_data,"Emp not added");
		
		} catch (AssertionError e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public static void closeBrowser() throws Throwable
	{
		Thread.sleep(2000);
		driver.quit();
	}
	public static String generateDate()
	{
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyy_mm_dd");
		return df.format(date);
	}
}
