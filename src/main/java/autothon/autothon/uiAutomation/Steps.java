package autothon.autothon.uiAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import autothon.autothon.nonUI.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import autothon.autothon.helper.*;

public class Steps extends Thread{

	
	
	String browser;
	String device;
	String status;
	WebDriver driver;
	
	
	public Steps(String browser, String device) {
		super();
		this.browser = browser;
		this.device = device;
		this.status = status;
		if(this.device.toLowerCase().equals("android") && this.browser.toLowerCase().equals("chrome") ) {
			try {
				this.driver = androidChromeFactory();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(this.device.toLowerCase().equals("windows") && this.browser.toLowerCase().equals("chrome") ) {
			try {
				this.driver = winChromeFactory();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(this.device.toLowerCase().equals("windows") && this.device.toLowerCase().equals("firefox") ) {
			try {
				this.driver = firefoxFactory();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private WebDriver androidChromeFactory() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();// DesiredCapabilities.android();
		cap.setCapability("deviceName", "Moto G (5S) Plus");
		cap.setCapability("udid", "ZY32285CLZ");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("browserName", "Chrome");
		//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		WebDriver d = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		return d;
	}

	private WebDriver firefoxFactory() throws MalformedURLException {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--start-maximized");
		//options.addArguments("--headless");
		//WebDriver d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver d = new FirefoxDriver(options);
		return d;
	}

	private WebDriver winChromeFactory() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		//options.addArguments("--headless");
		//WebDriver d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		WebDriver d = new ChromeDriver(options);
		return d;
	}

	public void startExecution() {
		
		SeleniumUtilities utl = new autothon.autothon.helper.SeleniumUtilities();
		 
		HTMLOutputWriter html = new HTMLOutputWriter(
				"C:\\Users\\i332954\\Desktop\\" +device, "Logs");
		//1  open the url
		//
		try{
			
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			html.createTable("Main");
			utl.goToPage(driver, "https://youtube.com", this.device+"_1.png", html); // go to you tube 1
			WebDriverWait wait = new WebDriverWait(driver, 120);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div/div/input")));
			utl.enterInput(driver, "//form/div/div/input", "step-inforum", this.device+"2.png", html); // input in search bar 2
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/button")));
			utl.findAndClickElement(driver, "//form/button", "dummy", html); // click on search button 
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/user/stepinforum' and @class='yt-simple-endpoint style-scope ytd-channel-renderer']")));
			WebElement e = utl.findElement(driver, "//a[@href='/user/stepinforum' and @class='yt-simple-endpoint style-scope ytd-channel-renderer']"); //find the searched channel name;
			
			if(!e.isDisplayed()) {
				Thread.sleep(8000);
			}
			
			utl.clickElement(driver, e, this.device+"_3.png");  // click on the channel name 3 
			
			Thread.sleep(7000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//paper-tab[contains(*,'Videos')]")));
			
			e = utl.findElement(driver, "//paper-tab[contains(*,'Videos')]");
			if(!e.isDisplayed()) {
				Thread.sleep(8000);
			}
			
			utl.clickElement(driver, e, this.device+"_4.png");
			
			//utl.findAndClickElement(driver, "//*[@id=\"tabsContent\"]/paper-tab[2]/div",  this.device+"_4.png", html); // click on videos tab; 4
			
			// API call   String  5
			youtube_api api = new youtube_api();
			String movieName = api.getMovieName();
			System.out.println("Movie name caught in UI is :"+ movieName);
			
			
			
			//((JavascriptExecutor) driver).executeScript("window.scrollTo.(0,document.getElementsByTagName('ytd-browse')[1])");
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,5000)");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(5000,7000)");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(7000,10000)");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(10000,15000)");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(15000,17000)");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(17000,25000)");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(17000,30000)");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(30000,35000)");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(35000,40000)");
			Thread.sleep(3000);
			WebElement element = utl.findElement(driver, "//a[contains(@aria-label,'"+movieName+"')]"); 
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()",element);
			((JavascriptExecutor) driver).executeScript("arguments[0].focus()",element);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,-200)");
			
			System.out.println(" scrolled successfully");
			
			 // find the video link from the entire list
			//utl.scrollDown(driver, element );  // scroll up tp the element 5
			
			Screenshot.takeScreenshot(driver, device+"_6.png");
			
			utl.clickElement(driver, element, device+"_8.png");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"movie_player\"]/div[21]/div[2]/div[2]/button[3]")));
			
			utl.findAndClickElement(driver, "//*[@id=\"movie_player\"]/div[21]/div[2]/div[2]/button[3]", device+"_9.png", html);
			Thread.sleep(3000);
			utl.findAndClickElement(driver, "//*[@id=\"ytp-id-18\"]/div/div/div[3]/div[1]", device+"_10.png", html);
			Thread.sleep(3000);
			utl.findAndClickElement(driver, "//*[@id=\"movie_player\"]/div[21]/div[2]/div[2]/button[3]", device+"_11.png", html);
			Thread.sleep(3000);
			//utl.findAndClickElement(driver, "//*[@id=\"ytp-id-18\"]/div/div/div[4]/div", device+"_11.png", html);
			//Thread.sleep(3000);
			
			String mid = api.getMovieID(movieName);
			api.getRelatedMovies(mid,movieName);
			api.postData();
			api.Validate();
		}
		catch (Exception e) {
			System.out.println("Exception E " + e.getMessage());
			html.closeTable(0);
			
		} finally {
			// html.closeHTML();
			html.closeHTML();
			html.cleanup();
			
		}
	
	}
	
	public void run() {
		startExecution();
	}
	
}
