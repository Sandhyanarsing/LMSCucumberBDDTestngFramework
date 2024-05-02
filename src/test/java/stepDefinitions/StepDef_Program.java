package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ExcelReader;
import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_LoginPage;
import pageObjects.POM_ProgramPage;
import utilities.LoggerLoad;
import utilities.PicoDependencyInjector;

public class StepDef_Program {

	PicoDependencyInjector picoDepInj;

	public StepDef_Program(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}
	
	@When("user enters valid admin username as {string} and valid password as {string}")
	public void user_enters_valid_admin_username_as_sdetorganizers_gmail_com_and_valid_password_as(String username ,String password) {
		picoDepInj.loginPage= new POM_LoginPage(DriverFactory.getDriver());
		picoDepInj.loginPage.enterValidCredentials(username, password);
	}

	@When("admin user click on login button")
	public void admin_user_click_on_login_button() {
		picoDepInj.loginPage.clickOnLoginBtn();
	}

	@Then("user should be login as admin and redirected to admin LMS dashboard page")
	public void user_should_be_login_as_admin_and_redirected_to_admin_lms_dashboard_page() {
		picoDepInj.programPage = new POM_ProgramPage(DriverFactory.getDriver());
		picoDepInj.programPage.verifyDashbordPageTitle();
		
	}

	@Given("admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		picoDepInj.programPage.verifyDashbordPageTitle();
	}

	@When("admin clicks Program on the navigation bar")
	public void admin_clicks_program_on_the_navigation_bar() {
		picoDepInj.programPage.clickOnNavigationProgramBtn();
	}

	@Then("admin should see URL with Manage Program")
	public void admin_should_see_url_with_manage_program() {
	    
	}

	@Then("admin should see a heading with text Manage Program on program page")
	public void admin_should_see_a_heading_with_text_manage_program_on_program_page(){
		picoDepInj.programPage.verifyProgramPageHeader();
	}

	@When("admin validating the default state of Delete button")
	public void admin_validating_the_default_state_of_delete_button() {
		picoDepInj.programPage.verifyDeleteBtnStatus();
	}

	@Then("admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		picoDepInj.programPage.verifyDeleteBtnStatus();
	}

	@When("admin user Validates Add New Program button")
	public void admin_user_validates_add_new_program_button() {
		picoDepInj.programPage.verifyNewProgramBtn();
	}

	@Then("admin should see a +A New Program button as enabled on the program page above the data table")
	public void admin_should_see_a_a_new_program_button_as_enabled_on_the_program_page_above_the_data_table() {
		picoDepInj.programPage.verifyNewProgramBtn();
	}

	@When("admin verifyes Search bar on the Program page above data table")
	public void admin_verifyes_search_bar_on_the_program_page_above_data_table() {
		picoDepInj.programPage.verifySearchBox();
	}

	@Then("admin should see Search bar with text as Search...")
	public void admin_should_see_search_bar_with_text_as_search() {
		picoDepInj.programPage.verifySearchBox();
	}

	@Given("admin is on program page after Login")
	public void admin_is_on_program_page_after_login() {
		picoDepInj.programPage.verifyProgramPageHeader();
	}

	@When("verify data table on the Program page")
	public void verify_data_table_on_the_program_page() {
		picoDepInj.programPage.verifyDataTablePresent();
	}

	@Then("admin should see data table on Manage Program Page with following column headers as Program Name, Program Description, Program Status, Edit,Delete")
	public void admin_should_see_data_table_on_manage_program_page_with_following_column_headers_as_program_name_program_description_program_status_edit_delete() {
		picoDepInj.programPage.verifyDataTableColumnsName();
	}

	@When("validate that number of records or rows of data displayed  in the table")
	public void validate_that_number_of_records_rows_of_data_in_the_table_displayed() {
		
		boolean rowSize = picoDepInj.programPage.verifyDataTableRowsPresent();
		Assert.assertEquals(rowSize, true);
	}

	@Then("admin should see total number of records on default page as {int} in the table")
	public void admin_should_see_total_number_of_records_on_default_page_as_in_the_table(Integer noOfRowInDatatable) {
	
		Assert.assertEquals(picoDepInj.programPage.verifyNoOfRowInDataTable(), noOfRowInDatatable);
	}

	@When("verify check box for rows on the data table")
	public void verify_check_box_for_rows_on_the_data_table() {
		Assert.assertEquals(picoDepInj.programPage.verifyDataTableCheckBoxes(), true);
	}

	@Then("admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
		Assert.assertEquals(picoDepInj.programPage.verifyCheckboxesCountInDataTable(), 5);
	}

	@When("verify Edit and Delete buttons for data table")
	public void verify_edit_and_delete_buttons_for_data_table() {
		Assert.assertTrue(picoDepInj.programPage.verifyRowEditBtnsPresenst());
		Assert.assertTrue(picoDepInj.programPage.verifyRowDeleteBtnsPresenst());
	}

	@Then("admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		
		Assert.assertTrue(picoDepInj.programPage.verifyEditBtnsOnEachRow());
		Assert.assertTrue(picoDepInj.programPage.verifyDeleteBtnsOnEachRow());
		
	}
	@When("admin clicks on A New Program button")
	public void admin_clicks_on_a_new_program_button() throws InterruptedException {
		picoDepInj.programPage.clickOnANewProgramBtn();
	}
	@Then("a popup with title as Program details should get opened along with empty name and description input boxes")
	public void a_popup_with_title_as_program_details_should_get_opened_along_with_empty_name_and_description_input_boxes() {

		picoDepInj.programPage.verifyNewProgPopUpInputFields();
	}
	@When("admin verifies program details pop up UI")
	public void admin_verifies_program_details_pop_up_ui() {
		LoggerLoad.info("admin user verifying new program pop UI");
	}
	@Then("admin should see Close Icon ,SAVE, CANCEL button and Active,Inactive Status radio buttons on popup")
	public void admin_should_see_Close_Icon_SAVE_CANCEL_button_and_Active_Inactive_Status_radio_buttons_on_popup() {
		picoDepInj.programPage.verifyNewProgramPopUpUI();
	}
	
	@When("admin select program status as {string} on pop window")
	public void admin_select_program_status_as_on_pop_window(String prgStatus) {
	   
		LoggerLoad.info("admin selected prgram status as :"+prgStatus);
		picoDepInj.programPage.clickOnStatusRadioBtn(prgStatus);
		
	}
	
	@Then("admin gets messages alert for Name as {string} and Desc as {string}")
	public void admin_gets_messages_alert_for_name_as_and_desc_as(String nameAlertMsg, String descAlertMsg) {
		
		String nameAlertTextMsg = picoDepInj.programPage.getNameAlertMsg();
		LoggerLoad.info("actual name alert msg : "+nameAlertTextMsg);	
		LoggerLoad.info("Expected name alert msg : "+nameAlertMsg);	
		Assert.assertEquals(nameAlertTextMsg, nameAlertMsg);
		
		String descAlertTextMsg = picoDepInj.programPage.getDescAlertMsg();
		LoggerLoad.info("actual desc alert msg : "+descAlertTextMsg);	
		LoggerLoad.info("Expected desc alert msg : "+descAlertMsg);	
		
		Assert.assertEquals(descAlertTextMsg, descAlertMsg);
	}
	
	@Then("admin gets messages alert for Name field as {string}")
	public void admin_gets_messages_alert_for_Name_field_as(String invalidNameAlertMsg) {
		String nameAlertTextMsg = picoDepInj.programPage.getNameAlertMsg();
		LoggerLoad.info("actual alert msg : "+nameAlertTextMsg);	
		LoggerLoad.info("Expected alert msg : "+invalidNameAlertMsg);		
		Assert.assertEquals(nameAlertTextMsg, invalidNameAlertMsg);
	}
	@Then("admin gets messages alert for Desc field as {string}")
	public void admin_gets_messages_alert_for_Desc_field_as(String numberOnlyAlertMsg) {
		
		String descAlertTextMsg = picoDepInj.programPage.getDescAlertMsg();
		LoggerLoad.info("actual alert msg : "+descAlertTextMsg);	
		LoggerLoad.info("Expected alert msg : "+numberOnlyAlertMsg);		
		Assert.assertEquals(descAlertTextMsg, numberOnlyAlertMsg);
	}
	
	
	@When("admin enters New Program details Name as {string} and Description as {string} on pop up window")
	public void admin_enters_new_program_details_name_as_and_description_as_on_pop_up_window(String prgName, String pegDesc) {
		picoDepInj.programPage.enterProgamDetails(prgName, pegDesc);
	}
	
	@When("click on Cancel button on program pop window")
	public void click_on_cancel_button_on_program_pop_window() {
		picoDepInj.programPage.clickOnCancelBtn();
	}

	@Then("program popup window should disappears")
	public void program_popup_window_should_disappears() {
		boolean popupPresence = picoDepInj.programPage.verifyNewprgPopUpDisapper();
		LoggerLoad.info("is New Prg pop up disappered :"+popupPresence);
		Assert.assertTrue(popupPresence);
	}

	@Then("click on Close icon on program pop window")
	public void click_on_close_icon_on_program_pop_window() {
		picoDepInj.programPage.clickOnCloseIcon();
	}

	@Then("click on Save button on program pop window")
	public void click_on_Save_button_on_program_pop_window() {
		picoDepInj.programPage.clickOnSaveBtn();
	}
	
	@Then("admin should see a successfully message alert for created new program")
	public void admin_should_see_a_successfully_message_alert_for_created_new_program() {
		LoggerLoad.info("admin should see successful program creation msg");
		picoDepInj.programPage.verifyPrgmSuccessAlert();	
	
		}
	@Then("New program {string} should get created in program data table")
	public void new_program_should_get_created_in_program_data_table(String createdPrgName) {		
			
		String filtredPrgname = picoDepInj.programPage.verifyPrgmNameInDataTable(createdPrgName);
		LoggerLoad.info("admin should see created program name in data table :"+filtredPrgname);
		Assert.assertTrue(filtredPrgname.contains(createdPrgName));
	}
	
	@When("admin enters existing Program details Name as {string} and Description as {string} on pop up window")
	public void admin_enters_existing_program_details_name_as_and_description_as_on_pop_up_window(String existingPrgName, String pegDesc) {
		picoDepInj.programPage.enterProgamDetails(existingPrgName, pegDesc);
	}
	
	@Then("admin should see a message alert for duplicate prgm as {string}")
	public void admin_should_see_a_message_alert_for_duplicate_prgm_as(String expectedPrgNameAlertMsg) {
	
		
		String actualExistingPrgNameAlert = picoDepInj.programPage.getNameAlertMsg();
		LoggerLoad.info("admin should see existing program creation alert msg :"+actualExistingPrgNameAlert);
		Assert.assertTrue(expectedPrgNameAlertMsg.contains(actualExistingPrgNameAlert));
	
	}
	@When("admin enters New Program details on pop up window from test data sheet {string} and row number {int}")
	public void admin_enters_new_program_details_on_pop_up_window_from_test_data_sheet_program_test_data_and_row_number(String sheetName,Integer rowNum) throws IOException {
		
		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testdata = excelReader.getTestDataFromSheet(sheetName);
		
		String prgname = testdata.get(rowNum).get("PrgName");
		String desc = testdata.get(rowNum).get("PrgDesc");
	    String status = testdata.get(rowNum).get("Status");	    
		picoDepInj.programPage.sendSheetPrgDetails(prgname, desc, status);
		LoggerLoad.info("sending all input feilds value to prog popup");
	}

	@Then("admin should see alert message under respective field as per sheet {string} and row number {int}")	
	public void admin_should_see_alert_message_under_respective_field(String sheetName,Integer rowNum) throws IOException {
		
		LoggerLoad.info("validating alert messages for progm popup input feilds");
		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testdata = excelReader.getTestDataFromSheet(sheetName);
		
		String sheetNameAlert = testdata.get(rowNum).get("NameAlert");
		String sheetDescAlert = testdata.get(rowNum).get("DescAlert");
	    String sheetStatusAlert = testdata.get(rowNum).get("StatusAlert");	   
	    //String expectedAlert = sheetNameAlert+""+sheetDescAlert+""+sheetStatusAlert;
	    String actualAlert;
	    String expectedAlert;
	    switch(rowNum) 
	    {
	    case 0:
	      {  
	    	 actualAlert = picoDepInj.programPage.verifyAllAlertMsg();
	    	 expectedAlert = sheetNameAlert+""+sheetDescAlert+""+sheetStatusAlert;
	    	 
	    	 LoggerLoad.info("Actual alert message :"+actualAlert);
			 LoggerLoad.info("expected alert message :"+expectedAlert);				
	    	 Assert.assertEquals(actualAlert, expectedAlert);
	    	 break;
	      }
	    case 1:		    
	      {	 
	    	String nameAlert = picoDepInj.programPage.getNameAlertMsg();
	    	String statusAlert = picoDepInj.programPage.getStatusAlertMsg();
	    	
	    	actualAlert = nameAlert+""+statusAlert;
	    	expectedAlert = sheetNameAlert+""+sheetDescAlert+""+sheetStatusAlert;
	    	LoggerLoad.info("Actual alert message :"+actualAlert);
			LoggerLoad.info("expected alert message :"+expectedAlert);
			
			Assert.assertEquals(actualAlert, expectedAlert);
			break;
	      }
	    case 2:		    
	      {	 
	    	String descAlert = picoDepInj.programPage.getDescAlertMsg();
	    	String statusAlert = picoDepInj.programPage.getStatusAlertMsg();
	    	
	    	actualAlert = descAlert+""+statusAlert;
	    	expectedAlert = sheetNameAlert+""+sheetDescAlert+""+sheetStatusAlert;
	    	LoggerLoad.info("Actual alert message :"+actualAlert);
			LoggerLoad.info("expected alert message :"+expectedAlert);
			
			Assert.assertEquals(actualAlert, expectedAlert);
			break;
	      }
	    case 3:		    
	      {	 
	    	String nameAlert = picoDepInj.programPage.getNameAlertMsg();
	    	String descAlert = picoDepInj.programPage.getDescAlertMsg();
	    	
	    	actualAlert = nameAlert+""+descAlert;
	    	expectedAlert = sheetNameAlert+""+sheetDescAlert+""+sheetStatusAlert;
	    	LoggerLoad.info("Actual alert message :"+actualAlert);
			LoggerLoad.info("expected alert message :"+expectedAlert);
			
			Assert.assertEquals(actualAlert, expectedAlert);
			break;
	      }
	      
	    case 4|5:		    
	      {	 
	    	String nameAlert = picoDepInj.programPage.getNameAlertMsg();
	    	actualAlert = nameAlert;
	    	expectedAlert = sheetNameAlert+""+sheetDescAlert+""+sheetStatusAlert;
	    	LoggerLoad.info("Actual alert message :"+actualAlert);
			LoggerLoad.info("expected alert message :"+expectedAlert);
			Assert.assertEquals(actualAlert, expectedAlert);
			break;
	      }
	      
	    case 6|7:		    
	      {	 
	    	String descAlert = picoDepInj.programPage.getDescAlertMsg();		    	
	    	actualAlert = descAlert;
	    	expectedAlert = sheetNameAlert+""+sheetDescAlert+""+sheetStatusAlert;
	    	LoggerLoad.info("Actual alert message :"+actualAlert);
			LoggerLoad.info("expected alert message :"+expectedAlert);
			Assert.assertEquals(actualAlert, expectedAlert);
			break;
	      }
	    } 
	}
	
	
	@When("admin select first program from datatable")
	public void admin_select_first_program_from_datatable() {
		
		LoggerLoad.info("admin validates datatable rows and select prg from ");
		picoDepInj.programPage.verifyDataTableRowsPresent();
		picoDepInj.programPage.selectFirstPrgBtn();
		
	}	
	
	@When("click on edit button for selected program")
	public void click_on_edit_button_for_selected_program() {
		picoDepInj.programPage.clickOnEditPrgBtn();
		
	}

	@Then("edit program pop up window should appears with program details")
	public void edit_program_pop_up_window_should_appears_with_program_details() {
		picoDepInj.programPage.verifyNewProgramPopUpUI();
	}

	@When("admin changes only program name")
	public void admin_changes_only_program_name() {
		
		picoDepInj.updatedPrgName =  "UpdateNameTest";
		picoDepInj.programPage.updatePrgName(picoDepInj.updatedPrgName);
	}

	@Then("admin should see a alert message for program updated successfull")
	public void admin_should_see_a_alert_message_for_program_updated_successfull() {
		picoDepInj.programPage.verifyPrgmUpdateSuccessAlert();
	}

	@Then("admin can see that program name should get updated in datatable")
	public void admin_can_see_that_program_name_should_get_updated_in_datatable() {
		
		String entredName = picoDepInj.updatedPrgName;
		LoggerLoad.info("updated program Name in data table :"+entredName);
		String actualUpdatedname = picoDepInj.programPage.verifyPrgmNameInDataTable(entredName);
		Assert.assertTrue(actualUpdatedname.contains(entredName));
		
	}

	@When("admin changes only program description")
	public void admin_changes_only_program_description() {
		
		picoDepInj.updatedPrgDesc =  "UpdateDescTest";		
		picoDepInj.programPage.updatePrgDesc(picoDepInj.updatedPrgDesc);	
		
	}

	@Then("admin should see a alert message for successfull program updated")
	public void admin_should_see_a_alert_message_for_successfull_program_updated() {
		picoDepInj.programPage.verifyPrgmUpdateSuccessAlert();
	}
	
	@Then("admin can see that program desc should get updated in datatable")
	public void admin_can_see_that_program_desc_should_get_updated_in_datatable() {
	    
		String entredDesc = picoDepInj.updatedPrgDesc;
		LoggerLoad.info("updated program desc in data table :"+entredDesc);
		String actualUpdatedDesc = picoDepInj.programPage.verifyPrgmDescInDataTable(entredDesc);
		Assert.assertTrue(actualUpdatedDesc.contains(entredDesc));
		
	}

	@When("admin edit only program status")
	public void admin_edit_only_program_status() {
		picoDepInj.programPage.updatePrgStatus();
	}
	@Then("admin can see that program status should get updated in datatable")
	public void admin_can_see_that_program_status_should_get_updated_in_datatable() {
	    
	}
	@When("admin updates exiting program details Name as {string}, Description as {string} and status as {string} on pop up window")
	public void admin_updates_exiting_program_details_name_and_description_and_status_on_pop_up_window(String PrgName, String PrgDesc,String prgStatus) {
		
		LoggerLoad.info("entering invalid prg name and desc to get alert msg.");		
		picoDepInj.programPage.updateInvalidProgamDetails(PrgName, PrgDesc);
		
		LoggerLoad.info("admin selected prgram status as :"+prgStatus);
		picoDepInj.programPage.clickOnStatusRadioBtn(prgStatus);
		
	}
	
	@When("admin verifys programs present in datatable")
	public void admin_verifys_programs_present_in_datatable() {
		boolean rowSize = picoDepInj.programPage.verifyDataTableRowsPresent();
		Assert.assertEquals(rowSize, true);
	}

	@When("click on delete button for first program")
	public void click_on_delete_button_for_first_program() {
		picoDepInj.programPage.clickOnFirstDeleteBtn();
	}

	@Then("delete alert pop up window should appears with YES and NO buttons")
	public void delete_alert_pop_up_window_should_appears_with_yes_and_no_buttons() {
		picoDepInj.programPage.verifyDeletePopUpAppears();
	}

	@When("admin verifys Confirm Deletion text on delete alert")
	public void admin_verifys_confirm_deletion_text_on_delete_alert() {
		
		picoDepInj.deletedPrgName =picoDepInj.programPage.verifyTextOnDeletePopUp();
		
		LoggerLoad.info("program name in confirm delete text: "+picoDepInj.deletedPrgName);
	}

	@When("admin click on YES button on delete alert")
	public void admin_click_on_yes_button_on_delete_alert() {
		picoDepInj.programPage.clickOnDeleteYesBtn();
	}

	@Then("admin should see successfull alert message for program deletation")
	public void admin_should_see_successfull_alert_message_for_program_deletation() {
		picoDepInj.programPage.verifyDeleteSuccessAlert();
	}

	@Then("admin can see that program should get deleted from datatable")
	public void admin_can_see_that_program_should_get_deleted_from_datatable() {
		LoggerLoad.info("verify deleted prg name not present in table");		
		String deletedPName= picoDepInj.deletedPrgName;
		boolean prgNamePresentOrNot = picoDepInj.programPage.verifyPrgDeletedFrmTableOrNot(deletedPName);
		Assert.assertFalse(prgNamePresentOrNot);
	}

	@When("admin click on NO button on delete alert")
	public void admin_click_on_no_button_on_delete_alert() {
		picoDepInj.programPage.clickOnDeleteNoBtn();
	}

	@Then("delete alert should disappears")
	public void delete_alert_should_disappears() {
		picoDepInj.programPage.verifyDeletePopUpDisapper();
	}

	@Then("admin can see that program should not get deleted from datatable")
	public void admin_can_see_that_program_should_not_get_deleted_from_datatable() {
		
		LoggerLoad.info("verify deleted prg not get deleted frm table");		
		String deletedPName= picoDepInj.deletedPrgName;
		boolean prgNamePresentOrNot = picoDepInj.programPage.verifyPrgDeletedFrmTableOrNot(deletedPName);
		Assert.assertTrue(prgNamePresentOrNot);
	}

	@When("admin click on close icon on delete alert")
	public void admin_click_on_close_icon_on_delete_alert() {
		picoDepInj.programPage.clickOnCloseIcon();
	}

	@When("admin verifys common delete button is disabled by default")
	public void admin_verifys_common_delete_button_is_disabled_by_default() {
		picoDepInj.programPage.verifyDeleteBtnStatus();
	}

	@When("admin select only one program checkbox")
	public void admin_select_only_one_program_checkbox() {
		picoDepInj.programPage.selectFirstPrgBtn();
	}

	@Then("common delete button should be enabled")
	public void common_delete_button_should_be_enabled() {
		picoDepInj.programPage.verifyTopDeleteEnabledBtn();
	}

	@When("admin click on common delete button above header for selection")
	public void admin_click_on_common_delete_button_above_header_for_selection() {
		picoDepInj.programPage.clickOnTopDeleteBtn();
	}

	@When("admin verifys Confirm Deletion text on common delete alert pop up")
	public void admin_verifys_confirm_deletion_text_on_common_delete_alert_pop_up() {
		
		String deleteConfirmText = picoDepInj.programPage.getTextOnTopDeletePopUp();		
		Assert.assertEquals(deleteConfirmText, "Are you sure you want to delete the selected programs?");
	}

	@When("admin select multiple program checkboxes")
	public void admin_select_multiple_program_checkboxes() {
		picoDepInj.programPage.selecMultipleCheckBox();
	}

	@Then("admin can see those programs should get deleted from datatable")
	public void admin_can_see_those_programs_should_get_deleted_from_datatable() {
		LoggerLoad.info("verify deleted prg name not present in table");	
		//Assert.assertFalse(picoDepInj.programPage.verifyMultiProgmPresentInTableOrNot());
	}

	@Then("admin should see successfull alert message for multiple program deletation")
	public void admin_should_see_successfull_alert_message_for_multi_program_deletation() {
		picoDepInj.programPage.verifyMultiDeleteSuccessAlert();;
	}
	
	@Then("admin can see those programs should not get deleted from datatable")
	public void admin_can_see_those_programs_should_not_get_deleted_from_datatable() {
		
		LoggerLoad.info("verify prg name not get deleted from table");		
		
		Assert.assertTrue(picoDepInj.programPage.verifyMultiProgmPresentInTableOrNot());
	}
	
	@When("admin click on Batch link on navigation bar")
	public void admin_click_on_Batch_link_on_navigation_bar() {
		picoDepInj.programPage.clickOnNavigationBatchLink();
		
	}
	@Then("Admin is re-directed to Batch page")
	public void Admin_is_re_directed_to_Batch_page() {
		
		Assert.assertTrue(picoDepInj.programPage.getBatchPageUrl().contains("batch"));
	}
	
	@When("admin click on User link on navigation bar")
	public void admin_click_on_User_link_on_navigation_bar() {
		picoDepInj.programPage.clickOnNavigationUserLink();
		
	}
	@Then("Admin is re-directed to User page")
	public void Admin_is_re_directed_to_User_page() {
		
		Assert.assertTrue(picoDepInj.programPage.getUserPageUrl().contains("/user"));
	}
	@When("admin click on Logout link on navigation bar")
	public void admin_click_on_Logout_link_on_navigation_bar() {
		
		picoDepInj.programPage.clickOnNavigationLogOutLink();
	}
	@Then("Admin is re-directed to Login page")
	public void Admin_is_re_directed_to_Login_page() {
		
		Assert.assertTrue(picoDepInj.programPage.getLoginPageUrl().contains("/login"));
	}
    
	@When("admin validates the pagination icon below the data table")
	public void admin_validates_the_pagination_icon_below_the_data_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("admin should see all the pagination controls under the data table")
	public void admin_should_see_all_the_pagination_controls_under_the_data_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("admin verifys Next page link status for more than {int} record on table")
	public void admin_verifys_next_page_link_status_for_more_than_record_on_table(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("admin should see Next page link should be active on pagination")
	public void admin_should_see_next_page_link_should_be_active_on_pagination() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("admin click on active Next link on pagination")
	public void admin_click_on_active_next_link_on_pagination() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Start and First page link should be active")
	public void start_and_first_page_link_should_be_active() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("admin clicks on active Last page link on pagination")
	public void admin_clicks_on_active_last_page_link_on_pagination() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("admin clicks active First page link on pagination")
	public void admin_clicks_active_first_page_link_on_pagination() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("admin clicks active Start page link on pagination")
	public void admin_clicks_active_start_page_link_on_pagination() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("admin should see the very first page record on the table with Previous and start page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_and_start_page_link_are_disabled() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("admin clicks the sort icon of program name column")
	public void admin_clicks_the_sort_icon_of_program_name_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("table data should get sorted based upon the program name column values in ascending order")
	public void table_data_should_get_sorted_based_upon_the_program_name_column_values_in_ascending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

   @Then("table data should get sorted based upon the program name column values in descending order")
	public void table_data_should_get_sorted_based_upon_the_program_name_column_values_in_descending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("admin clicks the sort icon of program description column")
	public void admin_clicks_the_sort_icon_of_program_description_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("table data should get sorted based upon the program description column values in ascending order")
	public void table_data_should_get_sorted_based_upon_the_program_description_column_values_in_ascending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("table data should get sorted based upon the program description column values in descending order")
	public void table_data_should_get_sorted_based_upon_the_program_description_column_values_in_descending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("admin clicks the sort icon of program status column")
	public void admin_clicks_the_sort_icon_of_program_status_column() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("table data should get sorted based upon the program status column values in ascending order")
	public void table_data_should_get_sorted_based_upon_the_program_status_column_values_in_ascending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("table data should get sorted based upon the program status column values in descending order")
	public void table_data_should_get_sorted_based_upon_the_program_status_column_values_in_descending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
