package com.qa.Demosphere.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Demosphere.base.BaseTest;
import com.qa.Demosphere.pages.CreateAccountPage;
import com.qa.Demosphere.utils.Constants;

public class CreateAccountPageTest extends BaseTest {

	@Test(priority=1)
	public void verify_authentication() {
		createaccountpage.click_on_signin_button();
		Assert.assertEquals(createaccountpage.auth_text,Constants.CREATEACCOUNT_PAGE_AUTH_TEXT);
	}
	
	@Test(priority=2)
	public void enter_personal_information() {
		createaccountpage.create_account_with_details(prop);
		Assert.assertEquals(createaccountpage.success_text,Constants.CREATEACCOUNT_PAGE_SUCCESS_TEXT);
	}
	
	@Test(priority=3)
	public void click_on_signout_link() {
		createaccountpage.clickon_signout_link();
		Assert.assertEquals(createaccountpage.auth_text,Constants.CREATEACCOUNT_PAGE_AUTH_TEXT);
	}
	
	@Test(priority=4)
	public void create_failed_account() {
		createaccountpage.createfailed_account();
		Assert.assertEquals(createaccountpage.error_text,Constants.CREATEACCOUNT_PAGE_ERROR_TEXT);
	}
}
