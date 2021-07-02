package br.com.prime.project.pageObjects;

import org.openqa.selenium.By;

import br.com.prime.project.support.Browser;
import br.com.prime.project.support.Expected_Conditions;

public class UserFormPage extends BasePage{

	private String USER_FORM_URI = "/index.html";
	private By generateButton = By.name("generate");

	public UserFormPage(Browser browser) {
		super(browser);
	}
	
	public boolean isUserFormPage() {
		browser.waitUntilElement(generateButton, Expected_Conditions.ELEMENTTOBECLICKABLE);
		return browser.currentUrlContains(USER_FORM_URI);
	}

}
