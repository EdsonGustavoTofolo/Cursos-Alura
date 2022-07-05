package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

    /*
     * Baixar o driver do chrome conforme compatibilidade de versões
	 * https://chromedriver.chromium.org/downloads
     */
    @Test
    public void hello() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/leiloes");
        browser.quit();
    }
}
