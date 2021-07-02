package br.com.prime.project.pageObjects;

import br.com.prime.project.support.Browser;

public class BasePage {

	protected Browser browser;

	public static final String BASE_URL = "https://demosite.executeautomation.com";

	public BasePage(Browser browser) {
		if (browser == null) {
			this.browser = new Browser();
		} else {
			this.browser = browser;
		}
	}

	public String withoutAccent(String text) {
		return browser.noAccent(text);
	}
	public void quit() {
		browser.quit();
	}

}
