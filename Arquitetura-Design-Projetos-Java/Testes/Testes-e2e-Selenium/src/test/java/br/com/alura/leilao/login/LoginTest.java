package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setup() {
        this.loginPage = new LoginPage();
    }

    @AfterEach
    public void tearDown() {
        this.loginPage.quitPage();
    }

    @Test
    public void deveriaRealizarLoginComDadosValidos() {
        this.loginPage.navigateToLogin()
                .fillForm("fulano", "pass")
                .submitForm();

        Assertions.assertNotEquals("http://localhost:8080/login", this.loginPage.getCurrentUrl());
        Assertions.assertEquals("fulano", this.loginPage.getUsuarioLogado());
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {
        this.loginPage.navigateToLogin()
                .fillForm("invalido", "123")
                .submitForm();

        Assertions.assertEquals("http://localhost:8080/login?error", this.loginPage.getCurrentUrl());
        Assertions.assertTrue(this.loginPage.pageContainsMessageUsuarioSenhaInvalidos());
        Assertions.assertNull(this.loginPage.getUsuarioLogado());
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        this.loginPage.navigateTo("http://localhost:8080/leiloes/2");

        Assertions.assertEquals("http://localhost:8080/login", this.loginPage.getCurrentUrl());
        Assertions.assertFalse(this.loginPage.pageContainsDadosLeilao());
    }
}
