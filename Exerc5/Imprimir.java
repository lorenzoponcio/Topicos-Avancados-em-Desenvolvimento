package Exerc5;

public class Imprimir implements Runnable{

    private final Transferir transferir;

    public Imprimir(Transferir transferir){
        this.transferir = transferir;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            synchronized (transferir) {
                System.out.println(transferir);
            }
            try{
                Thread.sleep(5000);
            }catch(InterruptedException ie){
                Thread.currentThread().interrupt();
            }
        }
    }
    
}
