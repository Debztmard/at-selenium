package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para a criação das novas PageObjects Todas pages devem ser herdadas dessa classe
 */
public abstract class BasePO {

    /**
     * Driver base que será usado pelas pages
     */
    protected WebDriver driver;

    /**
     * Construtor base para a criação da fábrica de elementos (PageFactory).
     * 
     * @param driver Driver da página atual.
     */
    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Método que retorna o título da página atual.
     * 
     * @return
     */
    public String obterTituloPagina() {
        return driver.getTitle();
    }

    /**
     * Método que sabe escrever em qualquer WebElement do tipo input e dá um TAB no final.
     * 
     * @param input Input em que será escrito.
     * @param texto Texto que será escrito no input.
     */
    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
}
