Feature: Login

	Como usuário
	Quero fazer login
	Para acessar a página de formulário do usuário

  Scenario: Login com usuario e senha
    Given Eu navego para a pagina de login
    When Eu faco o login
      | userName  | password      |
      | admin     | adminpassword |
    Then Eu devo ver a pagina de formulario do usuario
