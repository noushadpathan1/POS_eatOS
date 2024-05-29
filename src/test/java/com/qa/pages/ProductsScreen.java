package com.qa.pages;

import com.qa.utils.CommonUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductsScreen extends BasePage {

	CommonUtils utils = new CommonUtils();
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='PRODUCTS']")
	private WebElement titleTxt;
	@AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Settings Tab 4 of 4\"]")
	public WebElement settingsButton;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]")
	public WebElement settingsFrame;

	public String getIdText(){
		switchFrame(settingsFrame);
		return getAttributeValue(settingsButton,"content-desc");
	}

	public String getTitle() {
		return getText(titleTxt, "product page title is - ");
	}

}
