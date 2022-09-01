package automatizado.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automatizado.build.ProdutoBuilder;
import automatizado.page.ControleProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleProdutoTest extends BaseTest {

    private static LoginPO loginPage;
    private static ControleProdutoPO controleProdutoPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleProdutoPO(driver);

        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
        controleProdutoPage.buttonAdicionar.click();

        // TODO: Remover esse click assim que o sistema for corrigido.
        controleProdutoPage.buttonAdicionar.click();

        String titulo = controleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);

        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();
    }

    // @Test
    // public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
    // controleProdutoPage.buttonAdicionar.click();
    // controleProdutoPage.buttonAdicionar.click();

    // controleProdutoPage.cadastrarProduto("001", "martelo", 10, 39.9, "");

    // assertEquals("Todos os campos são obrigatórios para o cadastro!",
    // controleProdutoPage.spanMensagem.getText());
    // }

    @Test
    public void TC003_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {

        String mensagem = "Todos os campos são obrigatórios para o cadastro!";

        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();

        // Aqui cria o objeto para adicionar na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        // Aqui testa se o produto é adicionado sem código
        produtoBuilder.adicionarCodigo("").builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui testa se o produto é adicionado sem quantidade
        produtoBuilder.adicionarCodigo("0003").adicionarQuantidade(null).builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui testa se o produto é adicionado sem nome
        produtoBuilder.adicionarCodigo("0004").adicionarNome("").builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui testa se o produto é adicionado sem valor
        produtoBuilder.adicionarNome("Parafuso").adicionarValor(null).builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui testa se o produto é adicionado sem data
        produtoBuilder.adicionarData("").builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());
    }
}
