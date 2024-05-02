package stepDefinitions;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_BatchPage;
import utilities.LoggerLoad;
import utilities.PicoDependencyInjector;

public class StepDef_BatchPageValidation {
	PicoDependencyInjector picoDepInj;
	String successMsg="";

	public StepDef_BatchPageValidation(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;
		picoDepInj.batchPage = new POM_BatchPage(DriverFactory.getDriver());
	}
	
	@When("Admin clicks {string} from navigation bar in the Batch Page")
	public void admin_clicks_from_navigation_bar_in_the_batch_page(String string) {
		
		picoDepInj.batchPage.clickOnBatchBtn();
		LoggerLoad.info("Admin clicked on Batch button to navigate to Manage Batch page");
	}
	
	@Then("Admin should see the word {string} in the URL")
	public void admin_should_see_the_word_in_the_url(String string) {
		
			String batchUrl = picoDepInj.batchPage.getCurrentUrl();
			try {
				Assert.assertTrue(batchUrl.contains("batch"));
			} catch (Exception e) {
				LoggerLoad.info(e.getMessage());
			}
		}
	 
	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String string) {
		
	   successMsg= picoDepInj.batchPage.batchTitle();
	   Assert.assertEquals(successMsg, string);
	   LoggerLoad.info("the batch is seen in the header");
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		 
		   boolean result = picoDepInj.batchPage.verifyPaginationButtons();
	        Assert.assertTrue(result, "Pagination controls are not present");
	        	    
	}
	@Then("Admin Should see the data table with headers in {string} with Batch name, Batch Description,Batch Status,Number of classes, Program Name, EditDelete")
	public void the_admin_should_see_the_data_table_headers_in_as_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete(String string) {
	   	
		Assert.assertTrue(picoDepInj.batchPage.IsPageLoaded(string));
		LoggerLoad.info("The Batch headers are present");
	}
	@Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {
		Assert.assertTrue(picoDepInj.batchPage.verifyDeleteIconDisabled());
		LoggerLoad.info("The Batch delete icon is present");
		}
	
	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String string) {
		Assert.assertTrue(picoDepInj.batchPage.verifyAddNewBatchBtnEnabled());
		LoggerLoad.info("The Batch add icon is present");
	    
	}

	@Then("every row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
		Assert.assertTrue(picoDepInj.batchPage.verifyCheckBoxEnabledForEachRow());
		LoggerLoad.info("The Batch check box is present");
	    
	}
	@Then("Each row in the data table should have edit icon which is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		
		Assert.assertTrue(picoDepInj.batchPage.verifyEditButtonEnabledForEachRow());
		LoggerLoad.info("The Edit button is enabled on each row");
	}
	@Then("Each row in the data table should have a delete icon which is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
	 
		Assert.assertTrue(picoDepInj.batchPage.verifyDeleteButtonEnabledForEachRow());
		LoggerLoad.info("The Delete button is enabled on each row");
	}
	@When("Admin clicks {string} button in the Batch Page")
	public void admin_clicks_button_in_the_batch_page(String string) {
		picoDepInj.batchPage.clickOnBatchBtn();
		picoDepInj.batchPage.ClickAddNewBatchBtn();
		LoggerLoad.info("The add new batch button is clicked");
	}

	@Then("A new pop up with Batch details appears")
	public void a_new_pop_up_with_batch_details_appears() {
		Assert.assertTrue(picoDepInj.batchPage.isBatchDialogBoxDisplayed());
		LoggerLoad.info("The batch pop up window is present");
	    
	}

}
