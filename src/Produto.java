public class Produto {
    /**
     * Name of the product
     */
    private String nome;

    /**
     * Price of the product
     */
    private double preco;

    /**
     * Quantity of the product
     */
    private int quantidade;

    /**
     * Constructor
     */
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    /**
     * Getter of this.nome
     * 
     * @return this.nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Getter of this.preco
     * 
     * @return this.preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Getter of this.quatidade
     * 
     * @return this.quantidade
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     * Help in the conversion of one object of this class in a string
     */
    @Override
    public String toString() {
        return "{Produto: nome=" + this.nome + ",preco=" + this.preco + ", quantidade=" + this.quantidade + "}";
    }
}
