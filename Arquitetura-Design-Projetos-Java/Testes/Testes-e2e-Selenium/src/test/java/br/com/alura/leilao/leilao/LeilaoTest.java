package br.com.alura.leilao.leilao;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeilaoTest {
    private LeilaoListPage leilaoListPage;
    private LeilaoFormPage leilaoFormPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage();

        this.leilaoListPage = loginPage.navigateToLogin()
                .fillForm("fulano", "pass")
                .submitForm();

        this.leilaoFormPage = this.leilaoListPage.navigateToNewLeilao();
    }

    @AfterEach
    public void tearDown() {
        this.leilaoListPage.quitPage();
    }

    @Test
    public void deveriaCadastrarLeilao() {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia " + data;
        String valor = "500.00";

        this.leilaoListPage = this.leilaoFormPage.fillForm(nome, valor, data).submitForm();

        Assertions.assertTrue(this.leilaoListPage.isLeilaoCadastrado(nome, valor, data));
    }

    @Test
    public void deveriaValidarCadastroDeLeilao() {
        this.leilaoFormPage.fillForm("", "", "").submitForm();

        Assertions.assertFalse(this.leilaoFormPage.isCurrentPage());
        Assertions.assertTrue(this.leilaoFormPage.isValidationsMessagesDisplayed());
    }
}
