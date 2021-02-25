package com.qa.Demosphere.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.Demosphere.base.BaseTest;
import com.qa.Demosphere.utils.Constants;

public class HomePageTest extends BaseTest{
		
	@Test	
	public void failed_search_criteria() {
		String search_result = homepage.do_Search("Ties");
		System.out.println(search_result);
		System.out.println(homepage.alert);
		Assert.assertEquals(search_result,Constants.HOME_PAGE_ZERO_RESULTS);
	}

	@Test
	public void good_search_criteria() {
		String search_result = homepage.do_Search("Dresses");
		System.out.println(search_result);
		System.out.println(homepage.count);
		Assert.assertEquals(search_result,Constants.HOME_PAGE_RESULTS);
	}
}
