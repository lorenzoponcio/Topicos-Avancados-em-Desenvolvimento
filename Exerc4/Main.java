package Exerc4;

import java.util.ArrayList;
/*COLLECION NÃO SÃO THREADSAFE*/
public class Main {
    public static void main(String[] args) {

        ArrayList<Short> lista = new ArrayList<Short>();
        new Thread(new Incluir(lista)).start();
        new Thread(new Incluir(lista)).start();
        new Thread(new Remover(lista)).start();
        new Thread(new Imprimir(lista)).start();

        System.out.println(lista);

    }
}