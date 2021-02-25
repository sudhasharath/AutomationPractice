package com.qa.Demosphere.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Demosphere.base.BaseTest;


public class CartPageTest extends BaseTest {
	
	
@Test

public void manipulate_cart() throws InterruptedException {
		
	System.out.println(homepage.do_Search("dresses"));
	
	cartpage.cart_manipulation();
	
	Assert.assertEquals(cartpage.str_empty, "");
}

	
}
