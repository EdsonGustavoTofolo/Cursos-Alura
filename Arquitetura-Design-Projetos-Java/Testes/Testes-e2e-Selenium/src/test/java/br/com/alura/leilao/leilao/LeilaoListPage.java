package br.com.alura.leilao.leilao;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeilaoListPage extends PageObject {

    public LeilaoListPage(WebDriver browser) {
        super(browser);
    }

    public LeilaoFormPage navigateToNewLeilao() {
        this.navigateTo("http://localhost:8080/leiloes/new");
        return new LeilaoFormPage(this.browser);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String data) {
        WebElement tableRow = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement columnNome = tableRow.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement columnDataAbertura = tableRow.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement columnValorInicial = tableRow.findElement(By.cssSelector("td:nth-child(3)"));

        return columnNome.getText().equals(nome) &&
                columnDataAbertura.getText().equals(data) &&
                columnValorInicial.getText().equals(valor);
    }
}
