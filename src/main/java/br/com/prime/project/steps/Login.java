package br.com.prime.project.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import br.com.prime.project.pageObjects.LoginPage;
import br.com.prime.project.pageObjects.UserFormPage;
import br.com.prime.project.support.Browsers;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	private LoginPage login;
	private UserFormPage userForm;

	@Given("Eu navego para a pagina de login")
	public void eu_navego_para_a_pagina_de_login() {
		login = new LoginPage();
		login.accessLoginPage(Browsers.CHROME);
		assertTrue(login.isLoginPage());
	}

	@When("Eu faco o login")
	public void eu_faco_o_login(DataTable dataTable) {
		List<Map<String, String>> _users = dataTable.asMaps();
		for (Map<String, String> _user : _users) {
			userForm = login.doLogin(_user.get("userName"), _user.get("password"));
		}
	}

	@Then("Eu devo ver a pagina de formulario do usuario")
	public void eu_devo_ver_a_pagina_de_formulario_do_usuario() {
		assertTrue(userForm.isUserFormPage());
		userForm.quit();
	}
}
