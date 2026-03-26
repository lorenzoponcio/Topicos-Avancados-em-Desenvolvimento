package Exerc5;

class Conta {
    private double saldo;

    public Conta() {
        this.saldo = 1000.00;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }
}