package Test;

import Observer.Produto;
import org.junit.Test;
import java.util.Observable;
import java.util.Observer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProdutoTest {

    @Test
    public void testGetPreco() {
        Produto produto = new Produto("Camisa", 29.99);
        double precoEsperado = 29.99;
        double precoAtual = produto.getPreco();
        assertEquals(precoEsperado, precoAtual, 0.001);
    }

    @Test
    public void testSetPreco_NotifyObserversCalled() {
        Produto produto = new Produto("Camisa", 29.99);
        MockObserver observer = new MockObserver();
        produto.addObserver(observer);

        produto.setPreco(39.99);

        assertTrue(observer.updateCalled);
    }

    @Test
    public void testGetNome() {
        Produto produto = new Produto("Camisa", 29.99);
        String nomeEsperado = "Camisa";
        String nomeAtual = produto.getNome();
        assertEquals(nomeEsperado, nomeAtual);
    }

    private static class MockObserver implements Observer {
        public boolean updateCalled = false;

        @Override
        public void update(Observable observable, Object arg) {
            updateCalled = true;
        }
    }
}

