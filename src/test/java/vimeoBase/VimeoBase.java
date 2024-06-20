package vimeoBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class VimeoBase {
	
	public WebDriver driver;
	String url = "https://vimeo.com/log_in";
	String expectedText = "Home";
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

}
