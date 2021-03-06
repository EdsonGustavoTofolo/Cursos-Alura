package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class PageObject {
    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser = browser;
    }

    public PageObject() {
        this(null);
        this.browser = new ChromeDriver();
    }

    public String getCurrentUrl() {
        return browser.getCurrentUrl();
    }

    public void quitPage() {
        this.browser.quit();
    }

    public void navigateTo(String url) {
        this.browser.navigate().to(url);
    }

}
