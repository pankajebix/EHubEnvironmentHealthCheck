package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import ehub.com.baseLibrary.BaseClass;
import ehub.com.pages.EnvironmentCheckPage;
import ehub.com.pages.LoginPage;

public class EnvironmentCheckTest extends BaseTest{
	
	public Object[][] data;
	
	@DataProvider(name = "Data")
	public Object[][] runData() throws IOException {
		EnvironmentCheckPage envCheckPage= new EnvironmentCheckPage(driver);
		data = envCheckPage.getData();
		return data;
	}
	
	@Test(dataProvider = "Data", priority = 1)
	public void environmentCheck(String environmentName, String url, String userName, String password) {
		try {
			BaseClass.logExtentReport("Environment Name : "+environmentName);
			BaseClass.logExtentReport("URL : "+url);
			setup(url);
			System.out.println(driver);
			LoginPage loginPage = new LoginPage(driver);
			EnvironmentCheckPage envCheckPage= new EnvironmentCheckPage(driver);
			
			loginPage.doLogin(userName, password);
			
			String actualUserLogin=loginPage.verifyUserLogin();
			String expectedUserLogin=userName;		
			
			Boolean actual=envCheckPage.verifyPolicyPage();
			
			Boolean actual1=envCheckPage.verifyPolicyDataShowing();
			
			Boolean actual2=envCheckPage.verifyReportPage();
			
			Boolean actual3=envCheckPage.verifyReportDataShowing();
			
			Boolean actual4=envCheckPage.verifyResultPage();
			
			Boolean actual5=envCheckPage.verifyResultDataShowing();
			
			Assert.assertEquals(actualUserLogin, expectedUserLogin);
			Assert.assertTrue(actual, "Verify policy page");
			Assert.assertTrue(actual1, "Verify policy data showing");	
			Assert.assertTrue(actual2, "Verify report page");
			Assert.assertTrue(actual3, "Verify report data showing");
			Assert.assertTrue(actual4, "Verify result page");
			Assert.assertTrue(actual5, "Verify result data showing");			
		} catch (Exception e) {
		}	
	}
}
