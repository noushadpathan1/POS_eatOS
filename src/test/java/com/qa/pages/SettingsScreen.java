package com.qa.pages;

import com.qa.utils.CommonUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SettingsScreen extends BasePage {
	CommonUtils utils = new CommonUtils();
	
	@AndroidFindBy (accessibility="test-LOGOUT")
	private WebElement logoutBtn;
	
	public LoginScreen pressLogoutBtn() {
		clickOnElement(logoutBtn, "press Logout button");
		return new LoginScreen();
	}


}
