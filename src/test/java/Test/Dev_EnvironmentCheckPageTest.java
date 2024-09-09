package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import ehub.com.baseLibrary.BaseClass;
import ehub.com.constants.AppConstants;
import ehub.com.pages.EnvironmentCheckPage;
import ehub.com.pages.LoginPage;
import ehub.com.utils.PropertyUtility;

public class Dev_EnvironmentCheckPageTest extends BaseTest{
	
	LoginPage loginPage;
	EnvironmentCheckPage envCheckPage;
	
	@BeforeTest
	public void setupBrowser() {
		String url=PropertyUtility.getPropertyEnvironment("Dev_Env_URL").trim();
		setup(url);
		loginPage = new LoginPage(driver);
		envCheckPage= new EnvironmentCheckPage(driver);
	}
	
	@Test(priority = 1, enabled = true)
	public void Dev_Env_doLogin() {
		BaseClass.logExtentReport("Enter URL : "+ PropertyUtility.getPropertyEnvironment("Dev_Env_URL").trim());
		loginPage.doLogin(AppConstants.username, AppConstants.password);		
	}
	
	@Test(priority = 2, enabled = true)
	public void Dev_Env_verifyUserLogin() {
		String actualUserLogin=loginPage.verifyUserLogin();
		String expectedUserLogin=AppConstants.username;
		Assert.assertEquals(actualUserLogin, expectedUserLogin);
	}
	
	@Test(priority = 3, enabled = true)
	public void Dev_Env_verifyPolicyPage() {
		Boolean actual=envCheckPage.verifyPolicyPage();
		Assert.assertTrue(actual);		
	}
	
	@Test(priority = 4, enabled = true)
	public void Dev_Env_verifyPolicyDataShowing() {
		Boolean actual=envCheckPage.verifyPolicyDataShowing();
		Assert.assertTrue(actual);		
	}
	
	@Test(priority = 5, enabled = true)
	public void Dev_Env_verifyReportPage() {
		Boolean actual=envCheckPage.verifyReportPage();
		Assert.assertTrue(actual);		
	}
	
	@Test(priority = 6, enabled = true)
	public void Dev_Env_verifyReportDataShowing() {
		Boolean actual=envCheckPage.verifyReportDataShowing();
		Assert.assertTrue(actual);		
	}
	
	@Test(priority = 7, enabled = true)
	public void Dev_Env_verifyResultPage() {
		Boolean actual=envCheckPage.verifyResultPage();
		Assert.assertTrue(actual);		
	}
	
	@Test(priority = 8, enabled = true)
	public void Dev_Env_verifyResultDataShowing() {
		Boolean actual=envCheckPage.verifyResultDataShowing();
		Assert.assertTrue(actual);		
	}
}
