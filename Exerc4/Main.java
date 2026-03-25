package Exerc4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*COLLECION NÃO SÃO THREADSAFE*/
public class Main {
    public static void main(String[] args) {

        List<Short> lista = Collections.synchronizedList(new ArrayList<Short>());
        Thread inc1 = new Thread(new Incluir(lista));
        Thread inc2 = new Thread(new Incluir(lista));
        Thread rem = new Thread(new Remover(lista));
        Thread imp = new Thread(new Imprimir(lista));

        inc1.start();
        inc2.start();
        rem.start();
        imp.start();

        // opcional: deixa as threads rodarem por um tempo
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        inc1.interrupt();
        inc2.interrupt();
        rem.interrupt();
        imp.interrupt();

        try {
            inc1.join();
            inc2.join();
            rem.join();
            imp.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final: " + lista);
    }
}