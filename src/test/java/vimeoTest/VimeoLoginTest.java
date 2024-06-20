package vimeoTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import vimeoBase.VimeoBase;
import vimeoPage.VimeoLoginPage;
import vimeoUtil.VimeoUilities;

public class VimeoLoginTest extends VimeoBase
{
	
	@Test(priority=1)
	public void login()
	{
		VimeoLoginPage vm = new VimeoLoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String xl = "./target//TestData.xlsx";
		String sheet = "Sheet1";
		int rowCount = VimeoUilities.getRowCount(xl, sheet);
		System.out.println("Row Count is " + rowCount);
		
		for(int i=1;i<=rowCount;i++)
		{
			
			String email = VimeoUilities.getCellValue(xl, sheet, i, 0);
			System.out.println("Email Id ----" + email);
			String password = VimeoUilities.getCellValue(xl, sheet, i, 1);
			System.out.println("Password ----" + password);
			vm.setLoginCredentials(email, password);
			vm.login();
		}
		vm.loginVerify();
	}
}
	
