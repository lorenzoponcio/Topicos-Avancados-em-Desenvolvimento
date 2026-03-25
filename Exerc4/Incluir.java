
package Exerc4;

import java.util.List;
import java.util.Random;

public class Incluir implements Runnable {

    private final List<Short> lista;

    public Incluir(List<Short> lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(!Thread.currentThread().isInterrupted()){
            lista.add((short) random.nextInt(1000));
        }
    }
}
