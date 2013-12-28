package com.example.clientalphaprototypeuitest;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ScanActivityUITest extends UiAutomatorTestCase {   

	public void testDemo() throws UiObjectNotFoundException, RemoteException, InterruptedException {  

		//Check if screen is asleep and wake/unlock as needed
		if (!getUiDevice().isScreenOn()){
			getUiDevice().wakeUp();
		}

		// Simulate a short press on the HOME button.
		getUiDevice().pressHome();

		UiObject allAppsButton = new UiObject(new UiSelector()
		.description("Apps"));

		// Simulate a click to bring up the All Apps screen.
		allAppsButton.clickAndWaitForNewWindow();

		UiObject appsTab = new UiObject(new UiSelector()
		.text("Apps"));

		// Simulate a click to enter the Apps tab.
		appsTab.click();

		UiScrollable appViews = new UiScrollable(new UiSelector()
		.scrollable(true));

		// Set the swiping mode to horizontal (the default is vertical)
		appViews.setAsHorizontalList();

		UiObject settingsApp = appViews.getChildByText(new UiSelector()
		.className(android.widget.TextView.class.getName()), 
				"ClientAlphaPrototype");
		settingsApp.clickAndWaitForNewWindow();

		// Validate that the package name is the expected one
		UiObject clientalphaprototypeValidation = new UiObject(new UiSelector()
		.packageName("com.example.clientalphaprototype"));
		assertTrue("Unable to detect ClientAlphaPrototype", 
				clientalphaprototypeValidation.exists()); 

		//Press Help Text
		//UiObject infoLayout = new UiObject(new UiSelector().className("android.widget.RelativeLayout").index(0));
		//UiObject textinfo = infoLayout.getChild(new UiSelector()
		//.className("android.widget.TextView").index(0));
		//textinfo.click();
		
		/*if(textinfo.exists()) 
		{	
			textinfo.click();	
		}*/
		
		//Press "I am ready to order"
		UiObject button_scan = new UiObject(new UiSelector().className("android.widget.Button").index(1));

		if(button_scan.exists() && button_scan.isEnabled()) 
		{
			button_scan.click();
		}

		UiScrollable categoryItem = new UiScrollable(new UiSelector()
		.className("android.widget.ListView"));

		//Press the 2nd Category in the list
		UiObject categoryitemlist = categoryItem.getChild(new UiSelector()
		.className("android.widget.RelativeLayout").index(1));
		categoryitemlist.click();

		//Press back button
		UiDevice.getInstance().pressBack();

		//Press the 1st Category in the list
		UiObject categoryitemlist2 = categoryItem.getChild(new UiSelector()
		.className("android.widget.TextView").index(0));
		categoryitemlist2.click();

		//Press the 1st Product in the list
		UiScrollable productItem = new UiScrollable(new UiSelector()
		.className("android.widget.ListView"));
		UiObject productitemlist = productItem.getChild(new UiSelector()
		.className("android.widget.RelativeLayout").index(0));

		productitemlist.click();
		UiScrollable textScroll = new UiScrollable(new UiSelector()
		.className("android.widget.ScrollView"));
		
		textScroll.scrollToEnd(2);

		//Write down some notes for the product
		UiObject noteField = new UiObject(new UiSelector().className("android.widget.EditText").index(5));
		noteField.clearTextField();
		noteField.setText("Pita guro apo'la xwris kremmudi ");

		UiObject basketaddButton = new UiObject(new UiSelector().textStartsWith("Add to Basket"));

		if(basketaddButton.exists() && basketaddButton.isEnabled()) 
		{
			//Add it twice
			basketaddButton.click();
			basketaddButton.click();

		}

		//Go back 
		UiDevice.getInstance().pressBack();

		//Select the 2nd Product in the list
		UiObject productItem2 =productItem.getChild(new UiSelector()
		.className("android.widget.RelativeLayout").index(1));
		productItem2.click();

		//Leave some notes
		noteField.clearTextField();
		noteField.setText("Pita guro apo'la :P kai svelta giati peinaw! ");

		//Change Images
		UiScrollable imagesTabsheet = new UiScrollable(new UiSelector()
		.className("android.widget.Gallery"));
		UiObject imagetab1 = imagesTabsheet.getChild(new UiSelector()
		.className("android.widget.ImageView").index(0));

		UiObject imagetab2 = imagesTabsheet.getChild(new UiSelector()
		.className("android.widget.ImageView").index(1));

		UiObject imagetab3 = imagesTabsheet.getChild(new UiSelector()
		.className("android.widget.ImageView").index(2));

		imagetab2.click();
		imagetab3.click();
		imagetab1.click();

		if(basketaddButton.exists() && basketaddButton.isEnabled()) 
		{
			basketaddButton.click();

		}
		UiScrollable topbar = new UiScrollable(new UiSelector()
		.className("android.widget.FrameLayout"));

		UiObject basketButton = topbar.getChild(new UiSelector()
		.className("android.widget.Button").index(1));

		if(basketButton.exists() && basketButton.isEnabled()) 
		{
			//Go to basket
			basketButton.click();
		}

		//Delete the 1st product
		UiObject productinBasket = new UiObject(new UiSelector().className("android.widget.RelativeLayout").index(0));
		productinBasket.swipeRight(0);

		if(basketButton.exists() && basketButton.isEnabled()) 
		{
			basketButton.click();
		}

		//Press Submit Button
		basketButton.click();
		
		UiObject menuButton = new UiObject(new UiSelector().className("android.widget.LinearLayout").index(2));
		menuButton.click();
		
		UiObject menuList = new UiObject(new UiSelector().className("android.widget.ListView").index(0));
		
		UiObject menuButtonChild2 = menuList.getChild(new UiSelector()
		.className("android.widget.LinearLayout").index(1));
		menuButtonChild2.click();
		

	}   
}
