public class Desafio implements Runnable {

    private int[] numeros;
    private int inicio;
    private int fim;
    private int soma;

    public Desafio(int[] numeros, int inicio, int fim) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fim; i++) {
            soma += numeros[i];
        }
    }

    public int getSoma() {
        return soma;
    }

    public static void main(String[] args) {

        int tamanho = 1000000;
        int qtdThreads = 100;

        int[] vetor = new int[tamanho];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = 1;
        }

        Thread[] threads = new Thread[qtdThreads];
        Desafio[] tarefas = new Desafio[qtdThreads];

        int parte = vetor.length / qtdThreads;

        for (int i = 0; i < qtdThreads; i++) {

            int inicio = i * parte;
            int fim = inicio + parte;

            tarefas[i] = new Desafio(vetor, inicio, fim);
            threads[i] = new Thread(tarefas[i]);

            threads[i].start();
        }

    }
}