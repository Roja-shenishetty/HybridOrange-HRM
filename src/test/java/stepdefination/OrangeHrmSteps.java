package stepdefination;

import org.openqa.selenium.WebDriver;

import commonFunctions.FunctionLibrary;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class OrangeHrmSteps {
	
	WebDriver driver; 

	@Given("I want to launch browser")
	public void i_want_to_launch_browser() throws Throwable {
	    FunctionLibrary.startBrowser();
	}

	@When("I launch url")
	public void i_launch_url() {
	    FunctionLibrary.openUrl();
	}

	@When("I wait for username  with {string} and {string} and {string}")
	public void i_wait_for_username_with_and_and(String ltype, String lvalue, String wait) throws Throwable {
	    FunctionLibrary.waitForElement(ltype, lvalue, wait);
	}

	@When("I enter username with {string} and {string} and {string}")
	public void i_enter_username_with_and_and(String ltype, String lvalue, String tdata) {
        FunctionLibrary.typeAction(ltype, lvalue, tdata);

	}

	@When("I enter password with {string} and {string} and {string}")
	public void i_enter_password_with_and_and(String ltype, String lvalue, String tdata) {
	   FunctionLibrary.typeAction(ltype, lvalue, tdata);
	}

	@When("I click login button with {string} and {string}")
	public void i_click_login_button_with_and(String ltype, String lvalue) throws Throwable {
	   FunctionLibrary.clickAction(ltype, lvalue);
	}

	@When("I wait for PIM link with {string} and {string} and {string}")
	public void i_wait_for_pim_link_with_and_and(String ltype, String lvalue, String tdata) throws Throwable {
	   FunctionLibrary.waitForElement(ltype, lvalue, tdata);
	}

	@When("I click PIM link with {string} and {string}")
	public void i_click_pim_link_with_and(String ltype, String lvalue) throws Throwable {
	   FunctionLibrary.clickAction(ltype, lvalue);
	}

	@When("I wait for addEmployee link with {string} and {string} and {string}")
	public void i_wait_for_add_employee_link_with_and_and(String ltype, String lvalue, String tdata) throws Throwable {
	   FunctionLibrary.waitForElement(ltype, lvalue, tdata);
	}

	@When("I click addEmployee link with {string} and {string}")
	public void i_click_add_employee_link_with_and(String ltype, String lvalue) throws Throwable {
	   FunctionLibrary.clickAction(ltype, lvalue);
	}

	@When("I enter in {string} with {string} and {string}")
	public void i_enter_in_with_and(String tdata, String ltype, String lvalue) {
	   FunctionLibrary.typeAction(ltype, lvalue, tdata);
	}

	@When("I capture EmployeeId with {string} and {string}")
	public void i_capture_employee_id_with_and(String ltype, String lvalue) throws Throwable {
	   FunctionLibrary.captureData(ltype, lvalue);
	}

	@When("I click saveBtn with {string} and {string}")
	public void i_click_save_btn_with_and(String ltype, String lvalue) throws Throwable {
	   FunctionLibrary.clickAction(ltype, lvalue);
	}

	@When("I verify AddedEmployee")
	public void i_verify_added_employee() throws Throwable {
	    FunctionLibrary.empTable();
	}

	@When("I click Welcome link with {string} and {string}")
	public void i_click_welcome_link_with_and(String ltype, String lvalue) throws Throwable {
	    FunctionLibrary.clickAction(ltype, lvalue);
	}

	@When("I wait for logout link with {string} and {string} and {string}")
	public void i_wait_for_logout_link_with_and_and(String ltype, String lvalue, String tdata) throws Throwable {
	    FunctionLibrary.waitForElement(ltype, lvalue, tdata);
	}

	@When("I click logout link with {string} and {string}")
	public void i_click_logout_link_with_and(String ltype, String lvalue) throws Throwable {
	    FunctionLibrary.clickAction(ltype, lvalue);
	}

	@When("I close browser")
	public void i_close_browser() throws Throwable {
	    FunctionLibrary.closeBrowser();
	}



}
