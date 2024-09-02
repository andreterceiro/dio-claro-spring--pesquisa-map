import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    /**
     * Map of products
     */
    private Map<Long, Produto> estoqueProdutosMap;

    /**
     * Constructor
     */
    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    /**
     * Adds a product to the internal HashMap
     *
     * @param chave      Key related to the value to be added
     * @param nome       Name of the product to be added
     * @param preco      Price of the product to be added
     * @param quantidade Quantity of the product to be added
     */
    public void adicionarProduto(long chave, String nome, double preco, int quantidade) {
        this.estoqueProdutosMap.put(
            chave,
            new Produto(nome, preco, quantidade)
        );
    }

    /**
     * Print the products that are in the internal map
     */
    public void exibirProdutos() {
        System.out.println(this.estoqueProdutosMap);
    }

    /**
     * For all products in the stock (internal map), calculates the price plus the quantity
     * then returns the sum of each multiplication
     *
     * @return Return the sum of this.preco * this.quantidade of every product
     */
    public double calcularValorTotalEstoque() {
        double total = 0d;
        if (! this.estoqueProdutosMap.isEmpty()) {
            // There are severeal ways to iterate over a map
            // like (using only the values in this exemple):
            // for (Produto produto: this.estoqueProdutos.values())
            for (Map.Entry<Long, Produto> item: this.estoqueProdutosMap.entrySet()) {
                total += item.getValue().getPreco() * item.getValue().getQuantidade();
            }
        }
        return total;
    }

    /**
     * Returns the product of the this.estoqueProdutoMap with the bigger price
     * (independent of the quantity)
     *
     * @return Return the product with the bigger price (independent of the quantity)
     */
    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (! this.estoqueProdutosMap.isEmpty()) {
            for (Produto produto: this.estoqueProdutosMap.values()) {
                if (produto.getPreco() > maiorPreco) {
                    produtoMaisCaro = produto;
                }
            }
        }
        return produtoMaisCaro;
    }
}
