package Exerc4;

import java.util.List;

public class Imprimir implements Runnable{

    private final List<Short> lista;

    public Imprimir(List<Short> lista){
        this.lista = lista;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            synchronized (lista) {
                System.out.println(lista);
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){
                Thread.currentThread().interrupt();
            }
        }
    }
}