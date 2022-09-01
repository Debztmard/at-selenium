package automatizado.build;

import automatizado.page.ControleProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela.
 */
public class ProdutoBuilder {

    private String codigo = "0001";
    private String nome = "Produto padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "31/08/2022";

    private ControleProdutoPO controleProdutoPO;

    /**
     * Construtor do ProdutoBuilder que recebe a página de controle de produtos.
     * 
     * @param controleProdutoPO
     */
    public ProdutoBuilder(ControleProdutoPO controleProdutoPO) {
        this.controleProdutoPO = controleProdutoPO;
    }

    /**
     * Método que sabe adicionar um codigo ao builder.
     * 
     * @param codigo Codigo que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    /**
     * Método que sabe adicionar um nome ao builder.
     * 
     * @param nome Nome que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * Método que sabe adicionar quantidade ao builder.
     * 
     * @param quantidade Quantidade que será adicionada.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    /**
     * Método que sabe adicionar um valor ao builder.
     * 
     * @param valor Valor que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarValor(Double valor) {
        this.valor = valor;
        return this;
    }

    /**
     * Método que sabe adicionar uma data ao builder.
     * 
     * @param data Data que será adicionada.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarData(String data) {
        this.data = data;
        return this;
    }

    /**
     * Método que constrói o produto, ou seja, adicionar o produto na tela de cadastro do produto
     */
    public void builder() {
        controleProdutoPO.escrever(controleProdutoPO.inputCodigo, codigo);
        controleProdutoPO.escrever(controleProdutoPO.inputNome, nome);
        controleProdutoPO.escrever(controleProdutoPO.inputQuantidade,
                (quantidade != null) ? quantidade.toString() : "");
        controleProdutoPO.escrever(controleProdutoPO.inputValor,
                (valor != null) ? valor.toString() : "");
        controleProdutoPO.escrever(controleProdutoPO.inputData, data);

        controleProdutoPO.buttonSalvar.click();
    }
}
