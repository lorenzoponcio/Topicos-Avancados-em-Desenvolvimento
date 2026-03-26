package Exerc5;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class SistemaTransferencia implements Runnable {
    private final Banco banco;
    private final Random random = new Random();
    private final AtomicInteger contador;
    private volatile boolean rodando = true;

    public Transferir(Banco banco, AtomicInteger contador) {
        this.banco = banco;
        this.contador = contador;
    }

    public void parar() {
        rodando = false;
    }

    @Override
    public void run() {
        int tamanho = banco.getContas().size();

        while (rodando) {
            int origem = random.nextInt(tamanho);
            int destino = random.nextInt(tamanho);

            if (origem != destino) {
                double valor = random.nextDouble() * 2500;

                banco.transferir(origem, destino, valor);
                contador.incrementAndGet();
            }
        }
    }
}