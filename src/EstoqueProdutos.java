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

    /**
     * Method that help us in the task of generate a string that represents an
     * object of this class
     */
    public String toString() {
        String ret = "{EstoqueProduto: [";
        if (estoqueProdutosMap.size() == 0) {
            return ret + "]}";
        }
        for (Produto produto: this.estoqueProdutosMap.values()) {
            ret += "nome: " + produto.getNome() + ", preço: " +  produto.getPreco() + ", quantidade: " +  produto.getQuantidade() + "; ";
        }
        return ret.substring(0, ret.length() - 2) + "]}";
    }

    /**
     * Main method to manual tests
     *
     * @param args Arguments, normally passed through CLI (ignored)
     */
    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();
        System.out.println(estoqueProdutos);

        estoqueProdutos.adicionarProduto(1, "bala", 0.1, 100);
        estoqueProdutos.adicionarProduto(2, "pirulito", 0.5, 50);
        estoqueProdutos.adicionarProduto(3, "chiclete", 0.2, 70);
        System.out.println(estoqueProdutos);

        // The data of one product will be updated
        estoqueProdutos.adicionarProduto(3, "gelinho", 1.5, 10);
        estoqueProdutos.exibirProdutos();

        System.out.println("O valor total do estoque é: " + estoqueProdutos.calcularValorTotalEstoque());

        System.out.println("O produto mais caro do estoque é: " + estoqueProdutos.obterProdutoMaisCaro());
    }
}
