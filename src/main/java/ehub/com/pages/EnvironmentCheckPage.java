package ehub.com.pages;

import java.io.FileInputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import ehub.com.constants.AppConstants;
import ehub.com.utils.ElementUtil;

public class EnvironmentCheckPage {
	
	WebDriver driver;
	private ElementUtil eleUtil;	
	static Logger log = Logger.getLogger(LoginPage.class);
	
	public EnvironmentCheckPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		eleUtil = new ElementUtil(driver);
	}
	@FindBy(xpath = "//span[contains(.,'Policy')]")
	private WebElement HomePage_PolicyLinkButton;
	
	@FindBy(xpath = "//span[text()='Policy ']")
	private WebElement PolicyPlus_Button;
	
	@FindBy(xpath = "//span[text()='Report ']")
	private WebElement reportPlus_Button;
	
	@FindBys(@FindBy(xpath = "//div[@col-id='actions' and @role='gridcell']//button"))
	private List<WebElement> rowSizeOfPolicyData;
	
	@FindBy(xpath = "//div[@class='nav-border-bottom']/div/ul/li/a[@target='_blank' and text()='Report']")
	private WebElement reportHeaderLinkFromPolicyPage;
	
	@FindBy(xpath = "//div[@class='nav-border-bottom']/div/ul/li/a[@target='_blank' and text()='Result']")
	private WebElement resultHeaderLinkFromPolicyPage;
	
	@FindBy(xpath = "//h4[text()='ResultHub']")
	private WebElement resultHubTextEle;
	
	static DataFormatter formatter = new DataFormatter();
	
	public Object[][] getData(){
		Object data[][] = null;
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\EHEnvironmentList.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount = sheet.getPhysicalNumberOfRows();// total row
			XSSFRow row = sheet.getRow(0);// all cells in row 0
			int colCount = row.getLastCellNum();// total column
			data= new Object[rowCount - 1][colCount];
			for (int i = 0; i < rowCount - 1; i++) {
				row = sheet.getRow(i + 1);
				for (int j = 0; j < colCount; j++) {
					// data[i][j]=row.getCell(j);//but here data might be of string,int,char so we
					// use DataFormatter to convert all into string.
					XSSFCell cell = row.getCell(j);
					data[i][j] = formatter.formatCellValue(cell);
				}
			}
			wb.close();
		} catch (Exception e) {
		}		
		return data;
	}
	public Boolean verifyPolicyPage() {
		Boolean actual = false;
		try {
			eleUtil.waitForElementToBeClickable(AppConstants.DEFAULT_LONG_TIME_OUT, HomePage_PolicyLinkButton);
			HomePage_PolicyLinkButton.click();
			eleUtil.waitForElementToBeClickable(AppConstants.DEFAULT_MEDIUM_TIME_OUT, PolicyPlus_Button);
			actual=PolicyPlus_Button.isEnabled();			
		} catch (Exception e) {
			System.out.println("Issue in EnvironmentCheckPage.verifyPolicyPage "+e);
		}
		return actual;
	}
	
	public Boolean verifyPolicyDataShowing() {
		Boolean actual = false;		
		try {
			int rowSizeOfPolicy=rowSizeOfPolicyData.size();
			//System.out.println("Row size of Policy : "+rowSizeOfPolicy);
			if(rowSizeOfPolicy>0) {
				actual=true;
			}			
		} catch (Exception e) {
			System.out.println("Issue in EnvironmentCheckPage.verifyPolicyDataShowing "+e);
		}
		return actual;		
	}
	
	public Boolean verifyReportPage() {
		Boolean actual = false;
		try {
			reportHeaderLinkFromPolicyPage.click();
			eleUtil.waitForElementToBeClickable(AppConstants.DEFAULT_MEDIUM_TIME_OUT, reportPlus_Button);
			actual=reportPlus_Button.isEnabled();			
		} catch (Exception e) {
			System.out.println("Issue in EnvironmentCheckPage.verifyReportPage "+e);
		}
		return actual;
	}
	
	public Boolean verifyReportDataShowing() {
		Boolean actual = false;		
		try {
			int rowSizeOfPolicy=rowSizeOfPolicyData.size();
			//System.out.println("Row size of Report : "+rowSizeOfPolicy);
			if(rowSizeOfPolicy>0) {
				actual=true;
			}			
		} catch (Exception e) {
			System.out.println("Issue in EnvironmentCheckPage.verifyReportDataShowing "+e);
		}
		return actual;		
	}
	
	public Boolean verifyResultPage() {
		Boolean actual = false;
		try {
			resultHeaderLinkFromPolicyPage.click();
			eleUtil.waitForElementVisible(resultHubTextEle, AppConstants.DEFAULT_SHORT_TIME_OUT);
			actual=resultHubTextEle.isEnabled();			
		} catch (Exception e) {
			System.out.println("Issue in EnvironmentCheckPage.verifyResultPage "+e);
		}
		return actual;
	}
	
	public Boolean verifyResultDataShowing() {
		Boolean actual = false;		
		try {
			int rowSizeOfPolicy=rowSizeOfPolicyData.size();
			//System.out.println("Row size of Result : "+rowSizeOfPolicy);
			if(rowSizeOfPolicy>0) {
				actual=true;
			}			
		} catch (Exception e) {
			System.out.println("Issue in EnvironmentCheckPage.verifyResultDataShowing "+e);
		}
		return actual;		
	}
}
