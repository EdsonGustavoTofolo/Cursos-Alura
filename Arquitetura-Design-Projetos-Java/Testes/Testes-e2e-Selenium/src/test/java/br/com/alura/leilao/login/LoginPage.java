package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leilao.LeilaoListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {

    public LoginPage() {
    }

    public String getUsuarioLogado() {
        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean pageContainsMessageUsuarioSenhaInvalidos() {
        return browser.getPageSource().contains("Usuário e senha inválidos");
    }

    public boolean pageContainsDadosLeilao() {
        return browser.getPageSource().contains("Dados do Leilão");
    }

    public LoginPage fillForm(String username, String password) {
        this.browser.findElement(By.id("username")).sendKeys(username);
        this.browser.findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public LeilaoListPage submitForm() {
        this.browser.findElement(By.id("login-form")).submit();
        return new LeilaoListPage(this.browser);
    }

    public LoginPage navigateToLogin() {
        this.browser.navigate().to("http://localhost:8080/login");
        return this;
    }
}
