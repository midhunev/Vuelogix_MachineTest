package vimeoPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VimeoLoginPage {
	
	public WebDriver driver;
	By email = By.id("email_login");
	By password = By.id("password_login");
	By loginButton = By.xpath("//*[@id=\"__next\"]/div[2]/div/div[2]/div/section/section[5]/form/section[3]/button/span");
    By searchText = By.xpath("//*[@id=\"wrap\"]/div[2]/main/div/div/div[1]/div[1]/div/div[1]/section/div[1]/div/div/span/div/div[1]/div/div/a/span/span/span[2]");
	
	
	public VimeoLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	
	public void setLoginCredentials(String eId, String pswd)
	{
        // Provide Email Id
		driver.findElement(email).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(email).sendKeys(eId);
		
		// Provide Password
		driver.findElement(password).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(password).sendKeys(pswd);
	}

	public void login()
	{
		// Explicit wait to locate the login button
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement wb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Log in with an email')]")));
		wb.click();
	}
	
	public void loginVerify()
	{
		WebElement txt = driver.findElement(searchText);
		String expectedText = "Home";
		String actualText = txt.getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
}
