package com.apptest.screens;

import org.openqa.selenium.WebElement;

import com.apptest.utils.LOCATORS;

public class HomeScreen extends AppScreenBase {

	/**
	 * Clicks on coupons icon in the navigation bar.
	 */
	public CouponScreen clickOnCoupons() {
		WebElement couponIcon = getWebElement(LOCATORS.XPATH,
				"//android.widget.FrameLayout[@content-desc=\"Coupons\"]/android.view.ViewGroup/android.widget.TextView");
		clickElement(couponIcon);
		return new CouponScreen();
	}

	/**
	 * Clicks on home button in the navigation bar.
	 * */
	public HomeScreen clickOnHome() {
		WebElement homeIcon = getWebElement(LOCATORS.XPATH,
				"//android.widget.FrameLayout[@content-desc=\"Aktuell\"]/android.view.ViewGroup/android.widget.TextView");
		clickElement(homeIcon);
		return this;
	}

}
