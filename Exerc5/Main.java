package Exerc5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Transferir transferir = new Transferir(100, 1000.0); // equivalente ao Banco
        AtomicInteger contadorTransacoes = new AtomicInteger(0);

        List<Transferir> sistemas = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        // Criando 5 threads de transferência
        for (int i = 0; i < 5; i++) {
            Transferir sistema = new Transferir(transferir, contadorTransacoes);
            Thread t = new Thread(sistema);
            sistemas.add(sistema);
            threads.add(t);
            t.start();
        }

        // 🔥 Thread de impressão
        Imprimir imprimir = new Imprimir(transferir);
        Thread threadImprimir = new Thread(imprimir);
        threadImprimir.start();

        // Tempo de execução: 3 minutos
        Thread.sleep(180000);

        // Parar threads de transferência
        for (Transferir sistema : sistemas) {
            sistema.parar();
        }

        for (Thread t : threads) {
            t.join();
        }

        // 🛑 Parar thread de impressão
        threadImprimir.interrupt();
        threadImprimir.join();

        // Resultado final
        double totalFinal;
        synchronized (transferir) {
            totalFinal = transferir.getSaldoTotal();
        }

        System.out.println("\n===== RESULTADO FINAL =====");
        System.out.println("Total de transações: " + contadorTransacoes.get());
        System.out.println("Saldo final no banco: R$ " + totalFinal);
    }
}