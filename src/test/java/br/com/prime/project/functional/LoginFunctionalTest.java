package br.com.prime.project.functional;

import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.github.javafaker.Faker;

import br.com.prime.project.pageObjects.LoginPage;
import br.com.prime.project.pageObjects.UserFormPage;
import br.com.prime.project.support.Browsers;

public class LoginFunctionalTest {

	private LoginPage login;
	private Faker fake = new Faker(new Locale("pt-br"));
	private String userName;
	private String password;
	private UserFormPage userForm;

	@Before
	public void setup() {
		login = new LoginPage();
		userName = login.withoutAccent(fake.name().username());
		password = fake.internet().password();
	}
	
	@After
	public void tearDown() {
		login.quit();
	}
	
	@Test
	public void deveAcessarAPaginadeLoginComOGoogleChrome() {
		login.accessLoginPage(Browsers.CHROME);
		assertTrue(login.isBrowserName(Browsers.CHROME.capabilityName()));
		assertTrue(login.isLoginPage());
	}
	
	@Test
	public void deveAcessarAPaginadeLoginComOMicrosoftEdge() {
		login.accessLoginPage(Browsers.EDGE);
		assertTrue(login.isBrowserName(Browsers.EDGE.capabilityName()));
		assertTrue(login.isLoginPage());
	}
	
	@Test
	public void deveAcessarAPaginadeLoginComOMozillaFireFox() {
		login.accessLoginPage(Browsers.FIREFOX);
		assertTrue(login.isBrowserName(Browsers.FIREFOX.capabilityName()));
		assertTrue(login.isLoginPage());
	}

	@Test
	public void deveAcessarAPaginadeLoginComOInternetExplorer() {
		login.accessLoginPage(Browsers.IE);
		assertTrue(login.isBrowserName(Browsers.IE.capabilityName()));
		assertTrue(login.isLoginPage());
	}
	
	@Test
	public void deveAcessarAPaginadeLoginComOOpera() {
		login.accessLoginPage(Browsers.OPERA);
		assertTrue(login.isBrowserName(Browsers.OPERA.capabilityName()));
		assertTrue(login.isLoginPage());
	}
	
	@Test
	public void deveRealizarLoginComOGoogleChrome() {
		login.accessLoginPage(Browsers.CHROME);
		userForm = login.doLogin(userName, password);
		assertTrue(userForm.isUserFormPage());
	}
	
	@Test
	public void deveRealizarLoginComOMicrosoftEdge() {
		login.accessLoginPage(Browsers.EDGE);
		userForm = login.doLogin(userName, password);
		assertTrue(userForm.isUserFormPage());
	}
	
	@Test
	public void deveRealizarLoginComOMozillaFirefox() {
		login.accessLoginPage(Browsers.FIREFOX);
		userForm = login.doLogin(userName, password);
		assertTrue(userForm.isUserFormPage());
	}
	
	@Ignore("Login no IE é muito lento para executar")
	@Test
	public void deveRealizarLoginComOInternetExplorer() {
		login.accessLoginPage(Browsers.IE);
		userForm = login.doLogin(userName, password);
		assertTrue(userForm.isUserFormPage());
	}
	
	@Test
	public void deveRealizarLoginComOOpera() {
		login.accessLoginPage(Browsers.OPERA);
		userForm = login.doLogin(userName, password);
		assertTrue(userForm.isUserFormPage());
	}

}
