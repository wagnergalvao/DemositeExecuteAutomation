package br.com.prime.project.pageObjects;

import org.openqa.selenium.By;

import br.com.prime.project.support.Browsers;

public class LoginPage extends BasePage {

	private String LOGIN_URL = BASE_URL + "/Login.html";
	private By userNameBy = By.name("UserName");
	private By passwordBy = By.name("Password");
	private By loginBy = By.id("userName");

	public LoginPage() {
		super(null);
	}

	public void accessLoginPage(Browsers browsers) {
		browser.open(browsers, false);
		browser.navigateTo(LOGIN_URL, false);
	}

	public boolean isLoginPage() {
		return browser.currentUrlEqualsIgnoreCase(LOGIN_URL);
	}

	public UserFormPage doLogin(String userName, String password) {
		browser.sendKeys(userNameBy, userName);
		browser.sendKeys(passwordBy, password);
		browser.submit(loginBy);
		return new UserFormPage(browser);
	}

	public boolean isBrowserName(String capabilityName) {
		return capabilityName.equals(browser.getBrowserName());
	}
}
