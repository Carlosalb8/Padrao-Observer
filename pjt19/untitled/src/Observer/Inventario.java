package Observer;

import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.util.List;
public class Inventario implements Observer {
    private List<Produto> produtos;

    public Inventario() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        produto.addObserver(this);
    }

    public void update(Observable observable, Object arg) {
        if (observable instanceof Produto) {
            Produto produto = (Produto) observable;
            System.out.println("Produto atualizado: " + produto.getNome() + ", novo preço: " + produto.getPreco());
        }
    }
}