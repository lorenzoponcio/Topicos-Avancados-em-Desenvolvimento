public class Aula1 extends Thread{
    private int id;

    public Aula1(int id) {
        this.id = id;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread " + id + ": " + i);
            try {
                Thread.sleep(1000);  
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Aula1 thread = new Aula1(i);       
            thread.start();
        }

        System.out.println("Ok");

    }
}