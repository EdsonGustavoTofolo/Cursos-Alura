package br.com.alura.leilao.leilao;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeilaoFormPage extends PageObject {

    public LeilaoFormPage(WebDriver browser) {
        super(browser);
    }

    public LeilaoFormPage fillForm(String nome, String valorInicial, String dataAbertura) {
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        return this;
    }

    public LeilaoListPage submitForm() {
        this.browser.findElement(By.id("button-submit")).submit();
        return new LeilaoListPage(this.browser);
    }

    public boolean isCurrentPage() {
        return this.getCurrentUrl().equals("http://localhost:8080/leiloes/new");
    }

    public boolean isValidationsMessagesDisplayed() {
        String pageSource = this.browser.getPageSource();
        return pageSource.contains("minimo 3 caracteres") &&
                pageSource.contains("não deve estar em branco") &&
                pageSource.contains("deve ser um valor maior de 0.1") &&
                pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}
