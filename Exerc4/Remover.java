package Exerc4;

import java.util.List;

public class Remover implements Runnable {

    private final List<Short> lista;

    public Remover(List<Short> lista) {
        this.lista = lista;
    }

    @Override
    public void run() { //busy wait
        while(!Thread.currentThread().isInterrupted()){
            if(!lista.isEmpty()){
                lista.remove(0);
            }
        }
    }
}