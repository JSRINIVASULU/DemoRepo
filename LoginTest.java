package com.qa.test;

import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

import io.appium.java_client.MobileElement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	ProductsPage productPage;
  
  @BeforeClass
  public void beforeClass() {
  }
  @BeforeMethod
  public void beforeMethod(Method m) {
	  loginPage = new LoginPage();
	  System.out.println("\n"+"********** Starting test **********"+m.getName()+ "*******"+"\n");
  }
  @Test
  public void invalidUserName() {
	  
	  loginPage.enterUserName("invalidusername");
	  loginPage.enterUserPassword("secret_sauce");
	  loginPage.pressLoginBtn();
	  
	  String actText = loginPage.getErrorTxt();
	  String expText = "Username and password do not match any user in this service.";
	  System.out.println("Actual Error Msg :  "+actText+ "\n"+"Expected Error Msg :  "+expText);
	  Assert.assertEquals(actText, expText);
	  
	  
  }
  
  @Test
  public void invalidPassword() {
	  
	  loginPage.enterUserName("standard_user");
	  loginPage.enterUserPassword("invalidpassword");
	  loginPage.pressLoginBtn();
	  
	  String actText = loginPage.getErrorTxt();
	  String expText = "Username and password do not match any user in this service.";
	  System.out.println("Actual Error Msg :  "+actText+ "\n"+"Expected Error Msg :  "+expText);
	  Assert.assertEquals(actText, expText);
  }
  
  @Test
  public void successfulLogin() {
	  
	  loginPage.enterUserName("standard_user");
	  loginPage.enterUserPassword("secret_sauce");
	  productPage = loginPage.pressLoginBtn();
	 
	  String actText = productPage.getTitle();
	  String expText = "PRODUCTS";
	  System.out.println("Actual Product Text :  "+actText +"\n"+"Expected Product Text : "+expText);
	  
	  Assert.assertEquals(actText, expText);
	  
	  
  }
  @AfterMethod
  public void afterMethod() {
  }
  @AfterClass
  public void afterClass() {
  }

}
