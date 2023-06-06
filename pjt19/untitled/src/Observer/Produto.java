package Observer;

import java.util.Observable;

public class Produto extends Observable {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
        setChanged();
        notifyObservers();
    }

    public String getNome() {
        return nome;
    }
}