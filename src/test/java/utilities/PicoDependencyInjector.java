package utilities;
import pageObjects.POM_AddNewUser;
import pageObjects.POM_LoginPage;
import pageObjects.POM_UserPageValidation;


public class PicoDependencyInjector {
	/*
	 * In this class we declare the variables that are to be used commonly. Mind that, they
	 * are initialized in their respective classes and pose a state (initialized).
	 * We just declare them in this class so that they can be used across the step
	 * definition classes. */	
	 
	 public ExcelReader excelreader;
	 public POM_LoginPage loginPage;
	 public POM_AddNewUser addnewUser;
	 public POM_UserPageValidation userPageValidation;
	 public String loginPageTitle;
	 
	 public String validUsername;
	 public String validPassword;
	 public String loggedInUsername;
	 public	String registredUserName;
	 
	 public String FirstName;
	 public String MiddleName;
	 public String LastName;
	 public String Location;
	 public int PhoneNo;
	 public String LinkedIn;
	 public String UserRole;
	 public String UserRoleStatus;
	 public String UserVisaStatus;
	 public String UnderGraduate;
	 public String PostGraduate;
	 public String EmailAddress;
	 public String UserComments;
	 public String TimeZone;
	 
}
