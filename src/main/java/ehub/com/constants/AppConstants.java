package ehub.com.constants;

import java.util.Arrays;
import java.util.List;

import ehub.com.utils.PropertyUtility;

public class AppConstants {

	//public static final String pathofExcelDataAsPerEnv =BaseClass.chooseTestEnvironment();
	//static ExcelUtil excUtil = new ExcelUtil(System.getProperty("user.dir") +pathofExcelDataAsPerEnv );

	public static final int DEFAULT_MEDIUM_TIME_OUT = 10;
	public static final int DEFAULT_SHORT_TIME_OUT = 5;
	public static final int DEFAULT_LONG_TIME_OUT = 20;
	public static final int DEFAULT_VERY_LONG_TIME_OUT = 20;

	public static final String LOGIN_PAGE_TITLE_VALUE = "ExposureHub";
	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "ebixexchange.com/login";

	public static final String userID_Label = "User Id";
	public static final String password_Label = "Password";
	public static final String login_Button_Text = "LOGIN";
	public static final String powered_By_Text = "Powered By";

	public static final String Expected_Error_Login_Message = "Message(s)";
	public static final String Expected_userId_Error_Message = "User Id is required";
	public static final String Expected_Password_Error_Message = "Password is required";

	public static final String URL_After_User_Login = "";
	public static final String Title_After_User_Login = "";

	public static final List<String> verify_Error_Message_Of_LoginPage = Arrays.asList("Message(s)",
			"User Id is required", "Password is required");

	public static final List<String> expected_URL_and_Title_List_After_Login = Arrays.asList(URL_After_User_Login,
			Title_After_User_Login);
	
	//************************************ Environment Details *********************************
	public static final String environment_Name_POC3="poc3";
	public static final String environment_Name_DEMO="demo";
	
	// *********************Sheet Names***********************//
	public static final String REGISTER_SHEET_NAME = "register";

	// *******************************************************************************************************
	//public static final String release_Version = excUtil.getCellData("basicDetails", "Value", 4).trim();
	//public static final String release_Version = PropertyUtility.getPropertyEnvironment("releaseVersion").trim();
	
	public static final String username = PropertyUtility.getPropertyEnvironment("Username").trim();
	public static final String password = PropertyUtility.getPropertyEnvironment("Password").trim();
	
}

//test data : excel/DB/json/xml//static test data
//constants: final static 
//env data: properties